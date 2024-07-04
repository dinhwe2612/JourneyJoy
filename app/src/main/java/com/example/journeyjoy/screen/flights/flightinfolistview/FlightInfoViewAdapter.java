package com.example.journeyjoy.screen.flights.flightinfolistview;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeyjoy.R;

public class FlightInfoViewAdapter extends RecyclerView.Adapter<FlightInfoViewAdapter.FlightInfoViewHolder> {

    @NonNull
    @Override
    public FlightInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_flightinfo, null);
        return new FlightInfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlightInfoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 7;
    }

    static class FlightInfoViewHolder extends RecyclerView.ViewHolder {


        public FlightInfoViewHolder(View itemView) {
            super(itemView);

        }
    }
}
