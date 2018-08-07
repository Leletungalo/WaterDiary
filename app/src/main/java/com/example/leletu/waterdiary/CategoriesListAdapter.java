package com.example.leletu.waterdiary;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

class CategoriesListAdapter extends ArrayAdapter<EditModel>{
    private Context context;
    int resource;
    ArrayList list;

    static class ViewHolder {
        TextView name;
        TextView date;
        TextView total;
    }

    public CategoriesListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<EditModel> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        list = objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String name = getItem(position).getName();
       String date = getItem(position).getDate();
       int total = getItem(position).getTotal();

       Categories cate = new Categories(name, date,total);
       final View result;
       ViewHolder holder = new ViewHolder();
       if (convertView == null) {
           LayoutInflater inflater = LayoutInflater.from(context);
           convertView = inflater.inflate(resource, parent, false);

           holder.name = (TextView) convertView.findViewById(R.id.TextView1);
           holder.date = (TextView) convertView.findViewById(R.id.TextView2);
           holder.total = (TextView) convertView.findViewById(R.id.TextView3);



           result = convertView;
           convertView.setTag(holder);
       }else {
           holder = (ViewHolder) convertView.getTag();
           result = convertView;
       }

       holder.name.setText(cate.getName());
       holder.date.setText(cate.getDate());
       holder.total.setText(""+cate.getTotal()+"");

        return convertView;
    }

    public void testMethod(){}

    @Override
    public int getCount() {
        return list.size();
    }
}
