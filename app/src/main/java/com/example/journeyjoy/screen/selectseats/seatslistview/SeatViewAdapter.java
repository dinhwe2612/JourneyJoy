package com.example.journeyjoy.screen.selectseats.seatslistview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeyjoy.R;

import java.util.ArrayList;
import java.util.List;

public class SeatViewAdapter extends RecyclerView.Adapter<SeatViewAdapter.SeatViewHolder> {
    int colNum;

    public boolean isAvailable(int row) {
        return seatStates.get(row) == 0;
    }

    public interface Listener {
        boolean onSeatClicked(int col, int row);
    }

    Listener listener;

    List<Integer> seatStates;

    public SeatViewAdapter(int colNum, boolean[] seats, Listener listener) {
        this.seatStates = new ArrayList<>();
        for (int i = 0; i < seats.length; i++) {
            if (seats[i]) {
                seatStates.add(2);
            } else {
                seatStates.add(0);
            }
        }
        this.colNum = colNum;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SeatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_seat, parent, false);
        return new SeatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SeatViewHolder holder, int position) {
        if (seatStates.get(position) == 0) {
            holder.item.setBackgroundResource(R.drawable.ic_available);
        } else if (seatStates.get(position) == 1) {
            holder.item.setBackgroundResource(R.drawable.ic_selected);
        } else {
            holder.item.setBackgroundResource(R.drawable.ic_booked);
        }
        holder.item.setOnClickListener(v -> {
            if (listener.onSeatClicked(colNum, position)) {
                if (seatStates.get(position) == 1) {
                    seatStates.set(position, 0);
                    holder.item.setBackgroundResource(R.drawable.ic_available);
                } else if (seatStates.get(position) == 0) {
                    seatStates.set(position, 1);
                    holder.item.setBackgroundResource(R.drawable.ic_selected);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return seatStates.size();
    }
    class SeatViewHolder extends RecyclerView.ViewHolder {
        LinearLayout item;
        public SeatViewHolder(View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.itemSeat);
        }
    }
}
