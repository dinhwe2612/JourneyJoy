package com.example.journeyjoy.screen.common.dialogs.dateselectordialog;

import java.util.Date;

public class DateSelectEvent {
    Date date;

    public DateSelectEvent(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }
}
