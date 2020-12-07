package com.example.firsttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button button_confirmRegister = (Button) findViewById(R.id.button_confirmRegister);

        button_confirmRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                return_to_Main_Screen_logged_in();
            }
        });
    }

    private void return_to_Main_Screen_logged_in(){
        //do something
    }
}