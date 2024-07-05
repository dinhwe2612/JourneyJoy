package com.example.journeyjoy.model.flight;

import com.example.journeyjoy.model.city.City;

public class Flight {
    City destination, origin;
    String flightNumber;
    String flightTime;
    String flightDate;
    int price;

    public Flight(City origin, City destination, String flightNumber, String flightTime, String flightDate, int price) {
        this.origin = origin;
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.flightTime = flightTime;
        this.flightDate = flightDate;
    }
}
