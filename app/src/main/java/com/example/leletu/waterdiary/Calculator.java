package com.example.leletu.waterdiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Calculator extends AppCompatActivity {
   // public static DataBaseHelper baseHelper;
   // calculaterCategoriesListAdapter listAdapter;
    ListView calListView;
    private calcutorCostomAdapter costomAdapter;
    public ArrayList<EditModel> editModelArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        calListView = findViewById(R.id.calcutorListView);
       // baseHelper = new DataBaseHelper(this);

        editModelArrayList = populateList();
        MainActivity main = new MainActivity();

        //ArrayList nullNonsence = main.makeList();

        costomAdapter = new calcutorCostomAdapter(this,editModelArrayList);
        calListView.setAdapter(costomAdapter);

        /*
        calculaterCategoriesListAdapter adapter = new calculaterCategoriesListAdapter(this, R.layout.calculater_adapter_view_layout,nullNonsence);
        calListView.setAdapter(adapter);
*/
    }

    private ArrayList<EditModel> populateList() {
        ArrayList<EditModel> list2 = new ArrayList<>();

        for (int i = 0 ; i < 8; i++){
            EditModel model = new EditModel();
            //model.setEditTextValue(String.valueOf(i));
            list2.add(model);
        }

        return list2;
    }

    public void saveDataFromCalculatorActivity(View view){
        for (int i = 0 ; i < calcutorCostomAdapter.list.size(); i++){
            String name = calcutorCostomAdapter.list.get(i).getEditTextValue();
            Toast.makeText(Calculator.this,name,Toast.LENGTH_SHORT).show();
        }


    }
}
