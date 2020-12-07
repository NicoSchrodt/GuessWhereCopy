package com.example.firsttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        /*
        1. Check Database for entered Username
        -- 1: Username already in Use:
            --> Display "Username already taken!"
           2: Username not in Use:
            --> Create User with entered password in database
            --> Create User Object with entered credentials and save it in MainScreen
            --> Return to MainScreen; delete all prior activities
         */

        //right now, simply create user and return to MainScreen
        do_what_register_button_does();
    }

    private void do_what_register_button_does(){
        //do something
        TextView textedit_nameRegister = (TextView) findViewById(R.id.textedit_nameRegister);
        TextView textedit_passwordRegister = (TextView) findViewById(R.id.textedit_passwordRegister);
        MainScreen.user = User.testDeleteLater(textedit_nameRegister.getText().toString(), textedit_passwordRegister.getText().toString());
        reload_main();
    }

    private void reload_main() {
        Intent intent = new Intent(RegisterScreen.this, MainScreen.class);
        // set the new task and clear flags
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}