package com.example.leletu.waterdiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        Categories calculater = new Categories("calculater");

        categories2 = new ArrayList<>();

        categories2.add(shower);
        categories2.add(toilet);
        categories2.add(laundry);
        categories2.add(cooking);
        categories2.add(dishes);
        categories2.add(drinking);
        categories2.add(cleaning);
        categories2.add(hygiene);
        categories2.add(calculater);

        return categories2;
    }

    public void calculateButton(View view){
        Intent intent = new Intent(MainActivity.this,Calculator.class);
        startActivity(intent);
    }
}