package com.example.journeyjoy.model.flight;

import com.example.journeyjoy.model.city.City;

import java.util.ArrayList;

public class FlightRepository {
    ArrayList<Flight> mFlights;

    public FlightRepository() {
        mFlights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        mFlights.add(flight);
    }

    public ArrayList<Flight> getFlights() {
        return mFlights;
    }
}
