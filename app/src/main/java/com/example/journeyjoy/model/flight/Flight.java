package com.example.journeyjoy.model.flight;

import com.example.journeyjoy.model.city.City;

import java.util.Date;

public class Flight {
    City destination, origin;
    String flightNumber;
    String flightTime;
    Date flightDate;
    int price;

    public Flight(City origin, City destination, String flightNumber, String flightTime, Date flightDate, int price) {
        this.origin = origin;
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.flightTime = flightTime;
        this.flightDate = flightDate;
        this.price = price;
    }

    public City getOrigin() {
        return origin;
    }

    public City getDestination() {
        return destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }
    public String getFlightTime() {
        return flightTime;
    }
    public Date getFlightDate() {
        return flightDate;
    }
    public int getPrice() {
        return price;
    }
}
