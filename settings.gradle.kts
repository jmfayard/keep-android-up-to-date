import de.fayard.versions.setupVersionPlaceholdersResolving

pluginManagement {
  repositories {
    gradlePluginPortal()
    mavenCentral()
    google()
  }
}
buildscript {
  repositories {
    gradlePluginPortal()
    mavenCentral()
  }
  dependencies.classpath("de.fayard.refreshVersions:de.fayard.refreshVersions.gradle.plugin:0.8.5")
}
setupVersionPlaceholdersResolving()

rootProject.name = "legacy-android-project"
include(":app")
