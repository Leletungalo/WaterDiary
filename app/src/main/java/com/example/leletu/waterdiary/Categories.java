package com.example.leletu.waterdiary;

public class Categories {
    private String date,name;
    private int total;

    public Categories(String name, String date, int total) {
        this.name = name;
        this.date = date;
        this.total = total;
    }

    public Categories(String name){
        this.name = name;
        date = "No date set Yet";
        total = 0;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getTotal() {
        return total;
    }
}
