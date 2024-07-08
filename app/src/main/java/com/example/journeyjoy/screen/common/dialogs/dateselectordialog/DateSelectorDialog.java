package com.example.journeyjoy.screen.common.dialogs.dateselectordialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.journeyjoy.screen.common.dialogs.BaseDialog;
import com.example.journeyjoy.screen.common.dialogs.DialogsEventBus;
import com.example.journeyjoy.utils.FormatUtils;

import java.util.Calendar;
import java.util.Date;

public class DateSelectorDialog extends BaseDialog implements DatePickerDialog.OnDateSetListener {

    private DateSelectorDialog() {

    }

    public static DateSelectorDialog newInstance() {
        return new DateSelectorDialog();
    }

    DialogsEventBus dialogsEventBus;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialogsEventBus = getCompositionRoot().getDialogsEventBus();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog = new DatePickerDialog(requireContext(), this, year, month, day);
        dialog.getDatePicker().setMinDate(Calendar.getInstance().getTimeInMillis());
        return dialog;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Date date = FormatUtils.createDate(year, month + 1, dayOfMonth);
        DateSelectEvent event = new DateSelectEvent(date);
        dialogsEventBus.postEvent(event);
    }
}
