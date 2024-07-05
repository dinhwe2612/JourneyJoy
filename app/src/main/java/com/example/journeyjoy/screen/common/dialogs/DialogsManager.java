package com.example.journeyjoy.screen.common.dialogs;

import android.content.Context;
import android.icu.text.IDNA;

import androidx.fragment.app.FragmentManager;

import com.example.journeyjoy.model.city.City;
import com.example.journeyjoy.screen.common.dialogs.dateselectordialog.DateSelectorDialog;
import com.example.journeyjoy.screen.common.dialogs.infodialog.InfoDialog;
import com.example.journeyjoy.screen.common.dialogs.pickerdialog.PickerDialog;

import java.util.ArrayList;

public class DialogsManager {
    private Context mContext;
    private final FragmentManager mFragmentManager;

    public DialogsManager(Context context, FragmentManager fragmentManager) {
        mContext = context;
        mFragmentManager = fragmentManager;
    }

    public void showSearchDialog(String keyword) {
        InfoDialog dialog = InfoDialog.newInstance("Search results for: " + keyword, "No results found.", "OK");
        dialog.show(mFragmentManager, "search_dialog");
    }

    public void showDateSelectorDialog() {
        DateSelectorDialog dialog = DateSelectorDialog.newInstance();
        dialog.show(mFragmentManager, "date_selector_dialog");
    }

    public void showStartingPointPickerDialog(ArrayList<String> nameOfCities) {
        PickerDialog dialog = PickerDialog.newInstance("Starting point", "Select a starting point", "OK", nameOfCities);
        dialog.show(mFragmentManager, "starting_point_dialog");
    }

    public void showDestinationPickerDialog(ArrayList<String> nameOfCities) {
        PickerDialog dialog = PickerDialog.newInstance("Destination", "Select a destination", "OK", nameOfCities);
        dialog.show(mFragmentManager, "destination_dialog");
    }
}
