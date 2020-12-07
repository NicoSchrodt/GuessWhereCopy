package com.example.firsttest;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Database_test extends AppCompatActivity {

    private static HttpURLConnection con;

    public static void method() throws IOException {
        /*
        URL url = new URL("167.99.136.249/");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
         */
        String urlParameters  = "param1=a&param2=b&param3=c";
        byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
        int    postDataLength = postData.length;
        String request        = "http://api.guesswhere.net/api.php?type=dbstatus";
        URL    url            = new URL( request );
        HttpURLConnection conn= (HttpURLConnection) url.openConnection();
        conn.setDoOutput( true );
        conn.setInstanceFollowRedirects( false );
        conn.setRequestMethod( "POST" );
        conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty( "charset", "utf-8");
        conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
        conn.setDoOutput(true);
        conn.setUseCaches( false );
        Reader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        try( DataOutputStream wr = new DataOutputStream( conn.getOutputStream())) {
            wr.write( postData );
            String s = new String (postData, StandardCharsets.UTF_8);
            String temp = bufferedReader.toString();
            Log.d("Output", temp);
        }

    }
}

