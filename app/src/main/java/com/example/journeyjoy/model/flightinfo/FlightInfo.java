package com.example.journeyjoy.model.flightinfo;

public class FlightInfo {
    private String departureCity;
    private String arrivalCity;
    private String date;
    private String departureTime;
    private double price;
    private String flightNumber;

    // Constructor
    public FlightInfo(String departureCity, String arrivalCity, String date, String departureTime, double price, String flightNumber) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.date = date;
        this.departureTime = departureTime;
        this.price = price;
        this.flightNumber = flightNumber;
    }

    // Getters and Setters
    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
}
