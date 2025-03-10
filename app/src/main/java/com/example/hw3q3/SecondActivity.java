package com.example.hw3q3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //display screen
        setContentView(R.layout.activity_second);

        updateView();
    }
    public void updateView()
    {
        //access preferences and retrieve key
        SharedPreferences preferences = getSharedPreferences("key", Context.MODE_PRIVATE);
        int key = preferences.getInt("KEY",0);

        //access the edit text and display the most recent key
        EditText keyInput = findViewById(R.id.keyInputBox);
        keyInput.setText(key+"");


    }

    public void update(View view)
    {
        //access the edit text and retrieve the key
        EditText keyInput = findViewById(R.id.keyInputBox);
        String strKey = keyInput.getText().toString();
        int key = Integer.parseInt(strKey);

        //store key into preferences
        SharedPreferences preferences = getSharedPreferences("key", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("KEY",key);
        editor.apply();

        //end current screen
        finish();
    }
}
