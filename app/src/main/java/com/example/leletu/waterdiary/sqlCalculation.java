package com.example.leletu.waterdiary;

import android.database.Cursor;

public class sqlCalculation {
    private DataBaseHelper baseHelper;
    private String date;
    public int totalForToday;

    public sqlCalculation(DataBaseHelper baseHelper,String date) {
        this.baseHelper = baseHelper;
        this.date = date;
    }

    public int getTotalForToday() {
        return totalForToday;
    }

    public void makeCalculateTotal(){

        Cursor cursor = baseHelper.makeQuiry("select SUM(MARKS) from Categories");
        totalForToday = cursor.getInt(0);

    }
}
