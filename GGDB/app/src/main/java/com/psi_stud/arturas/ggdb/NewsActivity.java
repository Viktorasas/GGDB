package com.psi_stud.arturas.ggdb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_news);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        populateListView();
    }
    private void populateListView() {
        //Creating list of news
        String[] myNews = {"First", "Second", "Third"};

        //Build adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.content_news, myNews);

        //COnfigurate list view
        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);
    }
    private void registerClickCallBack(){
        ListView list = (ListView) findViewById(R.id.listView);
    }
}
