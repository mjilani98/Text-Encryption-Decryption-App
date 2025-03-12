package com.example.hw3q3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText input;

    //set of preferences where mortgage information is stored
    public static SharedPreferences preferences;

    private Model model = new Model();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Display the screen
        setContentView(R.layout.activity_main);

        //create an object of the text Watcher
        EdtTxtWatcher watcher = new EdtTxtWatcher();


        //Access the input box , add a TextWatcher handler
        input = findViewById(R.id.inputBox);
        input.addTextChangedListener(watcher);
    }

    //event handler that will take the app to the key screen
    public void key(View v)
    {
        //create key screen
        Intent keyScreen = new Intent(this, SecondActivity.class);

        //call key screen
        startActivity(keyScreen);
    }

    //Event handler that will encrypt an input from the user
    public void encrypt(View v)
    {
        //access preferences and retrieve key
        SharedPreferences preferences = getSharedPreferences("key", Context.MODE_PRIVATE);
        int key = preferences.getInt("KEY",0);

        //set the key to the model
        model.set(key);

        //get the string from the input
        EditText edtInput = findViewById(R.id.inputBox);
        String string = edtInput.getText().toString();

        //variable of the new encrupted text
        String encryptedText = model.encrypt(string);

        //display the encrypted text to the edit text
        input.setText(encryptedText);
    }

    //event handler that will decrypt the text from EditText
    public void decrypt(View view)
    {
        //access preferences and retrieve key
        SharedPreferences preferences = getSharedPreferences("key", Context.MODE_PRIVATE);
        int key = preferences.getInt("KEY",0);

        //set the key to the model
        model.set(key);

        //get the string from the input
        EditText edtInput = findViewById(R.id.inputBox);
        String string = edtInput.getText().toString();

        //variable of the new encrupted text
        String decryptedText = model.decrypt(string);

        //display the decrypted text
        input.setText(decryptedText);

    }

    //text watcher class , shows how many characters left for the user can enter
    public class EdtTxtWatcher implements TextWatcher
    {
        private int stringLength;

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {


        }

        @Override
        public void afterTextChanged(Editable s)
        {
            //getting text from the input box
            String strInput = input.getText().toString();

            //getting the length of the text 
            stringLength = strInput.length();

            //show how many characters left
            int charLeft = 200;
            String line  = "Characters left : "+(charLeft-stringLength)+"/200";
            TextView charLeftView = findViewById(R.id.lblCharLeft);
            charLeftView.setText(line);
        }

    }
}