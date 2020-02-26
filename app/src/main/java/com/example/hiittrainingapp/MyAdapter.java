package com.example.hiittrainingapp;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class MyAdapter extends ArrayAdapter<WorkOutPart> {

    ArrayList<WorkOutPart> fullWorkOut = new ArrayList<>();

    public MyAdapter(Context context, int textViewResourceId,  ArrayList<WorkOutPart> objects) {
        super(context, textViewResourceId , objects);
        fullWorkOut = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View listItem = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listItem = inflater.inflate(R.layout.list_row_workout, null);

        TextView nimi = (TextView) listItem.findViewById(R.id.workOutTextView);
        nimi.setText(fullWorkOut.get(position).getName());

        TextView aika = (TextView) listItem.findViewById(R.id.workOutTimeTextView);
        aika.setText(String.valueOf(fullWorkOut.get(position).getSeconds()));

        return listItem;
    }
}