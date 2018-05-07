import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import groovy.util.ConfigObject
import groovy.util.ConfigSlurper
import net.minecraftforge.gradle.user.IReobfuscator
import net.minecraftforge.gradle.user.ReobfMappingType
import net.minecraftforge.gradle.user.ReobfTaskFactory
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
        classpath("net.minecraftforge.gradle:ForgeGradle:2.3-SNAPSHOT")
    }
}

plugins {
    scala
    //We apply these to get pretty build script
    java
    idea
    id("com.github.johnrengelman.shadow").version("2.0.4")
}

apply {
    plugin("net.minecraftforge.gradle.forge")
}

val configFile = file("build.properties")
val config = parseConfig(configFile)

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<ScalaCompile> {
    scalaCompileOptions.additionalParameters = listOf("-Xexperimental")
}

version = "${config["mc_version"]}-${config["version"]}-${config["build_number"]}"
group = "net.katsstuff"
base.archivesBaseName = "journeyToGensokyo"

val mainSourceSet = java.sourceSets.get("main")
val javaSourceSet = mainSourceSet.java
val scalaSourceSet = (mainSourceSet as HasConvention).convention.getPlugin<ScalaSourceSet>().scala

//Join compilation
scalaSourceSet.srcDir("src/main/java")
javaSourceSet.setSrcDirs(listOf<File>())

val minecraft = the<ForgeExtension>()

configure<ForgeExtension> {
    version = "${config["mc_version"]}-${config["forge_version"]}"
    runDir = if (file("../run1.12").exists()) "../run1.12" else "run"
    isUseDepAts = true

    // the mappings can be changed at any time, and must be in the following format.
    // snapshot_YYYYMMDD   snapshot are built nightly.
    // stable_#            stables are built at the discretion of the MCP team.
    // Use non-default mappings at your own risk. they may not allways work.
    // simply re-run your setup task after changing the mappings to update your workspace.
    mappings = "snapshot_20171128"
    // makeObfSourceJar = false // an Srg named sources jar is made by default. uncomment this to disable.

    replace("@VERSION@", project.version)
    replaceIn("LibMod.Scala")
}

dependencies {
    compile(project("DanmakuCore"))
}

tasks.withType<ShadowJar> {
    classifier = ""
    relocate("shapeless", "net.katsstuff.mirror.shade.shapeless")
    dependencies {
        exclude(project("DanmakuCore"))
        exclude(project("DanmakuCore:Mirror"))
        exclude(dependency("com.chuusai:shapeless_2.11:2.3.3"))
    }
    exclude("dummyThing")
}

tasks.withType<Jar> {
    exclude("**/*.psd")
    manifest {
        attributes(mapOf("FMLAT" to "danmakucore_at.cfg"))
    }
}

tasks.withType<ProcessResources> {
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

idea.module.inheritOutputDirs = true

val reobf: NamedDomainObjectContainer<IReobfuscator> by extensions

tasks.get("build").dependsOn("shadowJar")

artifacts {
    add("archives", tasks.get("shadowJar"))
}

reobf {
    "shadowJar" {
        mappingType = ReobfMappingType.SEARGE
    }
}

tasks.get("reobfShadowJar").mustRunAfter("shadowJar")
tasks.get("build").dependsOn("reobfShadowJar")

tasks {
    "incrementBuildNumber" {
        dependsOn("reobfShadowJar")
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

defaultTasks("clean", "build", "incrementBuildNumber")