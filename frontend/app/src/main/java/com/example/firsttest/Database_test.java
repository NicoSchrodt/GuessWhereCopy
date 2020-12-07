package com.example.firsttest;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Database_test extends AppCompatActivity {

    public static void database_check() throws IOException {
        /*
        URL url = new URL("167.99.136.249/");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
         */
        //String urlParameters  = "param1=a&param2=b&param3=c";
        String request        = "http://api.guesswhere.net/api.php?type=dbstatus";
        URL    url            = new URL( request );
        HttpURLConnection conn= (HttpURLConnection) url.openConnection();

        //Request-Header
        String urlParameters  = "";
        byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
        int    postDataLength = postData.length;
        conn.setRequestMethod( "POST" );

        //Send Post Request
        conn.setDoOutput(true);
        //conn.setInstanceFollowRedirects( false );
        //conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty( "charset", "utf-8");
        //conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
        //conn.setUseCaches( false );

        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = conn.getResponseCode();
        Log.d("Output","\nSending 'POST' request to URL : " + url);
        Log.d("Output","Post parameters : " + urlParameters);
        Log.d("Output","Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
        String inputLine;
        //StringBuffer response = new StringBuffer();
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        Log.d("Output", response.toString());



    }

    public static boolean create_user(String Username, String Password) throws IOException {
        String request        = "http://api.guesswhere.net/api.php?type=createuser";
        URL    url            = new URL( request );
        HttpURLConnection conn= (HttpURLConnection) url.openConnection();

        //Request-Header
        String urlParameters  = "username=" + Username + "&password=" + Password;
        byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
        int    postDataLength = postData.length;
        conn.setRequestMethod( "POST" );

        //Send Post-Request
        conn.setDoOutput(true);
        conn.setRequestProperty( "charset", "utf-8");

        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        /*
        int responseCode = conn.getResponseCode();
        Log.d("Output","\nSending 'POST' request to URL : " + url);
        Log.d("Output","Post parameters : " + urlParameters);
        Log.d("Output","Response Code : " + responseCode);
        */
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        //StringBuffer response = new StringBuffer();
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        Log.d("Output", response.toString());

        return response.toString().equals("{\"status\":\"user_created\"}");
    }
}

