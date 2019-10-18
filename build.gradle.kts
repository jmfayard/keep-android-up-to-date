// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.1.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.50")
    }
}
plugins {
    // ./gradlew --scan $TASKNAME 
    // see https://dev.to/jmfayard/the-one-gradle-trick-that-supersedes-all-the-others-5bpg
    id("com.gradle.build-scan")
    // :refreshVersions see https://github.com/jmfayard/buildSrcVersions/issues/77    
    id("de.fayard.buildSrcVersions")
    //  https://github.com/LouisCAD/Splitties/tree/develop/plugin
    id("com.louiscad.splitties")
}


allprojects {
    repositories {
        google()
        jcenter()
    }
}


buildSrcVersions {
  // Documented at https://github.com/jmfayard/buildSrcVersions/issues/53
}

buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"
    publishAlways()
}

subprojects {
    tasks.whenTaskAdded {
        if (name == "test") enabled = false
    }
}

tasks.create("install") {
    group = "custom"
    description = "Install the app"
    dependsOn(":app:installDebug")
}

// TODO: remove :app:test
tasks.create("test") {
    group = "custom"
    description = "Run the unit tests"
    dependsOn(":app:testDebugUnitTest")
}

tasks.create("hello") {
    group = "custom"
    description = "Empty Hello World task, useful to debug build problems"
}
