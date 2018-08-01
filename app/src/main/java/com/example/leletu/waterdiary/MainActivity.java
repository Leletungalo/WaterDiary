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
    public ArrayList<Categories> categories2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Calculator c = new Calculator();
        setContentView(R.layout.activity_main);
        ListView myListView = findViewById(R.id.myListView);
        makeList();
        CategoriesListAdapter adapter = new CategoriesListAdapter(this, R.layout.adapter_view_layout,categories2);
        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              /*
                if (position == 0){
                  Toast.makeText(MainActivity.this,"Shower",Toast.LENGTH_SHORT).show();
              }else if (position == 1){
                  Toast.makeText(MainActivity.this,"toilet",Toast.LENGTH_SHORT).show();
              }else if (position == 2){
                  Toast.makeText(MainActivity.this,"laundry",Toast.LENGTH_SHORT).show();
              }else if (position == 3)
                  Toast.makeText(MainActivity.this,"cooking",Toast.LENGTH_SHORT).show();
                */
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

    public ArrayList makeList(){
        Categories shower = new Categories("shower");
        Categories toilet = new Categories("toilet");
        Categories laundry = new Categories("laundry");
        Categories cooking = new Categories("cooking");
        Categories dishes = new Categories("dishes");
        Categories drinking = new Categories("drinking");
        Categories cleaning = new Categories("cleaning");
        Categories hygiene = new Categories("hygiene");

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