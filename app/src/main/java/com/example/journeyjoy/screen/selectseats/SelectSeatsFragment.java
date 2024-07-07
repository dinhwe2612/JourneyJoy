package com.example.journeyjoy.screen.selectseats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.journeyjoy.model.ticket.Ticket;
import com.example.journeyjoy.screen.common.controllers.BaseFragment;
import com.example.journeyjoy.screen.common.screensnavigator.ScreensNavigator;

public class SelectSeatsFragment extends BaseFragment implements
        SelectSeatsViewMvc.Listener {

    private static final String ARG_FLIGHTNUMBER = "flightNumber";

    public static Fragment newInstance(String flightNumber) {
        Bundle args = new Bundle();
        args.putString(ARG_FLIGHTNUMBER, flightNumber);
        SelectSeatsFragment fragment = new SelectSeatsFragment();
        fragment.setArguments(args);
        return fragment;
    }
    SelectSeatsViewMvc viewMvc;
    ScreensNavigator screensNavigator;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screensNavigator = getCompositionRoot().getScreensNavigator();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        assert getArguments() != null;
        String flightNumber = getArguments().getString(ARG_FLIGHTNUMBER);
        viewMvc = getCompositionRoot().getViewMvcFactory().getSelectSeatsViewMvc(container);
        viewMvc.bindFlight(getCompositionRoot().getFlight(flightNumber));
        viewMvc.bindNumberOfTravelers(getCompositionRoot().getFlightSearchService().getNumberOfAdults(), getCompositionRoot().getFlightSearchService().getNumberOfChildren());
        return viewMvc.getRootView();
    }


    @Override
    public void onNavigateUp() {
        screensNavigator.navigateUp();
    }

    boolean isLegalTicket(Ticket ticket) {
        for (String seat : ticket.getSeatNumber()) {
            if (seat == null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onContinueClick(Ticket ticket) {
        if (!isLegalTicket(ticket)) {
            Toast.makeText(getActivity(), "Please select all seats", Toast.LENGTH_SHORT).show();
            return;
        }
        ticket.setClassType(getCompositionRoot().getFlightSearchService().getClassType());
        getCompositionRoot().getTicketRepository().addTicket(ticket);
        screensNavigator.toBoardingPass(ticket.getTicketNumber());
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
}
