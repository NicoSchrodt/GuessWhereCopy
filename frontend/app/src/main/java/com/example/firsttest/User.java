package com.example.firsttest;

import androidx.appcompat.app.AppCompatActivity;

public class User extends AppCompatActivity {
    private String Username;
    private String AccessToken;

    private User(String Usernm, String AT){
        Username = Usernm;
        AccessToken = AT;
    }

    public String getUsername(){
        return Username;
    }

    public User checkCredentials(String User, String Password) {
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

    public static com.example.firsttest.User testDeleteLater(String first, String second) {
        User user2;
        user2 = new User(first, second);
        return user2;
    }
}
