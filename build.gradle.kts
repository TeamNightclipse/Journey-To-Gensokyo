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

apply {
    plugin("net.minecraftforge.gradle.forge")
}

plugins {
    scala
    //We apply these to get pretty build script
    java
    idea
    id("com.github.johnrengelman.shadow").version("2.0.4")
}

val compileJava: JavaCompile by tasks
val compileScala: ScalaCompile by tasks
val shadowJar: ShadowJar by tasks

val config = parseConfig(file("build.properties"))

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

compileJava.options.encoding = "UTF-8"
compileScala.scalaCompileOptions.additionalParameters = listOf("-Xexperimental")

version = "${config["mc_version"]}-${config["version"]}-${config["build_number"]}"
group = "net.katsstuff.teamnightclipse"
base.archivesBaseName = "journeyToGensokyo"

java.sourceSets {
    "main" {
        //Join compilation
        java {
            setSrcDirs(listOf<File>())
        }
        withConvention(ScalaSourceSet::class) {
            scala {
                srcDir("src/main/java")
            }
        }
    }
}

val minecraft = the<ForgeExtension>()
minecraft.apply {
    version = "${config["mc_version"]}-${config["forge_version"]}"
    runDir = if (file("../run1.12").exists()) "../run1.12" else "run"
    mappings = "snapshot_20171128"
    // makeObfSourceJar = false // an Srg named sources jar is made by default. uncomment this to disable.

    replace("@VERSION@", project.version)
    replaceIn("LibMod.Scala")
}

repositories {
    maven {
        name = "TeamNightclipse Bintray"
        setUrl("https://dl.bintray.com/team-nightclipse/maven/")
    }
}

dependencies {
    compile("net.katsstuff.teamnightclipse:danmakucore:1.12.2-0.7.0")
}

shadowJar.apply {
    classifier = "shaded"
    dependencies {
        exclude(dependency("com.chuusai:shapeless_2.11:2.3.3"))
        exclude(dependency("net.katsstuff.teamnightclipse:mirror:1.12.2-0.3.0"))
        exclude(dependency("net.katsstuff.teamnightclipse:danmakucore:1.12.2-0.7.0"))
    }
    exclude("dummyThing")
    relocate("shapeless", "net.katsstuff.mirror.shade.shapeless")
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

    from(java.sourceSets["main"].resources.srcDirs) {
        include("mcmod.info")
        expand(kotlin.collections.mapOf("version" to project.version, "mcversion" to minecraft.version))
    }

    from(java.sourceSets["main"].resources.srcDirs) {
        exclude("mcmod.info")
    }
}

fun parseConfig(config: File): ConfigObject {
    val prop = Properties()
    prop.load(config.reader())
    return ConfigSlurper().parse(prop)
}

idea.module.inheritOutputDirs = true

val reobf: NamedDomainObjectContainer<IReobfuscator> by extensions

tasks["build"].dependsOn(shadowJar)

artifacts {
    add("archives", shadowJar)
}

reobf {
    "shadowJar" {
        mappingType = ReobfMappingType.SEARGE
    }
}

tasks["reobfShadowJar"].mustRunAfter(shadowJar)
tasks["build"].dependsOn("reobfShadowJar")
