package com.example.alexa.myfloorview;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FloorView extends LinearLayout {
    @BindView(R.id.floor_up_button)
    Button upButton;

    @BindView(R.id.floor_down_button)
    Button downButton;

    @BindView(R.id.recycler_floor)
    RecyclerView recyclerView;

    public FloorView(Context context) {
        super(context);
    }

    public FloorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FloorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FloorView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    void initView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.floor_layout, this);
        ButterKnife.bind(this, view);

        downButton.setVisibility(VISIBLE);
        upButton.setVisibility(GONE);
        final LinearLayoutManager layout = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layout);
        recyclerView.setAdapter(new FloorAdapter(15));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (layout.findFirstCompletelyVisibleItemPosition() == 0) {
                    downButton.setVisibility(VISIBLE);
                    upButton.setVisibility(GONE);
                }
                if (layout.findLastCompletelyVisibleItemPosition() == 14) {
                    downButton.setVisibility(GONE);
                    upButton.setVisibility(VISIBLE);
                }
            }
        });

        downButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.scrollToPosition(14);
                downButton.setVisibility(GONE);
                upButton.setVisibility(VISIBLE);
            }
        });

        upButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.scrollToPosition(0);
                downButton.setVisibility(VISIBLE);
                upButton.setVisibility(GONE);
            }
        });
    }
}
