package com.example.leletu.waterdiary;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Hygene extends AppCompatActivity {
    private String DiaryToatal;
    DataBaseHelper baseHelper;
    private String dateForDiary;
    private int totalForDiary;
    TextView total;
    TextView hygieneTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hygene);
        baseHelper = new DataBaseHelper(this);
        findDate();
        dataQuery(dateForDiary);
        DiaryTotal111(dateForDiary);
        total = findViewById(R.id.totalForHygiene);
        hygieneTotal = findViewById(R.id.hygieneTotal);
    }

    @Override
    protected void onResume() {
        super.onResume();
        hygieneTotal.setText(DiaryToatal+" L");
        total.setText(" "+totalForDiary+" L");
    }

    public void backButton(View view) {
        Intent intent = new Intent(Hygene.this,Cleaning.class);
        intent.putExtra("dateForM",dateForDiary);
        startActivity(intent);

    }

    public void homeButton(View view){
        Intent intent = new Intent(Hygene.this,MainActivity.class);
        if (!dateForDiary.equals("No date"))
            intent.putExtra("dateForM",dateForDiary);
        startActivity(intent);

    }

    public void nextActivity(View view){
        Intent intent = new Intent(Hygene.this,MainActivity.class);
        intent.putExtra("dateForM",dateForDiary);
        startActivity(intent);

    }
    public  void dataQuery(String date) {
        Cursor cursor = baseHelper.makeQuiry("select NAME,Date,MARKS FROM Categories WHERE Date ='" + date + "' ");
        ArrayList<EditModel> www = new ArrayList<>();
        if (cursor.getCount() == 0) {
            totalForDiary = 0;
            DiaryToatal = "0";

        } else {
            while (cursor.moveToNext()) {
                int total = cursor.getInt(2);
                totalForDiary += total;
            }

        }

    }

    public void DiaryTotal111(String date){
        Cursor cursor = baseHelper.makeQuiry("select MARKS FROM Categories WHERE Date ='" + date + "' and NAME ='hygiene' ");
        ArrayList<EditModel> www = new ArrayList<>();
        if (cursor.getCount() == 0) {
            totalForDiary = 0;
            DiaryToatal = "0";

        } else {
            while (cursor.moveToNext()) {
                DiaryToatal = cursor.getString(0);
            }

        }
    }

    public void findDate(){

        Cursor cursor = baseHelper.makeQuiry("select Date FROM Categories");
        ArrayList<EditModel> www = new ArrayList<>();
        if (cursor.getCount() == 0) {
            totalForDiary = 0;
            DiaryToatal = "0";

        } else {
            while (cursor.moveToNext()) {
                dateForDiary = cursor.getString(0);
            }

        }

    }
}
