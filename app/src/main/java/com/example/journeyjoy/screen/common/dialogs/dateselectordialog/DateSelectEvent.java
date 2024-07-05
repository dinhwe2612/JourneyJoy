package com.example.journeyjoy.screen.common.dialogs.dateselectordialog;

public class DateSelectEvent {
    private final int year;
    private final int month;
    private final int dayOfMonth;

    public DateSelectEvent(int year, int month, int dayOfMonth) {
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
    }

    public int getYear() { return year; }
    public int getMonth() { return month; }
    public int getDayOfMonth() { return dayOfMonth; }
}
