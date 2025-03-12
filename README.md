*Overview

 -This Android app allows users to encrypt and decrypt text data using a shift-based encryption method.
 The app consists of two screens:

 1-Main Screen - Users can input text and apply encryption or decryption.

 2-Key Management Screen - Users can modify the encryption key.


*Features

 -Encrypt and decrypt text using a shift cipher.

 -Store encryption key as user preference.

 -Support for up to 200 characters.

 -Encryption applies only to letters (A-Z, a-z), keeping other characters unchanged.

 -Circular shifting for letters within a fixed set of 52 characters.


*How It Works

 1-User Input: Enter text (max 200 characters) in the input box.

 2-Encryption: Press "Encrypt" to shift letters forward by the current key.

 3-Decryption: Press "Decrypt" to shift letters backward by the current key.

4-Changing Key:

  -Press "Key" to open the key management screen.

  -Modify the key and submit changes.

  -The new key is saved in preferences.


*Encryption Method

 -The app uses a shift cipher that rotates letters within the following sequence:

 "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

 -Encryption: Shifts each letter forward by the key value.

 -Decryption: Shifts each letter backward by the key value.

 -Non-alphabet characters remain unchanged.


*Installation

 1-Clone the repository:

git clone https://github.com/your-username/encryption-app.git

 2-Open the project in Android Studio.

 3-Build and run the app on an emulator or device.


*Technologies Used

 -Java (Android Development)

 -XML (UI Layout)

 -SharedPreferences (Data Storage)
