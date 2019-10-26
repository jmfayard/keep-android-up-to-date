import de.fayard.OrderBy

plugins {
  `build-scan`
  id("de.fayard.refreshVersions")
  id("com.louiscad.splitties")
}

allprojects {
  repositories {
    google()
    jcenter()
  }
}

refreshVersions {
  useFqdnFor("espresso-core", "core-testing", "appcompat", "material", "aapt2", "constraintlayout", "lint-gradle", "annotations")
  orderBy = OrderBy.GROUP_AND_ALPHABETICAL
}

buildScan {
  termsOfServiceUrl = "https://gradle.com/terms-of-service"
  termsOfServiceAgree = "yes"
  publishAlways()
}

tasks.register("hello") {
  group = "custom"
  description = "Empty Hello World task, useful to debug build problems"
}

tasks.register<Delete>("clean") {
  group = "custom"
  description = "Delete build files"
  delete = setOf(".gradle", ".idea", "**.iml", "build", "app/build")
}

tasks.register("tests") {
  dependsOn(":app:testDebugUnitTest")
  group = "custom"
  description = "Run the unit tests"
}

tasks.register("install") {
  dependsOn(":app:installDebug")
  group = "custom"
  description = "Install the app"
}

tasks.register("androidTests") {
  dependsOn(":app:connectedDebugAndroidTest")
  group = "custom"
  description = "Run Android instrumention tets"
}

tasks.register<Copy>("apk") {
  dependsOn(":app:assembleRelease")
  group = "custom"
  description = "Build a release APK"
  val apkName = "${project.name}-versionCode-${findProperty("versionCode")}.apk"
  from("app/build/outputs/apk/release") {
    include("app-released-unsigned.apk")
    rename(".*", apkName)
  }
  into("build/apks")
  doLast {
    println("Created apk: " + project.file("build/apks/$apkName").absolutePath)
  }
}
