package com.example.leletu.waterdiary;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class calculaterCategoriesListAdapter extends ArrayAdapter<Categories> {
    private Context context;
    private int resource;
    ViewHolder holder;
    int pos;
    static class ViewHolder {
        TextView name;
        TextView date;
        EditText total;
        Button saveAll;
    }

    public calculaterCategoriesListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Categories> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final View result;
        pos = position;
        String name = getItem(position).getName();
        Categories categories = new Categories(name);

        holder = new ViewHolder();
        if (convertView == null){
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource,parent,false);


        holder.name = (TextView) convertView.findViewById(R.id.calcuTextView1);
        holder.total = (EditText) convertView.findViewById(R.id.calcuEditTextView3);

        result = convertView;
        convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        holder.name.setText(categories.getName());
        return convertView;
    }
}