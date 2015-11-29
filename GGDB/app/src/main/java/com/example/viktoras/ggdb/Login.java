package com.example.viktoras.ggdb;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.widget.EditText;
import java.sql.*;

import com.example.viktoras.ggdb.Classes.UserProfile;

/**
 * Created by Viktoras on 2015-11-29.
 * VN002 - paima is textfieldu name ir password ir pasiuncia i metoda kuris sius uzklausas
 */
public class Login extends  Activity {

    private String username;
    private String password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


    }
    //>VN002
    public void Login(View view){
        EditText usernameInput = (EditText) findViewById(R.id.usernameInput);
        EditText passwordInput = (EditText) findViewById(R.id.passwordInput);


        username = usernameInput.getText().toString();
        password = passwordInput.getText().toString();
        UserProfile profile = new UserProfile(username, password);
        profile.Logon(username, password);

    }
    //<VN002

}
