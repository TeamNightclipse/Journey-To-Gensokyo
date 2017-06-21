import groovy.util.ConfigObject
import groovy.util.ConfigSlurper
import net.minecraftforge.gradle.user.patcherUser.forge.ForgeExtension
import org.gradle.api.internal.HasConvention
import org.gradle.jvm.tasks.Jar
import java.util.Properties

buildscript {
    repositories {
        jcenter()
        maven {
            name = "forge"
            setUrl("http://files.minecraftforge.net/maven")
        }
    }
    dependencies {
        classpath("net.minecraftforge.gradle:ForgeGradle:2.2-SNAPSHOT")
    }
}

apply {
    plugin("net.minecraftforge.gradle.forge")
}

plugins {
    scala
    //We apply these to get pretty build script
    java
    idea
}

val configFile = file("build.properties")
val config = parseConfig(configFile)

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

getTask<JavaCompile>("compileJava") {
    options.encoding = "UTF-8"
}

getTask<ScalaCompile>("compileScala") {
    scalaCompileOptions.additionalParameters = listOf("-Xexperimental")
}

version = "${config["mc_version"]}-${config["version"]}-${config["build_number"]}"
group = "net.katsstuff"
base.archivesBaseName = "danmakucore"

val mainSourceSet = java.sourceSets.get("main")
val javaSourceSet = mainSourceSet.java
val scalaSourceSet = (mainSourceSet as HasConvention).convention.getPlugin<ScalaSourceSet>().scala

//Join compilation
scalaSourceSet.srcDir("src/main/java")
javaSourceSet.setSrcDirs(listOf<File>())

val minecraft = the<ForgeExtension>()

configure<ForgeExtension> {
    version = "${config["mc_version"]}-${config["forge_version"]}"
    if (file("../run1.11").exists()) {
        runDir = "../run1.11"
    } else {
        runDir = "run"
    }

    // the mappings can be changed at any time, and must be in the following format.
    // snapshot_YYYYMMDD   snapshot are built nightly.
    // stable_#            stables are built at the discretion of the MCP team.
    // Use non-default mappings at your own risk. they may not allways work.
    // simply re-run your setup task after changing the mappings to update your workspace.
    mappings = "snapshot_20170612"
    // makeObfSourceJar = false // an Srg named sources jar is made by default. uncomment this to disable.

    replace("@VERSION@", project.version)
    replaceIn("LibMod.Scala")
}

dependencies {
    compile(project(":danmakuCore"))
}

getTask<ProcessResources>("processResources") {
    inputs.property("version", project.version)
    inputs.property("mcversion", minecraft.version)

    from(mainSourceSet.resources.srcDirs) {
        include("mcmod.info")
        expand(mapOf("version" to project.version, "mcversion" to minecraft.version))
    }

    from(mainSourceSet.resources.srcDirs) {
        exclude("mcmod.info")
    }
}

tasks {
    "incrementBuildNumber" {
        dependsOn("reobfJar")
        doLast {
            config["build_number"] = config["build_number"].toString().toInt() + 1
            config.toProperties().store(configFile.writer(), "")
        }
    }
}

fun parseConfig(config: File): ConfigObject {
    val prop = Properties()
    prop.load(config.reader())
    return ConfigSlurper().parse(prop)
}

idea.module.inheritOutputDirs = true

getTask<Jar>("jar") {
    exclude("**/*.psd")
}

defaultTasks("clean", "build", "incrementBuildNumber")

@Suppress("UNCHECKED_CAST")
fun <T: Task> Project.getTask(name: String, configuration: T.() -> Unit) = (tasks.get(name) as T).apply(configuration)