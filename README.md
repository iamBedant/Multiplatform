
# Not in active development. Working on a private repository. Will update the link here as soon as it is ready.


## Kotlin Multiplatform Project (Android/ iOS)

Android           | iOS
:-------------------------:|:-------------------------:
![](https://cdn-images-1.medium.com/max/1600/1*IObkWN_iHaK9VWzE6NOZ5A.gif)  |  ![](https://cdn-images-1.medium.com/max/1600/1*ar5dtKKjUlOr_JmxZm04hw.gif)



### Goals

* Share business logic between all platforms.


### Non-Goals

* Architecture / UI

### Libraries Used

* Ktor
* coroutines
* kotlinx-serialization


## Running the App

1. Install Android Studio
2. Create a file called `local.properties` in the root directory with the following content:

```
## This file does *NOT* get checked into your VCS, as it
## contains information specific to your local configuration.

# Location of the SDK. This is only used by Gradle.
sdk.dir=/Users/{your-username}/Library/Android/sdk
```
Replace `{your-username}` in `local.properties` with your actual username.

### Android
* Open the project on **Android Studio** or **Intellij IDEA**.
* Select `app` configuration and hit `Run`. 

### iOS
* Run `./gradlew build -x test` on root directory.
* Open `iosApp` project in **Xcode**
* Run the project.

## TODO
* Add `HttpClient` logging. [https://github.com/ktorio/ktor/issues/722]()
* Add common db Support.
