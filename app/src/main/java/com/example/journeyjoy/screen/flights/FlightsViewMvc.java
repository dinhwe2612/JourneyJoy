package com.example.journeyjoy.screen.flights;

import android.util.Pair;

import com.example.journeyjoy.model.flight.Flight;
import com.example.journeyjoy.screen.common.views.ObservableViewMvc;
import com.example.journeyjoy.screen.flights.flightdatelistview.FlightDateViewAdapter;
import com.example.journeyjoy.screen.flights.flightinfolistview.FlightInfoViewAdapter;

import java.util.Date;
import java.util.List;

public interface FlightsViewMvc extends ObservableViewMvc<FlightsViewMvc.Listener> {
    interface Listener {
        void onNavigateUpClick();
        void onFilterClick();
    }
    void bindFlights(FlightInfoViewAdapter adapter);
    void bindDates(FlightDateViewAdapter adapter);
    void bindNumberOfFlightsStatement(int numberOfFlights, String from, String to);
}
