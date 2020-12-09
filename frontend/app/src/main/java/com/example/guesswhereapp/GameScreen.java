package com.example.guesswhereapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.IOException;

public class GameScreen extends AppCompatActivity {

    public static float coordinate_1;
    public static float coordinate_2;

    public static int whichscreen = 0;

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //button_singleplayer
        switch(whichscreen){
            case 0://Selection Screen
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_game_select_screen);
                Button button_singleplayer = (Button) findViewById(R.id.button_singleplayer);

                button_singleplayer.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        whichscreen = 1;
                        startAnotherGameActivity();
                    }
                });
                break;
            case 1://SinglePlayer
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_game_screen);
                imageView=findViewById(R.id.imageView);

                String Url = null;

                try {
                    Url = Database_test.getNewImage(MainScreen.user.getAccessToken());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(Url != null){
                    Picasso.get().load(Url).into(imageView);
                }
                break;
            case 2://Challenge User
                break;
        }
    }

    private void startAnotherGameActivity() {
        Intent intent = new Intent(this, GameScreen.class);
        startActivity(intent);
    }
}