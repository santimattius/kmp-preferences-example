# KMP Preferences Example

This is a Kotlin Multiplatform project targeting Android, iOS.

## Swift

![swift-kvs](https://github.com/santimattius/kmp-preferences-example/assets/22333101/1e8bf443-00bc-4b91-9a66-c41ddc52f02a)

## Kotlin

![kotlin-kvs](https://github.com/santimattius/kmp-preferences-example/assets/22333101/d91c11e4-a1ac-4038-a9c0-46e859566a2b)

## Structure

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

* `/shared` is for the code that will be shared between all targets in the project.
  The most important subfolder is `commonMain`. If preferred, you can add code to the platform-specific folders here too.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)
