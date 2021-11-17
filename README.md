# AdaptiveFrameLayout [![GitHub](https://img.shields.io/github/license/Kleberf65/AdaptiveFrameLayout)](https://github.com/Kleberf65/AdaptiveFrameLayout/blob/master/LICENSE.md) [![Release](https://jitpack.io/v/Kleberf65/AdaptiveFrameLayout.svg)](https://jitpack.io/#Kleberf65/AdaptiveFrameLayout/1.0.0) [![Svg](https://jitpack.io/v/Kleberf65/AdaptiveFrameLayout/month.svg)](https://jitpack.io/v/Kleberf65/AdaptiveFrameLayout)
Simple library for creating a container with skin proportion for trailer applications
## Screenshot
![image](https://user-images.githubusercontent.com/94382310/141861573-5392c09b-4c9b-4e83-9e70-73b0d910e3d6.png)
## Installing
Step 1. Add the JitPack repository to your build file, Add it in your root `build.gradle` at the end of repositories or `settings.gradle` for new features Android Studio:

```gradle
// root build.gradle

allprojects {
        repositories {
            maven { url 'https://jitpack.io' }
        }
    }

// or settings.gradle for new features Android Studio

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```
Step 2. Add the dependency
```gradle
dependencies {
    implementation 'com.github.Kleberf65:AdaptiveFrameLayout:1.0.0'
}
```
## Here we go for implementation
Add AdaptiveFrameLayout into your XML

```xml
<br.kleberf65.widget.AdaptiveFrameLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
```
Set attributes AdaptiveFrameLayout programatically

```java
   AdaptiveFrameLayout adaptiveFrameLayout = findViewById(R.id.adaptive_frame_layout_by_code);
        adaptiveFrameLayout.setHeightPercentage(45);
        adaptiveFrameLayout.setMatchParent(false);
        adaptiveFrameLayout.setIncrementWidth(10);
        adaptiveFrameLayout.setScreenDivider(2);
        adaptiveFrameLayout.start();
```
## Custom Attributes
| Command        | Description           
| ------------- |:-------------:|
| `afl_screenDivider`     | Defines the number of items that the layout will be divided in width |
| `afl_incrementWidth`      | Adds value to width to adjust as you want      |
| `afl_heightPercentage` | Defines the extra percentage to be added in height relative to width      |
| `afl_isMatchParent` | Defines if the container has to use all available width      |
