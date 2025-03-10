package com.example.hw3q3;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText input;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Display the screen
        setContentView(R.layout.activity_main);

        //create an object of the text Watcher
        EdtTxtWatcher watcher = new EdtTxtWatcher();


        //Access the input box
        input = findViewById(R.id.inputBox);
        input.addTextChangedListener(watcher);



    }

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
            String strInput = input.getText().toString();

            stringLength = strInput.length();

            //show how many characters left
            int charLeft = 200;
            String line  = "Characters left : "+(charLeft-stringLength)+"/200";
            TextView charLeftView = findViewById(R.id.lblCharLeft);
            charLeftView.setText(line);
        }

    }
}