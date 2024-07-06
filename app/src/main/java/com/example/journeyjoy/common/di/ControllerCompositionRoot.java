package com.example.journeyjoy.common.di;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.journeyjoy.model.flight.Flight;
import com.example.journeyjoy.model.flight.FlightSearchCriteria;
import com.example.journeyjoy.model.flight.FlightSearchService;
import com.example.journeyjoy.screen.common.ViewMvcFactory;
import com.example.journeyjoy.screen.common.dialogs.DialogsEventBus;
import com.example.journeyjoy.screen.common.dialogs.DialogsManager;
import com.example.journeyjoy.screen.common.fragmentframehelper.FragmentFrameHelper;
import com.example.journeyjoy.screen.common.fragmentframehelper.FragmentFrameWrapper;
import com.example.journeyjoy.screen.common.screensnavigator.ScreensNavigator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControllerCompositionRoot {
    private final ActivityCompositionRoot mActivityCompositionRoot;

    public ControllerCompositionRoot(ActivityCompositionRoot activityCompositionRoot) {
        mActivityCompositionRoot = activityCompositionRoot;
    }

    private FragmentActivity getActivity() {
        return mActivityCompositionRoot.getActivity();
    }

    private Context getContext() {
        return getActivity();
    }

    private FragmentManager getFragmentManager() {
        return getActivity().getSupportFragmentManager();
    }

    private LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(getContext());
    }

    public ViewMvcFactory getViewMvcFactory() {
        return new ViewMvcFactory(getLayoutInflater());
    }

    public ScreensNavigator getScreensNavigator() {
        return new ScreensNavigator(getFragmentFrameHelper());

    }

    private FragmentFrameHelper getFragmentFrameHelper() {
        return new FragmentFrameHelper(getActivity(), getFragmentFrameWrapper(), getFragmentManager());
    }

    private FragmentFrameWrapper getFragmentFrameWrapper() {
        return (FragmentFrameWrapper)getActivity();
    }

    public DialogsManager getDialogsManager() {
        return new DialogsManager(getContext(), getFragmentManager());
    }

    public DialogsEventBus getDialogsEventBus() {
        return mActivityCompositionRoot.getDialogsEventBus();
    }

    public ArrayList<String> getNameOfCities() {
        return mActivityCompositionRoot.getNameOfCities();
    }

    public void setFlightSearchCriteria(FlightSearchCriteria flightSearchCriteria) {
        mActivityCompositionRoot.setFlightSearchCriteria(flightSearchCriteria);
    }

    public List<Flight> getFlightsFromDate(Date date) {
        return mActivityCompositionRoot.getFlightsFromDate(date);

    }

    public FlightSearchService getFlightSearchService() {
        return mActivityCompositionRoot.getFlightSearchService();
    }
}
