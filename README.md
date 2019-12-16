# Usage

```bash
$ ./gradlew tasks --group custom

Tasks runnable from root project
------------

Custom tasks
------------

androidTests - Run Android instrumention tets
apk - Build a release APK
clean - Delete build files
hello - Empty Hello World task, useful to debug build problems
install - Install the app
tests - Run the unit tests

```


# A simple way to keep your Android projects up-to-date

- Title: How-To update a Legacy Android Project
- Audience level: Intermediate
- Style: Core Concept
- Prerequisites: Gradle Tutorial for Android: Getting Started
- Most important concepts: Gradle, Gradle tasks, Gradle Plugins, Gradle and Kotlin, Dependencies Management, AndroidX migration
- Sample app name: Legacy Android Project (starter app)
- Sample app description: A legacy project written 2 years ago, using old versions of Android Studio, Kotlin, Gradle, Dependencies, Support Libraries. We will show-case a simple path to upgrade it to the latest and greatest.

# Why?

Keeping all your Android projects up-to-date is both really important and really annoying.

It's annoying because the Android word is moving fast and breaking things, 
and there is always a newer version of this or that that is available,
a library that is deprecated or has a better alternative, ... 
So much time can be spent just keeping up with things!

At the same time, it's important work because piling up technical debt is also costly. 
By not updating your projects, you take on your shoulders are the bugs that has been resolved,
all the performance fix that would make you productive, you can't use the latest documentation available without caveats.

Can we have both of both worlds?

A simple way to bring our projects up-to-date without loosing your sanity while doing so?

# Links

- Gradle refreshVersions https://github.com/jmfayard/buildSrcVersions
- Splitties: A family of small Kotlin libraries for delightful Android development https://github.com/LouisCAD/Splitties
- Gradle Tips and Tricks for Android https://raywenderlich.com/5532-gradle-tips-and-tricks-for-android
- Domain-Specific Languages In Kotlin: Getting Started https://raywenderlich.com/2780058-domain-specific-languages-in-kotlin-getting-started
- Gradle+Kotlin samples https://github.com/gradle/kotlin-dsl-samples

