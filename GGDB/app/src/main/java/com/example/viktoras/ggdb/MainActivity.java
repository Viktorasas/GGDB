package com.example.viktoras.ggdb;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //>VN001 Mygtukas login kuris perkelia i login activity
    public void Login(View view) {
<<<<<<< HEAD
=======
        System.out.println("Login window");
>>>>>>> 5df17bacbd23c2d09b1031a986098e47974b1baa
        Intent intent = new Intent(MainActivity.this, Login.class);
        startActivity(intent);
    }

    //>VN002 Search maniu atidarymas
    public void Search(View view) {
        System.out.println("Search window");
        Intent intent = new Intent(MainActivity.this, Search.class);
        startActivity(intent);
    }
    //<VN002


    //<VN001
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
