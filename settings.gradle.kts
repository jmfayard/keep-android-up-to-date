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
plugins {
  id("com.gradle.enterprise").version("3.0")
}

setupVersionPlaceholdersResolving()

rootProject.name = "keep-android-uptodate-final"

include(":app")


gradleEnterprise {

  buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"
    publishAlways()
  }
}
