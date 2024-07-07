package com.example.journeyjoy.model.flight;

import android.util.Log;

import com.example.journeyjoy.model.city.City;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightSearchCriteria {
    private final City origin;
    private final City destination;
    private final Date departureDate;
    int numAdults;
    int numChildren;
    int numPets;
    int numLuggages;
    String classType;

    public FlightSearchCriteria(City origin, City destination, Date departureDate, int numAdults, int numChildren, int numPets, int numLuggages, String classType) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.numAdults = numAdults;
        this.numChildren = numChildren;
        this.numPets = numPets;
        this.numLuggages = numLuggages;
        this.classType = classType;
    }

    public City getOrigin() {
        return origin;
    }

    public City getDestination() {
        return destination;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public List<Flight> filterFlights(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>();
        String toName = origin.getName();
        String fromName = destination.getName();
        for (Flight flight : flights) {
            String to = flight.getOrigin().getName();
            String from = flight.getDestination().getName();
            Log.d("FlightSearchCriteria", "filterFlights: " + to + " " + from);
            if (to.equals(toName) && from.equals(fromName)) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }

    public int getNumberOfTravelers() {
        return numAdults + numChildren;
    }

    public int getNumberAdults() {
        return numAdults;
    }

    public int getNumberChildren() {
        return numChildren;
    }

    public String getClassType() {
        return classType;
    }
}
