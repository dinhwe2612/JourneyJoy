package com.example.journeyjoy.screen.flights.flightdatelistview;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeyjoy.R;
import com.example.journeyjoy.utils.FormatUtils;

import java.util.Date;
import java.util.List;

public class FlightDateViewAdapter extends RecyclerView.Adapter<FlightDateViewAdapter.FlightDateViewHolder> {
    int selectedPosition = 0;

    List<Date> dates;

    public interface Listener {
        void onSelectDate(Date date);
    }

    public FlightDateViewAdapter(List<Date> dates, Listener listener) {
        this.dates = dates;
        mListener = listener;
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
        String dayOfWeek = FormatUtils.getDayOfWeek(dates.get(position));
        String dayOfMonth = FormatUtils.getDayOfMonth(dates.get(position).getDate());
        holder.dayOfWeek.setText(dayOfWeek);
        holder.dayOfMonth.setText(dayOfMonth);
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
            if (mListener != null) {
                mListener.onSelectDate(dates.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dates.size();
    }

    static class FlightDateViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        TextView dayOfWeek;
        TextView dayOfMonth;
        public FlightDateViewHolder(View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.itemFlightdate);
            dayOfWeek = itemView.findViewById(R.id.dayOfWeek);
            dayOfMonth = itemView.findViewById(R.id.dayOfMonth);
        }
    }
}
