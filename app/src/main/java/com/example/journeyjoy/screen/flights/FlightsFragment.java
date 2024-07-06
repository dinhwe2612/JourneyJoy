package com.example.journeyjoy.screen.flights;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.journeyjoy.model.flight.Flight;
import com.example.journeyjoy.screen.common.controllers.BaseFragment;
import com.example.journeyjoy.screen.common.navbottom.HideNavBottom;
import com.example.journeyjoy.screen.common.screensnavigator.ScreensNavigator;
import com.example.journeyjoy.screen.flights.flightdatelistview.FlightDateViewAdapter;
import com.example.journeyjoy.screen.flights.flightinfolistview.FlightInfoViewAdapter;

import java.util.Date;
import java.util.List;

public class FlightsFragment extends BaseFragment implements
        FlightsViewMvc.Listener,
        HideNavBottom,
        FlightDateViewAdapter.Listener,
        FlightInfoViewAdapter.Listener{

    public static Fragment newInstance() {
        return new FlightsFragment();
    }

    FlightsViewMvc viewMvc;
    ScreensNavigator screensNavigator;

    FlightDateViewAdapter flightDateViewAdapter;
    FlightInfoViewAdapter flightInfoViewAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screensNavigator = getCompositionRoot().getScreensNavigator();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewMvc = getCompositionRoot().getViewMvcFactory().getFlightsViewMvc(container);
        List<Date> dates = getCompositionRoot().getFlightSearchService().getFlightDate();
        flightDateViewAdapter = new FlightDateViewAdapter(dates, this);
        viewMvc.bindDates(flightDateViewAdapter);
        List<Flight> flights = getCompositionRoot().getFlightsFromDate(dates.get(0));
        flightInfoViewAdapter = new FlightInfoViewAdapter(flights, this);
        viewMvc.bindFlights(flightInfoViewAdapter);
        String from = getCompositionRoot().getFlightSearchService().getStartingPoint();
        String to = getCompositionRoot().getFlightSearchService().getDestination();
        viewMvc.bindNumberOfFlightsStatement(flights.size(), from, to);
        return viewMvc.getRootView();
    }

    @Override
    public void onNavigateUpClick() {
        screensNavigator.navigateUp();
    }

    @Override
    public void onFilterClick() {
        screensNavigator.toFilters();
    }

    @Override
    public void onStart() {
        super.onStart();
        viewMvc.registerListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        viewMvc.unregisterListener(this);
    }

    @Override
    public void onSelectDate(Date date) {
        flightInfoViewAdapter.setFlights(getCompositionRoot().getFlightsFromDate(date));
    }

    @Override
    public void onFlightInfoClicked(int position) {
        screensNavigator.toSelectSeats();
    }
}
