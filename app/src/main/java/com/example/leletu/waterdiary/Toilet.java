package com.example.leletu.waterdiary;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Toilet extends AppCompatActivity {
    DataBaseHelper baseHelper;
    private String dateForDiary;
    private int totalForDiary;
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toilet);
        baseHelper = new DataBaseHelper(this);
        try{
            dateForDiary = getIntent().getExtras().getString("date");
            totalForDiary = getIntent().getExtras().getInt("total");
        }catch (NullPointerException e){
            totalForDiary = 0;
            dateForDiary = "No date";
        }
        total = findViewById(R.id.totalForToilet);
    }

    @Override
    protected void onResume() {
        super.onResume();
        total.setText(""+totalForDiary+" L");
    }

    public void backButton(View view) {
        Intent intent = new Intent(Toilet.this,Shower.class);
        startActivity(intent);

    }

    public void homeButton(View view){
        Intent intent = new Intent(Toilet.this,MainActivity.class);
        if (!dateForDiary.equals("No date"))
            intent.putExtra("dateForM",dateForDiary);
        startActivity(intent);
    }

    public void nextActivity(View view){
        Intent intent = new Intent(Toilet.this,Laundry.class);
        startActivity(intent);
    }

    public void findDate(){

        Cursor cursor = baseHelper.makeQuiry("select Date FROM Categories");
        ArrayList<EditModel> www = new ArrayList<>();
        if (cursor.getCount() == 0) {

        } else {
            while (cursor.moveToNext()) {
                dateForDiary = cursor.getString(0);
            }

        }

    }
}
