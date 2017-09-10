package com.example.alexa.myfloorview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexa on 11.09.2017.
 */

class FloorAdapter extends RecyclerView.Adapter<FloorItemHolder> {

    private List<Integer> floors;

    FloorAdapter(int count) {
        floors = new LinkedList<>();
        for (int i = 0; i < count; i++)
            floors.add(i);
    }

    public FloorAdapter(int firstFloor, int secondFloor) {
        floors = new LinkedList<>();
        for (int i = firstFloor; i < secondFloor; i++)
            floors.add(i);
    }

    @Override
    public FloorItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.floor_item, parent, false);
        return new FloorItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FloorItemHolder holder, int position) {
        holder.textView.setText(String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return floors.size();
    }
}
