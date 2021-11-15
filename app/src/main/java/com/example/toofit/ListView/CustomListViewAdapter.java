package com.example.toofit.ListView;

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

public class CustomListViewAdapter extends ArrayAdapter<Item> {

    public CustomListViewAdapter(@NonNull Context context, ArrayList<Item> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            TextView fruitName = convertView.findViewById(R.id.itemName);
            fruitName.setText(getItem(position).getName());
        }

        return convertView;
    }
}
