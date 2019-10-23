import com.louiscad.splitties.AndroidX
import com.louiscad.splitties.Google
import com.louiscad.splitties.Kotlin
import com.louiscad.splitties.Testing

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
    `build-scan`
    // :refreshVersions see https://github.com/jmfayard/buildSrcVersions/issues/77    
    id("de.fayard.refreshVersions").version("0.8.0")
    //  https://github.com/LouisCAD/Splitties/tree/develop/plugin
    id("com.louiscad.splitties").version("0.1.3")
}
allprojects {
    repositories {
        google()
        jcenter()
    }
}

fun envOrProperty(name: String, default: String): String =
    System.getenv(name.toUpperCase().replace(".", "_"))
        ?: findProperty(name.toLowerCase().replace("_", ".")) as? String
        ?: default

refreshVersions {
  // Documented at https://github.com/jmfayard/buildSrcVersions/issues/53
    propertiesFile = "versions.properties"
}

buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"
    publishAlways()
}

tasks.create("test") {
    group = "custom"
    description = "Run the unit tests"
}

tasks.create("install") {
    group = "custom"
    description = "Install the app"
    dependsOn(":app:installDebug")
}

tasks.create("hello") {
    group = "custom"
    description = "Empty Hello World task, useful to debug build problems"
}

tasks.withType<Wrapper> {
    gradleVersion = envOrProperty("version.gradleLatestVersion", gradle.gradleVersion)
}
