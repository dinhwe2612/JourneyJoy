package com.example.journeyjoy.screen.selectseats;

import com.example.journeyjoy.model.flight.Flight;
import com.example.journeyjoy.model.ticket.Ticket;
import com.example.journeyjoy.screen.common.views.ObservableViewMvc;

public interface SelectSeatsViewMvc extends ObservableViewMvc<SelectSeatsViewMvc.Listener> {
    interface Listener {
        void onNavigateUp();

        void onContinueClick(Ticket ticket);
    }
    void bindFlight(Flight flight);
    void bindNumberOfTravelers(int numberOfAdults, int numberOfChildren);
}
