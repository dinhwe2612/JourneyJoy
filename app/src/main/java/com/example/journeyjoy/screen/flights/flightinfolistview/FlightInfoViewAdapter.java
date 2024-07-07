package com.example.journeyjoy.screen.flights.flightinfolistview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeyjoy.R;
import com.example.journeyjoy.model.flight.Flight;
import com.example.journeyjoy.utils.FormatUtils;

import java.util.Date;
import java.util.List;

public class FlightInfoViewAdapter extends RecyclerView.Adapter<FlightInfoViewAdapter.FlightInfoViewHolder> {

    public interface Listener {
        void onFlightInfoClicked(String flightNumber);
    }
    Listener listener;
    List<Flight> flights;
    public FlightInfoViewAdapter(List<Flight> flights, Listener listener) {
        this.flights = flights;
        this.listener = listener;
    }

    public void setFlights(List<Flight> flightsFromDate) {
        this.flights = flightsFromDate;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FlightInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_flightinfo, null);
        return new FlightInfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlightInfoViewHolder holder, int position) {
        holder.toCode.setText(flights.get(position).getOrigin().getAbbreviation());
        holder.toName.setText(flights.get(position).getOrigin().getName());
        holder.fromCode.setText(flights.get(position).getDestination().getAbbreviation());
        holder.fromName.setText(flights.get(position).getDestination().getName());
        Date date = flights.get(position).getFlightDate();
        holder.date.setText(FormatUtils.formatFlightDate(date));
        holder.time.setText(flights.get(position).getFlightTime());
        holder.price.setText(FormatUtils.formatFlightPrice(flights.get(position).getPrice()));
        holder.number.setText(flights.get(position).getFlightNumber());
        holder.ticketView.setOnClickListener(v -> {
            listener.onFlightInfoClicked(flights.get(position).getFlightNumber());
        });
    }

    @Override
    public int getItemCount() {
        return flights.size();
    }

    static class FlightInfoViewHolder extends RecyclerView.ViewHolder {

        LinearLayout ticketView;
        TextView toCode, toName, fromCode, fromName, date, time, price, number;
        public FlightInfoViewHolder(View itemView) {
            super(itemView);
            ticketView = itemView.findViewById(R.id.ticketView);
            toCode = itemView.findViewById(R.id.toCode);
            toName = itemView.findViewById(R.id.toName);
            fromCode = itemView.findViewById(R.id.fromCode);
            fromName = itemView.findViewById(R.id.fromName);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
            price = itemView.findViewById(R.id.price);
            number = itemView.findViewById(R.id.number);
        }
    }
}
