package com.example.leletu.waterdiary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Cleaning extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaning);
    }

    public void backButton(View view){
        Intent intent = new Intent(Cleaning.this,Drinking.class);
        startActivity(intent);
    }

    public void homeButton(View view){
        Intent intent = new Intent(Cleaning.this,MainActivity.class);
        startActivity(intent);

    }

    public void nextActivity(View view){
        Intent intent = new Intent(Cleaning.this,Hygene.class);
        startActivity(intent);
    }
}
