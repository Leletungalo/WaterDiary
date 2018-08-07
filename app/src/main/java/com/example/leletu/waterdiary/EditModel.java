package com.example.leletu.waterdiary;

import android.widget.EditText;

public class EditModel {

    private String editTextValue;
    private String name, date;
    private int total;

    public EditModel(){}

    public EditModel(String name){
        this.name = name;
        this.date = "DD/MM/YYYY";
        this.total = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public int getTotal() {
        return total;
    }

    public String getEditTextValue() {
        return editTextValue;
    }

    public void setEditTextValue(String editTextValue) {
        this.editTextValue = editTextValue;
    }
}
