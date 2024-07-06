package com.example.journeyjoy.utils;

import android.util.Log;

import com.example.journeyjoy.model.city.City;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Utils {
    private static final String[] monthArray = {
            "Invalid",
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    private static final String[] dayArray = {
            "Invalid",
            "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"
    };

    public static Date increaseDate(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        return calendar.getTime();
    }
    public static Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year + 1900, month, day);
        return calendar.getTime();
    }
    public static City convertToCity(String nameAndCode) {
        // name (code)
        String[] split = nameAndCode.split(" ");
        StringBuilder name = new StringBuilder();
        String code;
        for (int i = 0; i + 1 < split.length; i++) {
            name.append(split[i]);
            if (i + 1 < split.length - 1) name.append(" ");
        }
        code = split[split.length - 1].substring(1, split[split.length - 1].length() - 1);
        Log.d("Utils", "convertToCity: " + name + " " + code);
        return new City(name.toString(), code);
    }
    public static String removeYear(String date) {
        return date.substring(0, date.indexOf(','));
    }
    public static String getDateFormat(Date date) {
        String format = getDayOfMonth(date.getDate()) + ' ' + getMonth(date.getMonth()) + ", " + date.getYear();
        return format;
    }

    public static String getDayOfMonth(int day) {
        if (day < 1 || day > 31) throw new IllegalArgumentException("Invalid day");
        if (day > 9) return Integer.toString(day);
        return "0" + Integer.toString(day);
    }
    public static String getMonth(int month) {
        if (month < 1 || month > 12) throw new IllegalArgumentException("Invalid month");
        return monthArray[month];
    }

    public static int getMonth(String month) {
        for (int i = 0; i < monthArray.length; i++) {
            if (month.equals(monthArray[i])) return i;
        }
        throw new IllegalArgumentException("Invalid month");
    }

    public static Date convertToDate(String string) {
        // dd MMM, yyyy
        String[] split = string.split(" ");
        int day = Integer.parseInt(split[0]);
        int month = getMonth(split[1].substring(0, split[1].length() - 1));
        int year = Integer.parseInt(split[2]);
        Log.d("Utils", "convertToDate: " + day + " " + month + " " + year);
        return createDate(year, month, day);
    }

    public static String getDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek < 1 || dayOfWeek > 7)
            throw new IllegalArgumentException("Invalid day");
        return dayArray[dayOfWeek];
    }

    public static String formatFlightDate(Date date) {
        // 02 Jan
        return getDayOfMonth(date.getDate()) + " " + getMonth(date.getMonth());
    }

    public static String formatFlightTime(Date date) {
        // 00:00 AM
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        return sdf.format(date);
    }

    public static String formatFlightPrice(int price) {
        Log.d("Utils", "formatFlightPrice: " + price);
        // $100
        return "$" + price;
    }
}
