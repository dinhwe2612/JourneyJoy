package com.example.journeyjoy.screen.flights.flightinfolistview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeyjoy.R;

public class FlightInfoViewAdapter extends RecyclerView.Adapter<FlightInfoViewAdapter.FlightInfoViewHolder> {

    public interface Listener {
        void onItemClicked(int position);
    }
    Listener listener;
    public FlightInfoViewAdapter(Listener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public FlightInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_flightinfo, null);
        return new FlightInfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlightInfoViewHolder holder, int position) {
        holder.ticketView.setOnClickListener(v -> {
            listener.onItemClicked(position);
        });
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    static class FlightInfoViewHolder extends RecyclerView.ViewHolder {

        LinearLayout ticketView;
        public FlightInfoViewHolder(View itemView) {
            super(itemView);
            ticketView = itemView.findViewById(R.id.ticketView);
        }
    }
}
