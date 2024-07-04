package com.example.journeyjoy.screen.filters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeyjoy.R;

public class TimeSelectorViewAdapter extends RecyclerView.Adapter<TimeSelectorViewAdapter.TimeSelectorViewHolder> {
    int selectedPosition = 0;
    @NonNull
    @Override
    public TimeSelectorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_time, parent, false);
        return new TimeSelectorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeSelectorViewHolder holder, int position) {
        if (position == selectedPosition) {
            holder.linearLayout.setBackgroundResource(R.drawable.time_selected);
            holder.textView.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            holder.linearLayout.setBackgroundResource(R.drawable.time_unselected);
            holder.textView.setTextColor(Color.parseColor("#089083"));
        }
        holder.textView.setOnClickListener(v -> {
            int prevSelectedPosition = selectedPosition;
            selectedPosition = position;
            notifyItemChanged(prevSelectedPosition);
            notifyItemChanged(selectedPosition);
        });
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class TimeSelectorViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        LinearLayout linearLayout;
        public TimeSelectorViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.timeText);
            linearLayout = itemView.findViewById(R.id.timeLayout);
        }
    }
}
