package com.example.leletu.waterdiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ArrayList<EditModel> categories2;
    ListView myListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Calculator c = new Calculator();
        setContentView(R.layout.activity_main);
        myListView = findViewById(R.id.myListView);
        makeList();
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

    public void calculateButton(View view){
        Intent intent = new Intent(MainActivity.this,Calculator.class);
        startActivity(intent);
    }
}