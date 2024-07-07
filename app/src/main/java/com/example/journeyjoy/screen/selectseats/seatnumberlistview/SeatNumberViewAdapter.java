package com.example.journeyjoy.screen.selectseats.seatnumberlistview;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeyjoy.R;

public class SeatNumberViewAdapter extends RecyclerView.Adapter<SeatNumberViewAdapter.SeatNumberViewHolder> {

    @NonNull
    @Override
    public SeatNumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_seatnumber, parent, false);
        return new SeatNumberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SeatNumberViewHolder holder, int position) {
        holder.seatNumber.setText(String.valueOf(position + 1));
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    class SeatNumberViewHolder extends RecyclerView.ViewHolder {
        TextView seatNumber;

        SeatNumberViewHolder(View itemView) {
            super(itemView);
            seatNumber = itemView.findViewById(R.id.seatNumberTextview);
        }
    }
}
