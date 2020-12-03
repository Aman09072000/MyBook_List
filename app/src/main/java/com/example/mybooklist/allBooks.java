package com.example.mybooklist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class allBooks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

        Intent intent = getIntent();
        String Search = intent.getStringExtra("Search_key");


        ArrayList<Objects> earthquakes = QueryUtils.extractEarthquakes();


        BookAdapter earth = new BookAdapter(this, earthquakes);
        final BookAdapter adapter = new BookAdapter(this, earthquakes);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(earth);


    }
}
