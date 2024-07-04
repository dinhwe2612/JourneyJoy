package com.example.journeyjoy.screen.selectseats.travellerlsitview;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeyjoy.R;

public class TravellerViewAdapter extends RecyclerView.Adapter<TravellerViewAdapter.TravellerViewHolder> {
    @NonNull
    @Override
    public TravellerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_traveller, parent, false);
        return new TravellerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TravellerViewHolder holder, int position) {
        holder.numTraveller.setText(String.valueOf(position + 1));
        if (position != 0) {
            holder.linearLayout.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class TravellerViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        TextView numTraveller;
        public TravellerViewHolder(View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.itemTraveller);
            numTraveller = itemView.findViewById(R.id.numTravllerTextview);
        }
    }
}
