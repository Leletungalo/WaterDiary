package com.example.leletu.waterdiary;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public DataBaseHelper baseHelper;
    private String SetDate;
    public ArrayList<EditModel> categories2;
    ListView myListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         baseHelper = new DataBaseHelper(this);
        myListView = findViewById(R.id.myListView);
        SetDate = "No date";
        makeList2();
        CategoriesListAdapter adapter = new CategoriesListAdapter(this, R.layout.adapter_view_layout,categories2);
        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

              switch (position){
                  case 0:
                      startActivity(new Intent(MainActivity.this,Shower.class));
                      break;

                  case 1:
                      startActivity(new Intent(MainActivity.this,Toilet.class));
                      break;

                  case 2:
                      startActivity(new Intent(MainActivity.this,Laundry.class));
                      break;
                  case 3:
                      startActivity(new Intent(MainActivity.this,Cooking.class));
                      break;

                  case 4:
                      startActivity(new Intent(MainActivity.this,Dishes.class));
                      break;

                  case 5:
                      startActivity(new Intent(MainActivity.this,Drinking.class));
                      break;

                  case 6:
                      startActivity(new Intent(MainActivity.this,Cleaning.class));
                      break;

                  case 7:
                      startActivity(new Intent(MainActivity.this,Hygene.class));
                      break;
              }
            }
        });
    }

    public ArrayList<EditModel> makeList(){

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

    public void makeList2(){

        try{
        String zzz = getIntent().getExtras().getString("user");
        SetDate = zzz;
        Cursor cursor = baseHelper.makeQuiry("select NAME,Date,MARKS FROM Categories WHERE Date ='"+SetDate+"' ");
        ArrayList<EditModel> www = new ArrayList<>();
        if (cursor.getCount() == 0){
                Toast.makeText(MainActivity.this,"No data 1",Toast.LENGTH_SHORT).show();
                makeList();
        }else {
            while (cursor.moveToNext()){
                    String nam = cursor.getString(0);

                    String date = cursor.getString(1);
                    int total = cursor.getInt(2);
                    EditModel model = new EditModel(nam,date,total);

                    www.add(model);
                }
                categories2 = www;
            }
        }catch (NullPointerException e) {

            if (SetDate.equals("No date")) {
                Cursor cursor = baseHelper.makeQuiry("select NAME,Date,MARKS FROM Categories WHERE Date ='" + SetDate + "' ");
                ArrayList<EditModel> www = new ArrayList<>();
                if (cursor.getCount() == 0) {
                    makeList();
                } else {
                    while (cursor.moveToNext()) {
                        String nam = cursor.getString(0);

                        String date = cursor.getString(1);
                        int total = cursor.getInt(2);
                        EditModel model = new EditModel(nam, date, total);
                        www.add(model);
                    }
                    categories2 = www;
                }
            }else
                makeList();
        }
    }


    public void calculateButton(View view){
        Intent intent = new Intent(MainActivity.this,Calculator.class);
        startActivity(intent);
    }
}