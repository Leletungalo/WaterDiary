package com.example.leletu.waterdiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Shower extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shower);
    }

    public void backButton(View view) {
        Toast.makeText(getApplication(),"Shawer",Toast.LENGTH_SHORT).show();
    }

    public void homeButton(View view){
        Intent intent = new Intent(Shower.this,MainActivity.class);
        startActivity(intent);

    }

    public void nextActivity(View view){
        Intent intent = new Intent(Shower.this,Toilet.class);
        startActivity(intent);
    }
}
