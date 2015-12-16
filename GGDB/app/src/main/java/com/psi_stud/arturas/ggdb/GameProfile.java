package com.psi_stud.arturas.ggdb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class GameProfile extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_profile);
        int gameId = savedInstanceState.getInt("gameID");
        Game game = new Game(gameId);
        game.loadGame();
    }

    @Override
    public void onClick(View view) {
    }
}
