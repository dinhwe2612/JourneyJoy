package com.example.journeyjoy.model.city;

import java.util.ArrayList;

public class City {
    String name;
    String abbreviation;
    public City(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
