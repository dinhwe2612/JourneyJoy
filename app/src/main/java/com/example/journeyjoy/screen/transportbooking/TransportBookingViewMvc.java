package com.example.journeyjoy.screen.transportbooking;

import com.example.journeyjoy.screen.common.views.ObservableViewMvc;

public interface TransportBookingViewMvc extends ObservableViewMvc<TransportBookingViewMvc.Listener> {
    interface Listener {
        void onNavigateUpClick();
        void onSearchClick();
        void onDateClick();

        void onSelectStartingPoint();

        void onSelectDestination();
    }
    void updateDate(int year, int month, int day);
    void updateStartingPoint(String startingPoint);
    void updateDestination(String destination);
}
