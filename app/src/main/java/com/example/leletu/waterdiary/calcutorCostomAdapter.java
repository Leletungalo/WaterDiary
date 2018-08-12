package com.example.leletu.waterdiary;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class calcutorCostomAdapter extends BaseAdapter {
    private Context context;
    public static ArrayList<EditModel> list;

    public calcutorCostomAdapter(Context context, ArrayList<EditModel> list) {
        this.context = context;
        this.list = list;
    }

    static class ViewHolder {
       TextView name;
        EditText total;
        TextView runningTotal;
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
         final ViewHolder holder;
         if (convertView == null){
             holder = new ViewHolder();
             LayoutInflater inflater = (LayoutInflater) context
                     .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             convertView = inflater.inflate(R.layout.calculater_adapter_view_layout,null,true);

             holder.name = (TextView) convertView.findViewById(R.id.calcuTextView1);
             holder.runningTotal = (TextView) convertView.findViewById(R.id.runningTotal);
             holder.total = (EditText) convertView.findViewById(R.id.calcuEditTextView3);

             convertView.setTag(holder);
         }else
             holder = (ViewHolder) convertView.getTag();

         holder.total.setText(list.get(position).getEditTextValue());

         holder.total.addTextChangedListener(new TextWatcher() {
             @Override
             public void beforeTextChanged(CharSequence s, int start, int count, int after) {

             }

             @Override
             public void onTextChanged(CharSequence s, int start, int before, int count) {
                 String ooo = holder.total.getText().toString();
                list.get(position).setEditTextValue(ooo);
             }

             @Override
             public void afterTextChanged(Editable s) {

             }
         });
        holder.name.setText(list.get(position).getName());

        return convertView;
    }
}
