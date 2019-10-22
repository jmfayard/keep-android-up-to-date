import com.louiscad.splitties.AndroidX
import com.louiscad.splitties.Google
import com.louiscad.splitties.Testing
import com.louiscad.splitties.Kotlin

plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  id("org.jetbrains.kotlin.kapt")
  id("kotlin-android-extensions")
}

repositories {
  google()
  jcenter()
  mavenCentral()
}
apply(from = "android.gradle")


dependencies {
  implementation(Kotlin.stdlibJdk7)
  implementation(AndroidX.appCompat)
  implementation(AndroidX.constraintLayout)
  implementation(Google.material)
  implementation(AndroidX.lifecycle.runtime)
  implementation(AndroidX.lifecycle.extensions)
  kapt(AndroidX.lifecycle.compiler)
  testImplementation(Testing.junit4)
  androidTestImplementation(AndroidX.test.core)
  androidTestImplementation(AndroidX.archCore.testing)
  androidTestImplementation(Testing.mockitoCore)
  androidTestImplementation(Testing.mockitoAndroid)
  androidTestImplementation(Testing.mockitoKotlin)
  androidTestImplementation(AndroidX.test.runner)
  androidTestImplementation(AndroidX.test.rules)
  androidTestImplementation(AndroidX.test.espresso.core)
}
