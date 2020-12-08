package com.example.guesswhereapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.IOException;

public class GameScreen extends AppCompatActivity {

    public static float coordinate_1;
    public static float coordinate_2;

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
    }
}