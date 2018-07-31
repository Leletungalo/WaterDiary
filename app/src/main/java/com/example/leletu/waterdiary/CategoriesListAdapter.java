package com.example.leletu.waterdiary;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class CategoriesListAdapter extends ArrayAdapter<Categories>{
    private Context context;
    int resource;

    public CategoriesListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Categories> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       String name = getItem(position).getName();
       String date = getItem(position).getDate();
       int total = getItem(position).getTotal();

       String lastTot = "" + total + "";
       Categories cate = new Categories(name, date,total);

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource,parent,false);

        TextView nameAndDate = convertView.findViewById(R.id.TextView1);
        TextView Date = convertView.findViewById(R.id.TextView2);
        TextView totalView = convertView.findViewById(R.id.TextView3);

        nameAndDate.setText(name);
        Date.setText(date);
        totalView.setText(lastTot);

        return convertView;
    }


}
