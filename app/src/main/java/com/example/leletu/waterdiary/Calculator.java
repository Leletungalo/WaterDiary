package com.example.leletu.waterdiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        ListView calListView = findViewById(R.id.calcutorListView);
        MainActivity main = new MainActivity();

        ArrayList nullNonsence = main.makeList();
        calculaterCategoriesListAdapter adapter = new calculaterCategoriesListAdapter(this, R.layout.calculater_adapter_view_layout,nullNonsence);
        calListView.setAdapter(adapter);
    }
}
