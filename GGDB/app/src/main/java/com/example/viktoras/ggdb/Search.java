package com.example.viktoras.ggdb;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Viktoras on 2015-12-14.
 */
public class Search extends Activity {

    String searchString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
    }

    public void SearchGame (View view){
        EditText searchInput = (EditText) findViewById(R.id.searchBar);

        searchString = searchInput.getText().toString();
        System.out.println(searchString);
    }


}
