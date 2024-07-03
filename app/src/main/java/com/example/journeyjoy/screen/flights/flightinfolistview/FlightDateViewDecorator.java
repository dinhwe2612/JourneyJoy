package com.example.journeyjoy.screen.flights.flightinfolistview;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FlightDateViewDecorator extends RecyclerView.ItemDecoration {

    int mMarginTop;
    public FlightDateViewDecorator(int marginTop) {
        mMarginTop = marginTop;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.top = mMarginTop;
    }
}
