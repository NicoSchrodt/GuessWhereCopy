package com.example.guesswhereapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class RegisterScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button button_confirmRegister = (Button) findViewById(R.id.button_confirmRegister);

        button_confirmRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try_creating_user();
            }
        });
    }

    private void try_creating_user(){
        TextView textedit_nameRegister = (TextView) findViewById(R.id.textedit_nameRegister);
        TextView textedit_passwordRegister = (TextView) findViewById(R.id.textedit_passwordRegister);
        String Username =  textedit_nameRegister.getText().toString();
        String Password = textedit_passwordRegister.getText().toString();

        try {
            if (Database_test.create_user(Username, Password)){
                String accesstoken = Database_test.request_access_token(Username, Password);
                MainScreen.user = User.factory(Username, accesstoken);
                reload_main();
            } else {
                openDialog();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void reload_main() {
        Intent intent = new Intent(RegisterScreen.this, MainScreen.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        MainScreen.whichPopup = 1;
        startActivity(intent);
    }

    private void openDialog() {
        MainScreen.popupMessage = "Dieser Nutzername ist bereits vergeben!";
        Popup popup = new Popup();
        popup.show(getSupportFragmentManager(), "label");
    }
}