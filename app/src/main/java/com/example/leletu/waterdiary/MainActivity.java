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

       /* Categories shower = new Categories("shower","4945649",100);
        Categories toilet = new Categories("toilet","4945649",100);
        Categories laundry = new Categories("laundry","4945649",100);
        Categories cooking = new Categories("cooking","4945649",100);
        Categories dishes = new Categories("dishes","4945649",100);
        Categories drinking = new Categories("drinking","4945649",100);
        Categories cleaning = new Categories("cleaning","4945649",100);
        Categories hygiene = new Categories("hygiene","4945649",100);
        Categories calculater = new Categories("calculater","4945649",100);

        ArrayList<Categories> categories = new ArrayList<>();
        categories.add(shower);
        categories.add(toilet);
        categories.add(laundry);
        categories.add(cooking);
        categories.add(dishes);
        categories.add(drinking);
        categories.add(cleaning);
        categories.add(hygiene);
        categories.add(calculater);*/
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

        /*ArrayList<Categories>*/ categories2 = new ArrayList<>();
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
