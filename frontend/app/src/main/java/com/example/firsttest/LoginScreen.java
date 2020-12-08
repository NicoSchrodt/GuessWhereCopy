package com.example.firsttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button button_registerInstead = (Button) findViewById(R.id.button_registerInstead);
        Button button_confirmLogin = (Button) findViewById(R.id.button_confirmLogin);

        button_registerInstead.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startRegisterActivity();
            }
        });

        button_confirmLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                do_what_login_button_does();
            }
        });
    }

    public void startRegisterActivity(){
        Intent intent = new Intent(this, RegisterScreen.class);
        startActivity(intent);
    }

    private void do_what_login_button_does(){
        //do something
        TextView textedit_nameLogin = (TextView) findViewById(R.id.textedit_nameLogin);
        TextView textedit_password = (TextView) findViewById(R.id.textedit_password);
        String Username = textedit_nameLogin.getText().toString();
        String Password = textedit_password.getText().toString();
        String accesstoken = "";
        //MainScreen.user = User.new_user_instance(textedit_nameLogin.getText().toString(), textedit_password.getText().toString());
        try {
            accesstoken = Database_test.request_access_token(Username, Password );
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(!(accesstoken.equals(""))) {
            MainScreen.user = User.new_user_instance(Username, accesstoken);
            MainScreen.whichPopup = 2;
            reload_main();
        }
    }

    private void reload_main() {
        Intent intent = new Intent(LoginScreen.this, MainScreen.class);
        // set the new task and clear flags
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}