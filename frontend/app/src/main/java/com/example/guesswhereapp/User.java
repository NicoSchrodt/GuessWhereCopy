package com.example.guesswhereapp;

import androidx.appcompat.app.AppCompatActivity;

public class User extends AppCompatActivity {
    private final String Username;
    private String AccessToken;

    private User(String Usernm, String AT){
        Username = Usernm;
        AccessToken = AT;
    }

    public String getUsername(){return Username;}
    public String getAccessToken(){return AccessToken;}

    public boolean checkCredentials(String User, String Password) {
        boolean UserValid = false;

        //connect to database and check credentials
        //
        // DO STUFF
        //

        return UserValid;
    }

    public static User new_user_instance(String first, String second) {
        return new User(first, second);
    }
}
