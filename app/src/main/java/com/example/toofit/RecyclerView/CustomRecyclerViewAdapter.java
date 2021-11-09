package com.example.toofit.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.toofit.R;

import java.util.ArrayList;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private ArrayList<Fact> facts;

    public CustomRecyclerViewAdapter(ArrayList<Fact> facts) {
        this.facts = facts;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Fact fact = facts.get(position);
        holder.factName.setText(fact.getName());
        holder.factInfo.setText(fact.getInfo());
    }

    @Override
    public int getItemCount() {
        if(facts != null){
            return facts.size();
        }
        return 0;
    }
}

class CustomViewHolder extends RecyclerView.ViewHolder{
    protected TextView factName;
    protected TextView factInfo;

    public CustomViewHolder(@NonNull View itemView) { //recycle_row
        super(itemView);
        this.factName = itemView.findViewById(R.id.foodFactName);
        this.factInfo = itemView.findViewById(R.id.foodFactInfo);
    }
}