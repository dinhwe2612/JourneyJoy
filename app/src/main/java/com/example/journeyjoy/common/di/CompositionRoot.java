package com.example.journeyjoy.common.di;

import android.app.Dialog;

import com.example.journeyjoy.model.city.City;
import com.example.journeyjoy.model.flight.Flight;
import com.example.journeyjoy.screen.common.dialogs.DialogsEventBus;
import com.example.journeyjoy.screen.common.dialogs.DialogsManager;

import java.util.ArrayList;
import java.util.List;

public class CompositionRoot {
    DialogsEventBus mDialogsEventBus;
    ArrayList<City> mCities;

    ArrayList<Flight> mFlights;


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
            mFlights.add(new Flight(mCities.get(0), mCities.get(1), "NL-41", "9:00 AM", "02 Jun", 50));
            mFlights.add(new Flight(mCities.get(2), mCities.get(3), "US-23", "1:30 PM", "05 Jun", 80));
            mFlights.add(new Flight(mCities.get(4), mCities.get(5), "CA-12", "4:45 PM", "08 Jun", 65));
            mFlights.add(new Flight(mCities.get(6), mCities.get(7), "TX-34", "7:15 AM", "10 Jun", 70));
            mFlights.add(new Flight(mCities.get(8), mCities.get(9), "FL-56", "9:30 AM", "12 Jun", 55));
            mFlights.add(new Flight(mCities.get(10), mCities.get(11), "GA-78", "2:00 PM", "15 Jun", 75));
            mFlights.add(new Flight(mCities.get(12), mCities.get(13), "OH-90", "5:15 PM", "18 Jun", 60));
            mFlights.add(new Flight(mCities.get(14), mCities.get(15), "TX-56", "8:45 AM", "20 Jun", 65));
            mFlights.add(new Flight(mCities.get(0), mCities.get(1), "NY-12", "11:30 AM", "23 Jun", 70));
            mFlights.add(new Flight(mCities.get(2), mCities.get(3), "LA-34", "3:00 PM", "26 Jun", 75));
            mFlights.add(new Flight(mCities.get(4), mCities.get(5), "IL-56", "6:15 PM", "29 Jun", 80));
            mFlights.add(new Flight(mCities.get(6), mCities.get(7), "TX-78", "9:45 AM", "02 Jul", 85));
            mFlights.add(new Flight(mCities.get(8), mCities.get(9), "FL-90", "1:30 PM", "05 Jul", 90));
            mFlights.add(new Flight(mCities.get(10), mCities.get(11), "GA-12", "4:45 PM", "08 Jul", 95));
        }
        return mFlights;
    }

    public ArrayList<String> getNameOfCities() {
        ArrayList<String> names = new ArrayList<>();
        for (City city : getCities()) {
            names.add(city.getName() + " (" + city.getAbbreviation() + ")");
        }
        return names;
    }
}
