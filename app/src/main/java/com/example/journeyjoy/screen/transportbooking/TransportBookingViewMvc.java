package com.example.journeyjoy.screen.transportbooking;

import com.example.journeyjoy.model.flight.FlightSearchCriteria;
import com.example.journeyjoy.screen.common.views.ObservableViewMvc;

import java.util.Date;

public interface TransportBookingViewMvc extends ObservableViewMvc<TransportBookingViewMvc.Listener> {
    interface Listener {
        void onNavigateUpClick();
        void onSearchClick(FlightSearchCriteria searchCriteria);
        void onDateClick();

        void onSelectStartingPoint();

        void onSelectDestination();
    }
    void updateDate(Date date);
    void updateStartingPoint(String startingPoint);
    void updateDestination(String destination);
}
