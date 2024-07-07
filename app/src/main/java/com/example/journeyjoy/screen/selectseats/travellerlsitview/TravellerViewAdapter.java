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
    int selectedPosition = 0;
    int numTraveller;

    public interface Listener {
        void onSelectedTravellerChanged(int newTraveller);
    }
    Listener listener;

    public TravellerViewAdapter(int numTraveller, Listener listener) {
        this.numTraveller = numTraveller;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TravellerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_traveller, parent, false);
        return new TravellerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TravellerViewHolder holder, int position) {
        holder.numTraveller.setText(String.valueOf(position + 1));
        if (position != selectedPosition) {
            holder.linearLayout.setBackgroundColor(Color.TRANSPARENT);
        } else {
            holder.linearLayout.setBackgroundResource(R.drawable.ic_selected);
            holder.linearLayout.setBackgroundColor(Color.parseColor("#FFDDA2"));
        }
        holder.linearLayout.setOnClickListener(v -> {
            if (selectedPosition != position) {
                int temp = selectedPosition;
                selectedPosition = position;
                notifyItemChanged(selectedPosition);
                notifyItemChanged(temp);
                listener.onSelectedTravellerChanged(selectedPosition);
            }
        });
    }

    @Override
    public int getItemCount() {
        return numTraveller;
    }

    public void nextTraveller() {
        ++selectedPosition;
        notifyItemChanged(selectedPosition);
        notifyItemChanged(selectedPosition - 1);
        listener.onSelectedTravellerChanged(selectedPosition);
    }

    public int getSelectedTraveller() {
        return selectedPosition;
    }

    public boolean isEndOfList() {
        return selectedPosition == numTraveller - 1;
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
