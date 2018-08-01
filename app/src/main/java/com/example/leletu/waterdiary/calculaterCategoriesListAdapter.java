package com.example.leletu.waterdiary;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class calculaterCategoriesListAdapter extends ArrayAdapter<Categories> {
    private Context context;
    private int resource;

    static class ViewHolder {
        TextView name;
        TextView date;
        EditText total;
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
        String name = getItem(position).getName();

        Categories categories = new Categories(name);

        ViewHolder holder = new ViewHolder();
        if (convertView == null){
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource,parent,false);


        holder.name = (TextView) convertView.findViewById(R.id.calcuTextView1);
      //  holder.date = (TextView) convertView.findViewById(R.id.calcuEditTextView2);
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
