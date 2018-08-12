package com.example.leletu.waterdiary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Cooking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooking);
    }

    public void backButton(View view) {
        Intent intent = new Intent(Cooking.this,Laundry.class);
        startActivity(intent);

    }

    public void homeButton(View view){
        Intent intent = new Intent(Cooking.this,MainActivity.class);
        startActivity(intent);

    }

    public void nextActivity(View view){
        Intent intent = new Intent(Cooking.this,Dishes.class);
        startActivity(intent);

    }
}
