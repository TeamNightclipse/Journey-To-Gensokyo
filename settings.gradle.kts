pluginManagement {
    repositories {
        jcenter()
        gradlePluginPortal()
        maven {
            name = "forge"
            setUrl("http://files.minecraftforge.net/maven")
        }
    }
    resolutionStrategy {
        eachPlugin {
            if(requested.id.namespace == "net.minecraftforge.gradle") {
                useModule("net.minecraftforge.gradle:ForgeGradle:${requested.version}")
            }
        }
    }
}

