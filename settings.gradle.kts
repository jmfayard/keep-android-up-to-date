pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
    }
}
apply(from = "gradle/plugins.gradle.kts")
rootProject.name = "legacy-android-project"
include(":app")
