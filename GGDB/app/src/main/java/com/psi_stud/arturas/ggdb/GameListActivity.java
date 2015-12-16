package com.psi_stud.arturas.ggdb;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

/**
 * Created by Viktoras on 2015-12-16.
 */
public class GameListActivity extends AppCompatActivity {
    private String[] gameIDstr;
    private String listID;
    private int[] gameID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);

    }
    public void GetGames(){
        int i = 0;
        for (String temp : listID.split(",")){
            gameIDstr[i] = temp;
            gameID[i] = Integer.parseInt(gameIDstr[i]);
            i++;
        }
    }

    public void openGame(int gameID) {
        //IKOPINKIT KODA IS SEARCH FUNKCIJOS PLS - Viktor THE P(IMP) NAVIDOVSKY

    }


}
