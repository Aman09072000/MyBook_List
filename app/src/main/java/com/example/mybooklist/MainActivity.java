package com.example.mybooklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText search1 = (EditText)findViewById(R.id.editTextTextPersonName);
        String search = search1.getText().toString();

        Button butn = (Button)findViewById(R.id.button);
        butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,allBooks.class);
                intent.putExtra("Search_key",search);
                startActivity(intent);
            }
        });
    }
}