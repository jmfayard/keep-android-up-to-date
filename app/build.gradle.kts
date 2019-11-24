plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  id("org.jetbrains.kotlin.kapt")
  id("de.fayard.dependencies")
}

apply(plugin = "kotlin-android-extensions")

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
  //implementation(Kotlin.stdlibJdk7)

  testImplementation(Testing.junit4)

  //testImplementation(Testing.mockitoCore)
  //testImplementation(Testing.mockitoKotlin)
  //testImplementation(Testing.mockitoInline)
  testImplementation(AndroidX.archCore.testing)


  //androidTestImplementation(Testing.mockitoCore)
  //androidTestImplementation(Testing.mockitoAndroid)
  //androidTestImplementation(Testing.mockitoKotlin)

  androidTestImplementation(AndroidX.test.core)
  androidTestImplementation(AndroidX.archCore.testing)
  androidTestImplementation(AndroidX.test.runner)
  androidTestImplementation(AndroidX.test.rules)
  androidTestImplementation(AndroidX.test.espresso.core)
}
