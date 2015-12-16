package com.psi_stud.arturas.ggdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnUserProfile;
    Button btn;
    public static User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button2);
        btnUserProfile = (Button) findViewById(R.id.btnUserProfile);

        btnUserProfile.setOnClickListener(this);
        btn.setOnClickListener(this);
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
                startActivity(new Intent(this, GameActivity.class));
                break;
        }
    }
}
