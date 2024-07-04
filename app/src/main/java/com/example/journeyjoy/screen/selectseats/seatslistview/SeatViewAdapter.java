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
    boolean isChoosen = false;
    List<Integer> seatStates = new ArrayList<>(
            List.of(0, 2, 0, 2, 0, 2, 0)
    );
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
            if (seatStates.get(position) == 1 && isChoosen) {
                isChoosen = false;
                seatStates.set(position, 0);
                holder.item.setBackgroundResource(R.drawable.ic_available);
            } else if (seatStates.get(position) == 0 && !isChoosen) {
                isChoosen = true;
                seatStates.set(position, 1);
                holder.item.setBackgroundResource(R.drawable.ic_selected);
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
