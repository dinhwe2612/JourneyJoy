package com.example.journeyjoy.screen.boardingpass;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeyjoy.R;

public class SeatsTicketAdapter extends RecyclerView.Adapter<SeatsTicketAdapter.SeatsTicketViewHolder> {

    final String[] seatNumbers;
    public SeatsTicketAdapter(String[] seatNumbers) {
        this.seatNumbers = seatNumbers;
    }
    @NonNull
    @Override
    public SeatsTicketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_seatticket, null);
        return new SeatsTicketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SeatsTicketViewHolder holder, int position) {
        holder.seatNumber.setText(seatNumbers[position]);
    }

    @Override
    public int getItemCount() {
        return seatNumbers.length;
    }

    static class SeatsTicketViewHolder extends RecyclerView.ViewHolder {
        TextView seatNumber;
        public SeatsTicketViewHolder(@NonNull View itemView) {
            super(itemView);
            seatNumber = itemView.findViewById(R.id.seatNumbers);
        }
    }
}
