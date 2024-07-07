package com.example.journeyjoy.model.flight;

import com.example.journeyjoy.model.city.City;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class Flight {
    City destination, origin;
    String flightNumber;
    String flightTime;
    Date flightDate;
    int price;
    boolean[][] isBooked;

    public Flight(City origin, City destination, String flightNumber, String flightTime, Date flightDate, int price) {
        this.origin = origin;
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.flightTime = flightTime;
        this.flightDate = flightDate;
        this.price = price;
        isBooked = new boolean[4][7];
    }
    public void bookSeat(int row, int col) {
        isBooked[row][col] = true;
    }

    public boolean[][] getIsBooked() {
        return isBooked;
    }

    public City getOrigin() {
        return origin;
    }

    public City getDestination() {
        return destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }
    public String getFlightTime() {
        return flightTime;
    }
    public Date getFlightDate() {
        return flightDate;
    }
    public int getPrice() {
        return price;
    }

    public static class TimeComparator implements Comparator<Flight> {
        private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("h:mm a");

        @Override
        public int compare(Flight a1, Flight a2) {
            try {
                Date date1 = TIME_FORMAT.parse(a1.getFlightTime());
                Date date2 = TIME_FORMAT.parse(a2.getFlightTime());

                if (date1.before(date2)) {
                    return -1;
                } else if (date1.after(date2)) {
                    return 1;
                } else {
                    return 0;
                }
            } catch (ParseException e) {
                e.printStackTrace();
                return 0; // Handle parsing exception as needed
            }
        }
    }

    public static class PriceComparator implements Comparator<Flight> {
        @Override
        public int compare(Flight o1, Flight o2) {
            return Integer.compare(o1.getPrice(), o2.getPrice());
        }
    }
}
