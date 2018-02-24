pluginManagement {
    repositories {
        jcenter()
        maven {
            name = "forge"
            setUrl("http://files.minecraftforge.net/maven")
        }
    }
}
include("DanmakuCore")
include("DanmakuCore:Mirror")
rootProject.name = "JourneyToGensokyo"