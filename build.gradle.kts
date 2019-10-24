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
    useFqdnFor("espresso-core", "core-testing", "appcompat", "material", "aapt2", "constraintlayout", "lint-gradle")
    orderBy = OrderBy.GROUP_AND_ALPHABETICAL
}

buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"
    publishAlways()
}

tasks.create("tests") {
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

