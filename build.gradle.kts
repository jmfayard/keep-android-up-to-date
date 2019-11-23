plugins {
  `build-scan`
  id("de.fayard.refreshVersions").version("0.8.4")
  id("com.louiscad.splitties").version("0.1.6")
}

allprojects {
  repositories {
    google()
    jcenter()
  }
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
  delete = setOf("build", "app/build")
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
