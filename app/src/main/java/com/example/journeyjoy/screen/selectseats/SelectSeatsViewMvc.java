package com.example.journeyjoy.screen.selectseats;

import com.example.journeyjoy.model.flight.Flight;
import com.example.journeyjoy.screen.common.views.ObservableViewMvc;

public interface SelectSeatsViewMvc extends ObservableViewMvc<SelectSeatsViewMvc.Listener> {
    interface Listener {
        void onNavigateUp();

        void onContinueClick();
    }
    void bindFlight(Flight flight);
    void bindNumberOfTravelers(int numberOfTravelers);
}
