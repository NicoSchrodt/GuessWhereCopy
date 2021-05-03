package com.example.guesswhereapp;

import androidx.appcompat.app.AppCompatActivity;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTest {
    User user = User.new_user_instance("TestName", "12345abc");
    @Test
    public void can_getUserName() {
        assertNotEquals("", user.getUsername());
    }

    @Test
    public void can_getAccessToken() {
        assertNotEquals("", user.getAccessToken());
    }
}