pluginManagement {
    repositories {
        google()
        mavenLocal()
        gradlePluginPortal()
    }
}
apply(from = "plugins.gradle.kts")
rootProject.name = "legacy-android-project"
include(":app")
