package com.example.journeyjoy.screen.flights.flightdatelistview;

import com.example.journeyjoy.screen.common.views.ObservableViewMvc;

public interface FlightDateViewMvc extends ObservableViewMvc<FlightDateViewMvc.Listener> {
    interface Listener {
        void onDateSelected(String date);
    }
    void selectDate();
}
