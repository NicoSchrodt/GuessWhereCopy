package com.example.firsttest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

@SuppressWarnings("SpellCheckingInspection")
public class MainScreen extends AppCompatActivity {
    public static User user = null;
    public static int whichPopup = 0;
    public static String popupMessage = "";
    public MainScreen() {
    }


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        if (user == null) { //Generic Screen [Not Logged in]
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            if(whichPopup != 0){
                switch(whichPopup){
                    case 4:
                        popupMessage = "You opened the Help Screen and Confirmed!";
                        break;
                    case 3:
                        popupMessage = "You sucessfully logged out!";
                        break;
                }
                openDialog();
                whichPopup = 0;
            }

            Button button_login = (Button) findViewById(R.id.button_login);
            Button button_help = (Button) findViewById(R.id.button_help);
            TextView textview_title = (TextView) findViewById(R.id.textview_title);
            textview_title.setText("Guesswhere");

            button_login.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    startLoginActivity();
                }
            });

            button_help.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    startHelpActivity();
                }
            });

        } else { //Logged in Screen
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_loggedin);

            if(whichPopup != 0){
                switch(whichPopup){
                    case 1:
                        popupMessage = "You sucessfully registered!";
                        break;
                    case 2:
                        popupMessage = "You sucessfully logged in!";
                        break;
                }
                openDialog();
                whichPopup = 0;
            }

            Button button_play = (Button) findViewById(R.id.button_play);
            Button button_options = (Button) findViewById(R.id.button_options);
            Button button_logout = (Button) findViewById(R.id.button_logout);
            TextView textview_greetuser = (TextView) findViewById(R.id.textview_greetuser);

            textview_greetuser.setText("Hallo, " + user.getUsername());

            button_options.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    //textview_title.setText("Du hast die Optionen aufgerufen!");
                    startOptionsActivity();
                }
            });

            button_logout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    //textview_title.setText("Du hast die Optionen aufgerufen!");
                    user = null;
                    finish(); //closes MainActivity
                    whichPopup = 3;
                    startActivity(getIntent()); //restarts Main
                }
            });
        }
    }

    public void startLoginActivity() {
        Intent intent = new Intent(this, LoginScreen.class);
        //intent.putExtra(name: "user_eingabe", eingabe.getText());
        startActivity(intent);
    }

    public void startOptionsActivity(){
        OptionsScreen.whichscreen = 0; //reset so it always displays the default version
        Intent intent = new Intent(this, OptionsScreen.class);
        startActivity(intent);
    }

    public void startHelpActivity(){
        Intent intent = new Intent(this, HelpScreen.class);
        startActivity(intent);
    }

    public void openDialog() {
        Popup popup = new Popup();
        popup.show(getSupportFragmentManager(), "label");
    }
}
