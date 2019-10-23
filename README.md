# Usage



# How-To update a Legacy Android Project

- Title: How-To update a Legacy Android Project
- Audience level: Intermediate
- Style: Core Concept
- Prerequisites: Gradle Tutorial for Android: Getting Started
- Most important concepts: Gradle, Gradle tasks, Gradle Plugins, Gradle and Kotlin, Dependencies Management, AndroidX migration
- Sample app name: Legacy Android Project (starter app)
- Sample app description: A legacy project written 2 years ago, using old versions of Android Studio, Kotlin, Gradle, Dependencies, Support Libraries. We will show-case a simple path to upgrade it to the latest and greatest.


## Outline

- Introduction
- Getting Started
  - Download and explore starter project #instruction
  - Android Studio says: "Gradle Sync failed". Should I try again? #theory
- A painless path to upgrade your project
  - Update Gradle #instruction
  - Convert the root project to Kotlin #instruction #theory
  - Add Gradle plugins #instruction
  - Inspect the Gradle Build-Scan #instruction
  - What is a Gradle plugin? #reference
  - Your private Gradle plugin: the buildSrc module #instruction #theory
- Upgrade your project
  - A simple way to add dependencies to your build #instruction #theory
  - Run ./gradlew refreshVersions #instruction
  - To update or not update? #theory
  - Run ./gradlew migrateToAndroidX #instruction
- Simplify your build
  - Add missing tasks #instruction
  - Auto-document your README #instruction
- Where to Go From Here

## Links

- https://issuetracker.google.com/issues/64551265
- Gradle Tips and Tricks for Android https://raywenderlich.com/5532-gradle-tips-and-tricks-for-android
- Domain-Specific Languages In Kotlin: Getting Started https://raywenderlich.com/2780058-domain-specific-languages-in-kotlin-getting-started
- Gradle+Kotlin samples https://github.com/gradle/kotlin-dsl-samples
- Gradle buildSrcVersions & refreshVersions https://github.com/jmfayard/buildSrcVersions
- Splitties: A family of small Kotlin libraries for delightful Android development https://github.com/LouisCAD/Splitties
