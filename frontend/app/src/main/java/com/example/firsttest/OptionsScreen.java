package com.example.firsttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OptionsScreen extends AppCompatActivity {
    public static int whichscreen = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        switch(whichscreen) {
            case 0: //display normal screen
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_options);

                Button button_changeUsername = (Button) findViewById(R.id.button_changeUsername);
                Button button_changePassword = (Button) findViewById(R.id.button_changePassword);

                button_changeUsername.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        whichscreen = 1;
                        startAnotherOptionsActivity();
                    }
                });

                button_changePassword.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        whichscreen = 2;
                        startAnotherOptionsActivity();
                    }
                });
                break;
            case 1: //display change username screen
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_options_change_username);
                break;
            case 2: //display change password screen
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_options_change_password);
                break;
            default:
                break;
        }
    }

    public void startAnotherOptionsActivity() {
        Intent intent = new Intent(this, OptionsScreen.class);
        startActivity(intent);
    }
}