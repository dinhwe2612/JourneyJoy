package com.example.journeyjoy.model.flight;

import android.util.Log;

import com.example.journeyjoy.model.city.City;
import com.example.journeyjoy.utils.Utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FlightSearchService {
    private FlightSearchCriteria currentCriteria;
    private FlightFilters currentFilters = new FlightFilters();

    public void setCurrentCriteria(FlightSearchCriteria currentCriteria) {
        this.currentCriteria = currentCriteria;
    }

    public void setCurrentFilters(FlightFilters currentFilters) {
        this.currentFilters = currentFilters;
    }

    public void resetFilters() {
        currentFilters = new FlightFilters();
    }

    public List<Flight> getFlightsFromDate(List<Flight> flights, Date date) {
        if (currentCriteria != null) {
            flights = currentCriteria.filterFlights(flights);
        }
        flights = currentFilters.filterFlights(flights);
        int dateOfMonth = date.getDate();
        int dateMonth = date.getMonth();
        int dateYear = date.getYear();
        List<Flight> flightFiltered = new ArrayList<Flight>();
        for (Flight flight : flights) {
            Date tmp = flight.getFlightDate();
            int tmpDateOfMonth = tmp.getDate();
            int tmpDateMonth = tmp.getMonth();
            int tmpDateYear = tmp.getYear();
            Log.d("FlightSearchService", "tmpDateOfMonth: " + tmpDateOfMonth + " tmpDateMonth: " + tmpDateMonth + " tmpDateYear: " + tmpDateYear);
            if (dateOfMonth == tmpDateOfMonth && dateMonth == tmpDateMonth && dateYear == tmpDateYear) {
                flightFiltered.add(flight);
            }
        }
        return flightFiltered;
    }

    public List<Date> getFlightDate() {
        Date date = currentCriteria.getDepartureDate();
        List<Date> dateList = new ArrayList<Date>();
        for (int i = 0; i < 30; ++i) {
            dateList.add(date);
            date = Utils.increaseDate(date, 1);
        }
        return dateList;
    }

    public String getStartingPoint() {
        return currentCriteria.getOrigin().getName();
    }

    public String getDestination() {
        return currentCriteria.getDestination().getName();
    }

    public int getNumberOfTravelers() {
        return currentCriteria.getNumberOfTravelers();
    }
}
