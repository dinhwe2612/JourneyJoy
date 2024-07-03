package com.example.journeyjoy.screen.flights.flightdatelistview;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeyjoy.R;

public class FlightDateViewAdapter extends RecyclerView.Adapter<FlightDateViewAdapter.FlightDateViewHolder> {
    int selectedPosition = 0;
    interface Listener {
        void onSelected(int position);
    }
    Listener mListener;
    @NonNull
    @Override
    public FlightDateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flightdate, parent, false);
        return new FlightDateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlightDateViewHolder holder, int position) {
        if (position == selectedPosition) {
            holder.linearLayout.setBackgroundResource(R.drawable.flightdate);
        } else {
            holder.linearLayout.setBackgroundColor(Color.TRANSPARENT);
        }
        holder.linearLayout.setOnClickListener(v -> {
            int last = selectedPosition;
            selectedPosition = position;
            notifyItemChanged(position);
            notifyItemChanged(last);
        });
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    static class FlightDateViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        public FlightDateViewHolder(View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.itemFlightdate);
        }
    }
}
