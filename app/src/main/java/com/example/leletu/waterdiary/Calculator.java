package com.example.leletu.waterdiary;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Calculator extends AppCompatActivity {
    public static DataBaseHelper baseHelper;
    ListView calListView;
    public ArrayList<EditModel> editModelArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        calListView = findViewById(R.id.calcutorListView);
        baseHelper = new DataBaseHelper(this);
        MainActivity main = new MainActivity();

        editModelArrayList = main.makeList();
        calcutorCostomAdapter costomAdapter = new calcutorCostomAdapter(this, editModelArrayList);
        calListView.setAdapter(costomAdapter);
    }

    public void saveDataFromCalculatorActivity(View view){

        final EditText date = findViewById(R.id.DateEditText);
        String zz = "";
        for (int i = 0 ; i < calcutorCostomAdapter.list.size(); i++){
            String total = calcutorCostomAdapter.list.get(i).getEditTextValue();
            String name = editModelArrayList.get(i).getName();
            zz = date.getText().toString();
           boolean o = baseHelper.insertDate(name,zz,total);
        }
        Intent intent = new Intent(Calculator.this,MainActivity.class);
        intent.putExtra("user",zz);
        startActivity(intent);

    }

    public void ViewAllData(View view){
        Intent intent = new Intent(Calculator.this,MainActivity.class);
        startActivity(intent);
    }
       /* Cursor res = baseHelper.getAllDate();

        if (res.getCount() == 0){
            showText("Error","Data not found");
            return;
        }

        StringBuffer buffer = new StringBuffer();

        while (res.moveToNext()){
            buffer.append("ID: " + res.getString(0)+"\n");
            buffer.append("Name : " + res.getString(1)+"\n");
            buffer.append("Surname : " + res.getString(2)+"\n");
            buffer.append("Mark : " + res.getString(3)+"\n\n");
        }
        showText("lelethu dialog",buffer.toString());
    }

    public void showText(String title, String messege){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(messege);
        builder.show();
    }*/
}
