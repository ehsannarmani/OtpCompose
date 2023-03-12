# Otp Widget For JetpackCompose
### A Otp Widget to enter passwords, sms codes , ...
<img src="https://github.com/ehsannarmani/OtpCompose/blob/master/media/gif.gif" width="250">
<hr/>

## Dependency

### Step 1: Add the JitPack repository to your build file
#### Add it in your root build.gradle at the end of repositories:
```groovy
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

## Step 2: Add the dependency
[![](https://jitpack.io/v/ehsannarmani/OtpCompose.svg)](https://jitpack.io/#ehsannarmani/OtpCompose)
```groovy
dependencies {
  implementation 'com.github.ehsannarmani:OtpCompose:latest_version'
}
```

<hr/>

## Usage

```kotlin
Otp(
    count = 5,
    error = false,
    success = true,
    errorColor = Color(0xffffffff),
    successColor = Color(0xffffffff),
    focusedColor = Color(0xff313131),
    unFocusedColor = Color.Gray,
    onFinish = { otp->
       // do something
    },
    modifier=Modifier.size(60.dp,90.dp),
    ...
)  
```

## Todos

1. [ ] Add new features
2. [ ] Add paste feature
