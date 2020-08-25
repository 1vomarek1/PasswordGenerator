# Password Generator

Password Generator is android app inspired by [Dashlane](https://www.dashlane.com/)'s in app password generator.

## Installation

First you need to build the app using

```bash
gradlew build
```
This will create apk file in **./app/build/outputs/apk/release/**
This app can then be installed to android device


## Usage
The app is really easy to use. You can change length of the password by draging the SeekBar in center.
You can toggle wether the app should use letters, numbers or symbols using Switches under the SeekBar.

If niether letters, numbers nor symbols are selected password will contain letters and numbers.
