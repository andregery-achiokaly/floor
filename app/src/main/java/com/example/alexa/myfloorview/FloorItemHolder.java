package com.example.alexa.myfloorview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;


class FloorItemHolder extends  RecyclerView.ViewHolder {
    @BindView(R.id.floor_item)
    Button textView;

    FloorItemHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
