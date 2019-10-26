import de.fayard.OrderBy

plugins {
    // ./gradlew --scan $TASKNAME 
    // see https://dev.to/jmfayard/the-one-gradle-trick-that-supersedes-all-the-others-5bpg
    `build-scan`
    // :refreshVersions see https://github.com/jmfayard/buildSrcVersions/issues/77    
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

tasks.register("tests") {
    group = "custom"
    description = "Run the unit tests"
    dependsOn(":app:testDebugUnitTest")
}

tasks.register("install") {
    group = "custom"
    description = "Install the app"
    dependsOn(":app:installDebug")
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

tasks.register<Copy>("apk") {
    group = "custom"
    description = "Build a release APK"
    val apkName = "${project.name}-versionCode-${findProperty("versionCode")}.apk"
    dependsOn(":app:assembleRelease")
    from("app/build/outputs/apk/release") {
        include("app-released-unsigned.apk")
        rename(".*", apkName)
    }
    into("build/apks")
    doLast {
        println("Created apk: " + project.file("build/apks/$apkName").absolutePath)
    }
}
