package com.example.journeyjoy.screen.common.dialogs.dateselectordialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.journeyjoy.screen.common.dialogs.BaseDialog;
import com.example.journeyjoy.screen.common.dialogs.DialogsEventBus;

import java.util.Calendar;

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
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(requireContext(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        DateSelectEvent event = new DateSelectEvent(year, month, dayOfMonth);
        dialogsEventBus.postEvent(event);
    }
}
