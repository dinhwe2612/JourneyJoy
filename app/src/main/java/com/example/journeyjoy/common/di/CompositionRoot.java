package com.example.journeyjoy.common.di;

import android.app.Dialog;

import com.example.journeyjoy.model.city.City;
import com.example.journeyjoy.model.flight.Flight;
import com.example.journeyjoy.model.flight.FlightSearchCriteria;
import com.example.journeyjoy.model.flight.FlightSearchService;
import com.example.journeyjoy.screen.common.dialogs.DialogsEventBus;
import com.example.journeyjoy.screen.common.dialogs.DialogsManager;
import com.example.journeyjoy.utils.Utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CompositionRoot {
    DialogsEventBus mDialogsEventBus;
    ArrayList<City> mCities;
    ArrayList<Flight> mFlights;
    FlightSearchService mFlightSearchService;

    public DialogsEventBus getDialogsEventBus() {
        if (mDialogsEventBus == null) {
            mDialogsEventBus = new DialogsEventBus();
        }
        return mDialogsEventBus;
    }

    public ArrayList<City> getCities() {
        if (mCities == null) {
            mCities = new ArrayList<>();
            mCities.add(new City("New York", "NY"));
            mCities.add(new City("London", "LDN"));
            mCities.add(new City("Los Angeles", "LA"));
            mCities.add(new City("Chicago", "Chicago"));
            mCities.add(new City("Houston", "Hst"));
            mCities.add(new City("Philadelphia", "Phil"));
            mCities.add(new City("Phoenix", "Phx"));
            mCities.add(new City("San Antonio", "San"));
            mCities.add(new City("San Diego", "SD"));
            mCities.add(new City("Dallas", "Dallas"));
            mCities.add(new City("San Jose", "SJ"));
            mCities.add(new City("Austin", "Austin"));
            mCities.add(new City("Jacksonville", "JAX"));
            mCities.add(new City("San Francisco", "SF"));
            mCities.add(new City("Indianapolis", "Ind"));
            mCities.add(new City("Columbus", "Columbus"));
            mCities.add(new City("Fort Worth", "FW"));
        }
        return mCities;
    }

    public ArrayList<Flight> getFlights() {
        if (mFlights == null) {
            mFlights = new ArrayList<>();
            // add some flights
            List<City> cities = getCities();
            if (cities.size() >= 2) {
                for (int i = 0; i < 10; i++) {
                    City origin = cities.get(0);
                    City destination = cities.get(1);
                    String flightNumber = "NY" + (100 + i);
                    String flightTime = (9 + i % 12) + ":00 AM";
                    Date flightDate = Utils.createDate(2024, Calendar.JULY + 1, 6 + i);
                    int price = 50 + i * 10;

                    mFlights.add(new Flight(origin, destination, flightNumber, flightTime, flightDate, price));
                }
            }
        }
        return mFlights;
    }

    public FlightSearchService getFlightSearchService() {
        if (mFlightSearchService == null) {
            mFlightSearchService = new FlightSearchService();
        }
        return mFlightSearchService;
    }

    public ArrayList<String> getNameOfCities() {
        ArrayList<String> names = new ArrayList<>();
        for (City city : getCities()) {
            names.add(city.getName() + " (" + city.getAbbreviation() + ")");
        }
        return names;
    }

    public void setFlightSearchCriteria(FlightSearchCriteria flightSearchCriteria) {
        getFlightSearchService().setCurrentCriteria(flightSearchCriteria);
    }

    public List<Flight> getFlightsFromDate(Date date) {
        return getFlightSearchService().getFlightsFromDate(getFlights(), date);
    }
}
