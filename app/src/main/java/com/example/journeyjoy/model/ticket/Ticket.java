package com.example.journeyjoy.model.ticket;

import com.example.journeyjoy.model.city.City;

import java.util.Date;

public class Ticket {
    String ticketNumber;
    String flightNumber;
    City fromCity;
    City toCity;
    Date departureDate;
    String departureTime;
    String classType;
    int numberOfAdults;
    int numberOfChildren;
    String[] seatNumber;

    public Ticket(String ticketNumber, String flightNumber, City fromCity, City toCity, Date departureDate, String departureTime, String classType, String[] seatNumber, int numberOfAdults, int numberOfChildren) {
        this.ticketNumber = ticketNumber;
        this.flightNumber = flightNumber;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.classType = classType;
        this.seatNumber = seatNumber;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public City getFromCity() {
        return fromCity;
    }

    public City getToCity() {
        return toCity;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getClassType() {
        return classType;
    }

    public String setClassType(String classType) {
        return this.classType = classType;
    }

    public String[] getSeatNumber() {
        return seatNumber;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }
}
