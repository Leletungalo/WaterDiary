package com.example.leletu.waterdiary;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    public DataBaseHelper baseHelper;
    private String SetDate;
    private int count;
    public ArrayList<EditModel> categories2;
    ListView myListView;
    TextView totalForMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baseHelper = new DataBaseHelper(this);
        myListView = findViewById(R.id.myListView);
        totalForMain = findViewById(R.id.totalForMain);

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count");
        } else {

            count = 0;
        }

        findDate();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart", "onStart");

    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("setDate", SetDate);
        outState.putInt("count", count);
        super.onSaveInstanceState(outState);

    }

    public ArrayList<EditModel> makeList() {

        EditModel shower = new EditModel("shower");
        EditModel toilet = new EditModel("toilet");
        EditModel laundry = new EditModel("laundry");
        EditModel cooking = new EditModel("cooking");
        EditModel dishes = new EditModel("dishes");
        EditModel drinking = new EditModel("drinking");
        EditModel cleaning = new EditModel("cleaning");
        EditModel hygiene = new EditModel("hygiene");

        categories2 = new ArrayList<>();

        categories2.add(shower);
        categories2.add(toilet);
        categories2.add(laundry);
        categories2.add(cooking);
        categories2.add(dishes);
        categories2.add(drinking);
        categories2.add(cleaning);
        categories2.add(hygiene);

        return categories2;
    }

    public void makeList2(String setDate) {
        if (setDate != null) {
            if (!setDate.equals("No date")) {
                Cursor cursor = baseHelper.makeQuiry("select NAME,Date,MARKS FROM Categories WHERE Date ='" + setDate + "' ");
                ArrayList<EditModel> www = new ArrayList<>();
                if (cursor.getCount() == 0) {
                    makeList();
                } else {
                    while (cursor.moveToNext()) {
                        String nam = cursor.getString(0);
                        String date = cursor.getString(1);
                        int total = cursor.getInt(2);
                        count += total;
                        EditModel model = new EditModel(nam, date, total);
                        www.add(model);
                    }
                    categories2 = www;
                }
            } else
                makeList();
        }else {
        makeList();}
    }

    public void calculateButton(View view){
        Intent intent = new Intent(MainActivity.this,Calculator.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause","onPause");
    }

    public int getCount() {
        return count;
    }

    @Override
    protected void onResume() {
        super.onResume();
        String nuSrt;
        makeList2(SetDate);
        CategoriesListAdapter adapter = new CategoriesListAdapter(this, R.layout.adapter_view_layout,categories2);
        myListView.setAdapter(adapter);
        totalForMain.setText(""+count+" L");
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        Intent intent = new Intent(MainActivity.this,Shower.class);
                        if (count != 0){
                        intent.putExtra("total",count);
                        intent.putExtra("date",SetDate);}
                        startActivity(intent);

                        break;

                    case 1:
                        Intent intent1 = new Intent(MainActivity.this,Toilet.class);
                        if (count != 0){
                            intent1.putExtra("total",count);
                            intent1.putExtra("date",SetDate);}
                        startActivity(intent1);
                        break;

                    case 2:
                        Intent intent2 =new Intent(MainActivity.this,Laundry.class);
                        if (count != 0){
                            intent2.putExtra("total",count);
                            intent2.putExtra("date",SetDate);}
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(MainActivity.this,Cooking.class);
                        if (count != 0){
                            intent3.putExtra("total",count);
                            intent3.putExtra("date",SetDate);}
                        startActivity(intent3);
                        break;

                    case 4:
                        Intent intent4 = new Intent(MainActivity.this,Dishes.class);
                        if (count != 0){
                            intent4.putExtra("total",count);
                            intent4.putExtra("date",SetDate);}
                        startActivity(intent4);
                        break;

                    case 5:
                        Intent intent5 = new  Intent(MainActivity.this,Drinking.class);
                        if (count != 0){
                            intent5.putExtra("total",count);
                            intent5.putExtra("date",SetDate);}
                        startActivity(intent5);
                        break;

                    case 6:
                        Intent intent6 = new Intent(MainActivity.this,Cleaning.class);
                        if (count != 0){
                            intent6.putExtra("total",count);
                            intent6.putExtra("date",SetDate);}
                        startActivity(intent6);

                        break;

                    case 7:
                        Intent intent7 = new Intent(MainActivity.this,Hygene.class);
                        if (count != 0){
                            intent7.putExtra("total",count);
                            intent7.putExtra("date",SetDate);}
                        startActivity(intent7);
                        break;
                }
            }
        });
    }

    public void findDate(){

        Cursor cursor = baseHelper.makeQuiry("select Date FROM Categories");
        ArrayList<EditModel> www = new ArrayList<>();
        if (cursor.getCount() == 0) {
            SetDate = "No date";
        } else {
            while (cursor.moveToNext()) {
                SetDate = cursor.getString(0);
            }

        }

    }



    @Override
    protected void onStop() {
        super.onStop();
        Log.d("onStop","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy","onDestroy");
        baseHelper.close();
    }
}