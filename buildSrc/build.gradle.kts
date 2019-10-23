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
properties.load(file("../versions.properties").reader())
