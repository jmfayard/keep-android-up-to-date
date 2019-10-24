
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

