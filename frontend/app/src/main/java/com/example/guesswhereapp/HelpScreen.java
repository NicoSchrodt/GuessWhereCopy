package com.example.guesswhereapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HelpScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_screen);

        Button button_confirmButton = (Button) findViewById(R.id.button_confirmButton);

        button_confirmButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                returnToMain();
            }
        });
    }

    public void returnToMain(){
        Intent intent = new Intent(HelpScreen.this, MainScreen.class);
        // set the new task and clear flags
        //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra("PopupMessage", "I was at the help screen!");
        startActivity(intent);
    }
}