package com.example.journeyjoy.screen.boardingpass;

import com.example.journeyjoy.model.ticket.Ticket;
import com.example.journeyjoy.screen.common.views.ObservableViewMvc;

public interface BoardingPassMvc extends ObservableViewMvc<BoardingPassMvc.Listener> {
    interface Listener {
        void onNavigateUp();
    }
    void bindTicket(Ticket ticket);
}
