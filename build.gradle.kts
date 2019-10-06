// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.1.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.2.41")
    }
}
plugins {
    // ./gradlew --scan $TASKNAME 
    // see https://dev.to/jmfayard/the-one-gradle-trick-that-supersedes-all-the-others-5bpg
    id("com.gradle.build-scan").version("2.4.2")
    // :refreshVersions see https://github.com/jmfayard/buildSrcVersions/issues/77    
    id("de.fayard.buildSrcVersions").version("0.6.1")
    //  https://github.com/LouisCAD/Splitties/tree/develop/plugin
    id("com.louiscad.splitties") version "0.0.1" 
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
