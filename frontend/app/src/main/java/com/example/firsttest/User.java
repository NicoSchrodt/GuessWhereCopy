package com.example.firsttest;

import androidx.appcompat.app.AppCompatActivity;

public class User extends AppCompatActivity {
    private String User;
    private String AccessToken;

    private User(String Username, String AT){
        User = Username;
        AccessToken = AT;
    }

    protected User checkCredentials(String User, String Password) {
        int UserValid = 0;
        //connect to database and check credentials
        /*
        DO STUFF
         */

        //if user exists with given password
        if(UserValid == 1) {
            User user;
            user = new User("Test1", "Test2");
            return user; //this should later return a User;
        }
        return null;
    }
}
