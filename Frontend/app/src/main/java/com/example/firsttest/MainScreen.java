package com.example.firsttest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

@SuppressWarnings("SpellCheckingInspection")
public class MainScreen extends AppCompatActivity {

    /*
    private Button button_login;
    private Button button_options;
    private Button button_help;
    private TextView textview_title;
     */
    public MainScreen() {
    }


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_login = (Button) findViewById(R.id.button_login);
        Button button_options = (Button) findViewById(R.id.button_options);
        Button button_help = (Button) findViewById(R.id.button_help);
        TextView textview_title = (TextView) findViewById(R.id.textview_title);
        textview_title.setText("Test");

        button_login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //textview_title.setText("Du hast dich eingeloggt!");
                startLoginActivity();
            }

        });
    }

    public void startLoginActivity() {
        Intent intent = new Intent(this, LoginScreen.class);
        //intent.putExtra(name: "user_eingabe", eingabe.getText());
        startActivity(intent);
    }
}
