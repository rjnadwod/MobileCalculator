# Mobile Calculator

This Mobile Calculator is an application developed in Java using the Model-View-Presenter design pattern for the Android OS.

## Installation

Download the repository, launch in Android Studio, build and run on your AVD or physical Android device.

## Usage

This calculator uses another library called mXparser to grab the expression from the view and run calculations.

There are two odd behaviors to note that I did not have time to fix, but would like to.
1. User can input expressions such as "5.6.7.8 + 8.3.4", resulting in a NaN output.
2. The sign button (+/-) only works on the first number in the expression. Any negative numbers that follow have to be input as subtraction (-54-73), as opposed to adding a negative number (-54+(-73).

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
