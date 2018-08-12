package com.example.leletu.waterdiary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Toilet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toilet);
    }

    public void backButton(View view) {
        Intent intent = new Intent(Toilet.this,Shower.class);
        startActivity(intent);

    }

    public void homeButton(View view){
        Intent intent = new Intent(Toilet.this,MainActivity.class);
        startActivity(intent);
    }

    public void nextActivity(View view){
        Intent intent = new Intent(Toilet.this,Laundry.class);
        startActivity(intent);
    }
}
