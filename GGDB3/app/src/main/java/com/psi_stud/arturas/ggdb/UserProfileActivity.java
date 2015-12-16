package com.psi_stud.arturas.ggdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class UserProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        TextView tv = (TextView)findViewById(R.id.username);
        tv.setText(MainActivity.user.getUsername());

        TextView emailtv = (TextView)findViewById(R.id.email);
        emailtv.setText(MainActivity.user.getEmail());

        TextView firsttv = (TextView)findViewById(R.id.name);
        firsttv.setText(MainActivity.user.getFirstName());

        TextView lasttv = (TextView)findViewById(R.id.surename);
        lasttv.setText(MainActivity.user.getLastName());
    }

}
