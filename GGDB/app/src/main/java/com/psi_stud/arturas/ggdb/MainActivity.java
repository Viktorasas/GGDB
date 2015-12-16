package com.psi_stud.arturas.ggdb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnUserProfile;
    public static User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUserProfile = (Button) findViewById(R.id.btnUserProfile);

        btnUserProfile.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnUserProfile:
                if(user == null || !user.isLogedIn) {
                    startActivity(new Intent(this, LoginActivity.class));
                    if(user != null)
                        startActivity(new Intent(this, UserProfileActivity.class));
                }
                else{
                    startActivity(new Intent(this, UserProfileActivity.class));
                }
                break;
            case R.id.button2:
                //startActivity(new Intent(this, SearchActivity.class));
        }
    }
}
