package com.example.journeyjoy.model.city;

import java.util.ArrayList;

public class CityRepository {
    ArrayList<City> mCities;
    public CityRepository() {
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
    public void addCity(City city) {
        mCities.add(city);
    }
    public ArrayList<City> getCities() {
        return mCities;
    }

    public ArrayList<String> getNameOfCities() {
        ArrayList<String> names = new ArrayList<>();
        for (City city : mCities) {
            names.add(city.getName() + " (" + city.getAbbreviation() + ")");
        }
        return names;
    }
}
