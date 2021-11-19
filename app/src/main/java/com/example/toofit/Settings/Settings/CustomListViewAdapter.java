package com.example.toofit.Settings.Settings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.toofit.R;

import java.util.ArrayList;

public class CustomListViewAdapter extends ArrayAdapter<Credit> {

    public CustomListViewAdapter(@NonNull Context context, ArrayList<Credit> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            TextView creditFor = convertView.findViewById(R.id.creditFor);
            creditFor.setText(getItem(position).getCreditFor());
            TextView creditTo = convertView.findViewById(R.id.creditTo);
            creditTo.setText(getItem(position).getTo());
        }

        return convertView;
    }
}
