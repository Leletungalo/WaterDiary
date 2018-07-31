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
    public calculaterCategoriesListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Categories> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String name = getItem(position).getName();

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource,parent,false);

        TextView NameView = convertView.findViewById(R.id.calcuTextView1);
        EditText dateView = convertView.findViewById(R.id.calcuEditTextView2);
        EditText totalView = convertView.findViewById(R.id.calcuEditTextView3);

        NameView.setText(name);


        return convertView;
    }
}
