import java.util.Properties

plugins {
    `kotlin-dsl`
}
repositories {
    google()
    jcenter()
    mavenCentral()
}

val properties = Properties()
properties.load(file("../gradle.properties").reader())
dependencies {
    compileOnly(gradleKotlinDsl())
    implementation("com.android.tools.build:gradle:" + properties.getProperty("version.com.android.tools.build..gradle"))
}
