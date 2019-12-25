import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import groovy.util.ConfigObject
import groovy.util.ConfigSlurper
import net.minecraftforge.gradle.user.ReobfMappingType
import org.gradle.jvm.tasks.Jar
import java.io.File
import java.util.Properties

plugins {
    scala
    //We apply these to get pretty build script
    java
    idea
    id("com.github.johnrengelman.shadow").version("2.0.4")
    id("net.minecraftforge.gradle.forge").version("2.3-SNAPSHOT")
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

sourceSets["main"].apply {
    java {
        setSrcDirs(listOf<File>())
    }
    withConvention(ScalaSourceSet::class) {
        scala {
            srcDir("src/main/java")
        }
    }
}

minecraft {
    version = "${config["mc_version"]}-${config["forge_version"]}"
    runDir = if (file("../run1.12").exists()) "../run1.12" else "run"
    mappings = "stable_39"
    // makeObfSourceJar = false // an Srg named sources jar is made by default. uncomment this to disable.

    replace("@VERSION@", project.version)
    replaceIn("LibMod.Scala")
}

repositories {
    maven {
        name = "TeamNightclipse Bintray"
        setUrl("https://dl.bintray.com/team-nightclipse/maven/")
    }
    jcenter()
    mavenLocal()
}

dependencies {
    compile("net.katsstuff.teamnightclipse:danmakucore:${config["danmaku_core_version"]}")
}

shadowJar.apply {
    classifier = "shaded"
    dependencies {
        exclude(dependency("com.chuusai:shapeless_2.11:2.3.3"))
        exclude(dependency("net.katsstuff.teamnightclipse:mirror:1.12.2-0.3.0"))
        exclude(dependency("net.katsstuff.teamnightclipse:danmakucore:${config["danmaku_core_version"]}"))
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

    from(sourceSets["main"].resources.srcDirs) {
        include("mcmod.info")
        expand(mapOf("version" to project.version, "mcversion" to minecraft.version))
    }

    from(sourceSets["main"].resources.srcDirs) {
        exclude("mcmod.info")
    }
}

fun parseConfig(config: File): ConfigObject {
    val prop = Properties()
    prop.load(config.reader())
    return ConfigSlurper().parse(prop)
}

idea.module.inheritOutputDirs = true

tasks["build"].dependsOn(shadowJar)

reobf.create("shadowJar") {
    mappingType = ReobfMappingType.SEARGE
}

tasks["reobfShadowJar"].mustRunAfter(shadowJar)
tasks["build"].dependsOn("reobfShadowJar")

artifacts {
    add("archives", shadowJar)
}
