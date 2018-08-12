package com.example.leletu.waterdiary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATEBASE_NAME = "WaterDiary.db";
    public static final String TABLE_NAME = "Categories";
    public static final String Cal_1 = "NAME";
    public static final String Cal_2 = "Date";
    public static final String Cal_3 = "MARKS";

    public DataBaseHelper(Context context) {
        super(context, DATEBASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Categories (id integer primary key AUTOINCREMENT, NAME text ,Date integer not null, MARKS integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }

    public boolean insertDate(String name, String Date, String marks){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Cal_1,name);
        values.put(Cal_2,Date);
        values.put(Cal_3,marks);

        long result = db.insert(TABLE_NAME,null,values);

        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllDate(){
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery("select * from " + TABLE_NAME,null);
    }

    public Cursor makeQuiry(String query){
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery(query,null);
    }
}