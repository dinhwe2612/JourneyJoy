package com.example.journeyjoy.model.flight;

import android.util.Log;

import com.example.journeyjoy.model.city.City;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlightSearchCriteria {
    private City origin;
    private City destination;
    private Date departureDate;

    public FlightSearchCriteria(City origin, City destination, Date departureDate) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
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
}
