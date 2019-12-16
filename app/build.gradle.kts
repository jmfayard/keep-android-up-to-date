plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  id("org.jetbrains.kotlin.kapt")
  id("de.fayard.dependencies")
}

apply(from = "android.gradle")

repositories {
  google()
  jcenter()
  mavenCentral()
}


dependencies {
  implementation(Splitties.preferences)
  implementation(AndroidX.appCompat)
  implementation(AndroidX.constraintLayout)
  implementation(Google.material)
  implementation(AndroidX.lifecycle.runtime)
  implementation(AndroidX.lifecycle.extensions)
  kapt(AndroidX.lifecycle.compiler)
  implementation(Kotlin.stdlib.jdk7)

  testImplementation(Testing.junit4)

  testImplementation(Testing.mockito.core)
  testImplementation(Testing.mockito.kotlin)
  testImplementation(Testing.mockito.inline)
  testImplementation(AndroidX.archCore.testing)


  androidTestImplementation(Testing.mockito.core)
  androidTestImplementation(Testing.mockito.android)
  androidTestImplementation(Testing.mockito.kotlin)

  androidTestImplementation(AndroidX.test.core)
  androidTestImplementation(AndroidX.archCore.testing)
  androidTestImplementation(AndroidX.test.ext.junit)
  androidTestImplementation(AndroidX.test.rules)
  androidTestImplementation(AndroidX.test.espresso.core)
}
