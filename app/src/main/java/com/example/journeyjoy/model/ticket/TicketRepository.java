package com.example.journeyjoy.model.ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketRepository {
    List<Ticket> tickets;
    public TicketRepository() {
        tickets = new ArrayList<>();
    }
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
    public List<Ticket> getTickets() {
        return tickets;
    }

    public Ticket getTicket(String ticketNumber) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketNumber().equals(ticketNumber)) {
                return ticket;
            }
        }
        return null;
    }
}
