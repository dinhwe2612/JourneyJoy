package com.example.journeyjoy.model.flight;

import com.example.journeyjoy.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class FlightFilters {
    String minDeparture;
    String maxDeparture;
    String minArrival;
    String maxArrival;
    int minPrice;
    int maxPrice;

    SortBy sortBy;
    public enum SortBy {
        ARRIVAL,
        DEPARTURE,
        Price,
        LowestFare,
        Duration
    };

    public FlightFilters() {
        sortBy = SortBy.DEPARTURE;
        minDeparture = "12:00 AM";
        maxDeparture = "06:00 AM";
        minArrival = "12:00 AM";
        maxArrival = "06:00 AM";
        minPrice = 0;
        maxPrice = 5000;
    }
    public FlightFilters(String minDeparture, String maxDeparture, String minArrival, String maxArrival, int minPrice, int maxPrice, SortBy sortBy) {
        this.minDeparture = minDeparture;
        this.maxDeparture = maxDeparture;
        this.minArrival = minArrival;
        this.maxArrival = maxArrival;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.sortBy = sortBy;
    }

    public List<Flight> filterFlights(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (!Utils.inRange(flight.getFlightTime(), minDeparture, maxDeparture)) continue;
            if (!Utils.inRange(flight.getPrice(), minPrice, maxPrice)) continue;
            filteredFlights.add(flight);
        }
        if (sortBy == SortBy.DEPARTURE) {
            filteredFlights.sort(new Flight.TimeComparator());
        } else if (sortBy == SortBy.Price) {
            filteredFlights.sort(new Flight.PriceComparator());
        }
        return filteredFlights;
    }

}
