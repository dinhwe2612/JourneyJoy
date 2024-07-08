package com.example.journeyjoy.common.di;

import com.example.journeyjoy.model.city.City;
import com.example.journeyjoy.model.city.CityRepository;
import com.example.journeyjoy.model.flight.Flight;
import com.example.journeyjoy.model.flight.FlightRepository;
import com.example.journeyjoy.model.flight.FlightSearchCriteria;
import com.example.journeyjoy.model.flight.FlightSearchService;
import com.example.journeyjoy.model.ticket.TicketRepository;
import com.example.journeyjoy.screen.common.dialogs.DialogsEventBus;
import com.example.journeyjoy.utils.FormatUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class CompositionRoot {
    DialogsEventBus mDialogsEventBus;
    CityRepository mCityRepository;
    FlightRepository mFlightRepository;
    FlightSearchService mFlightSearchService;

    TicketRepository mTicketRepository;

    public DialogsEventBus getDialogsEventBus() {
        if (mDialogsEventBus == null) {
            mDialogsEventBus = new DialogsEventBus();
        }
        return mDialogsEventBus;
    }

    public CityRepository getCityRepository() {
        if (mCityRepository == null) {
            mCityRepository = new CityRepository();
        }
        return mCityRepository;

    }

    public FlightRepository getFlightRepository() {
        if (mFlightRepository == null) {
            mFlightRepository = new FlightRepository();
            // add some flights
            List<City> cities = getCityRepository().getCities();
            if (cities.size() >= 2) {
                for (int i = 0; i < 200; i++) {
                    City origin = cities.get(0);
                    City destination = cities.get(1);
                    String flightNumber = "NY" + (100 + i);
                    String flightTime = ((5 + i) % 12 + 1) + ":00 AM";
                    Date flightDate = FormatUtils.getToday();
                    Random random = new Random();
                    int delta = random.nextInt(10);
                    flightDate.setDate(flightDate.getDate() + delta);
                    int price = 50 + i * 10;

                    mFlightRepository.addFlight(new Flight(origin, destination, flightNumber, flightTime, flightDate, price));
                }
            }
        }
        return mFlightRepository;
    }

    public FlightSearchService getFlightSearchService() {
        if (mFlightSearchService == null) {
            mFlightSearchService = new FlightSearchService();
        }
        return mFlightSearchService;
    }



    public void setFlightSearchCriteria(FlightSearchCriteria flightSearchCriteria) {
        getFlightSearchService().setCurrentCriteria(flightSearchCriteria);
    }

    public List<Flight> getFlightsFromDate(Date date) {
        return getFlightSearchService().getFlightsFromDate(getFlightRepository().getFlights(), date);
    }

    public Flight getFlight(String flightNumber) {
        for (Flight flight : getFlightRepository().getFlights()) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    public TicketRepository getTicketRepository() {
        if (mTicketRepository == null) {
            mTicketRepository = new TicketRepository();
        }
        return mTicketRepository;
    }
}
