package com.example.journeyjoy.common.di;

import androidx.fragment.app.FragmentActivity;

import com.example.journeyjoy.model.flight.Flight;
import com.example.journeyjoy.model.flight.FlightSearchCriteria;
import com.example.journeyjoy.model.flight.FlightSearchService;
import com.example.journeyjoy.screen.common.dialogs.DialogsEventBus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActivityCompositionRoot {
    private final CompositionRoot mCompositionRoot;
    private final FragmentActivity mActivity;


    public ActivityCompositionRoot(CompositionRoot compositionRoot, FragmentActivity activity) {
        mCompositionRoot = compositionRoot;
        mActivity = activity;
    }

    public FragmentActivity getActivity() {
        return mActivity;
    }

    public DialogsEventBus getDialogsEventBus() {
        return mCompositionRoot.getDialogsEventBus();
    }

    public ArrayList<String> getNameOfCities() {
        return mCompositionRoot.getNameOfCities();
    }

    public void setFlightSearchCriteria(FlightSearchCriteria flightSearchCriteria) {
        mCompositionRoot.setFlightSearchCriteria(flightSearchCriteria);
    }

    public List<Flight> getFlightsFromDate(Date date) {
        return mCompositionRoot.getFlightsFromDate(date);
    }

    public FlightSearchService getFlightSearchService() {
        return mCompositionRoot.getFlightSearchService();
    }

    public Flight getFlight(String flightNumber) {
        return mCompositionRoot.getFlight(flightNumber);
    }
}
