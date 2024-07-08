package com.example.journeyjoy.utils;

import android.util.Log;

import androidx.core.util.Pair;

import com.example.journeyjoy.model.city.City;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FormatUtils {
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
    public static Date createDate(int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year + 1900, month, dayOfMonth);
        return calendar.getTime();
    }
    public static Date getToday() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1900);
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
    public static String getDateFormat(Date date) {
        // dd MMM, yyyy
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

    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("h:mm a");

    public static boolean inRange(String time, String min, String max) {
        try {
            // Parse strings into Date objects
            Date timeDate = TIME_FORMAT.parse(time);
            Date minDate = TIME_FORMAT.parse(min);
            Date maxDate = TIME_FORMAT.parse(max);

            // Check if timeDate is between minDate and maxDate
            assert timeDate != null;
            return timeDate.compareTo(minDate) >= 0 && timeDate.compareTo(maxDate) <= 0;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isLess(String time1, String time2) {
        try {
            // Parse strings into Date objects
            Date date1 = TIME_FORMAT.parse(time1);
            Date date2 = TIME_FORMAT.parse(time2);

            // Compare dates
            return date1.before(date2);
        } catch (ParseException e) {
            e.printStackTrace(); // Handle parsing exception as needed
            return false; // Return false if parsing fails
        }
    }

    public static boolean inRange(int x, int l, int r) {
        return x >= l && x <= r;
    }

    public static Pair<String, String> getTimeRange(int position) {
        switch (position) {
            case 0:
                return new Pair<>("00:00 AM", "06:00 AM");
            case 1:
                return new Pair<>("06:00 AM", "12:00 PM");
            case 2:
                return new Pair<>("12:00 PM", "06:00 PM");
            case 3:
                return new Pair<>("06:00 PM", "12:00 AM");
        }
        return null;
    }
}
