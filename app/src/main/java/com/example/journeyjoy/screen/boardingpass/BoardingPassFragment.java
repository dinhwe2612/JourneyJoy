package com.example.journeyjoy.screen.boardingpass;

import android.os.Bundle;
import android.service.autofill.SaveCallback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.journeyjoy.screen.common.controllers.BaseFragment;
import com.example.journeyjoy.screen.common.navbottom.HideNavBottom;
import com.example.journeyjoy.screen.common.screensnavigator.ScreensNavigator;

public class BoardingPassFragment extends BaseFragment implements
        HideNavBottom,
        BoardingPassMvc.Listener{
    private static final String ARG_TICKET_NUMBER = "ticket_number";

    BoardingPassFragment() {}
    public static Fragment newInstance(String ticketNumber) {
        BoardingPassFragment fragment = new BoardingPassFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TICKET_NUMBER, ticketNumber);
        fragment.setArguments(args);
        return fragment;
    }

    BoardingPassMvc viewMvc;

    ScreensNavigator screensNavigator;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screensNavigator = getCompositionRoot().getScreensNavigator();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getArguments() == null) throw new AssertionError("No arguments BoardingPass");
        String ticketName = getArguments().getString(ARG_TICKET_NUMBER);
        viewMvc = getCompositionRoot().getViewMvcFactory().getBoardingPassMvc(container);
        viewMvc.bindTicket(getCompositionRoot().getTicketRepository().getTicket(ticketName));
        return viewMvc.getRootView();
    }

    @Override
    public void onNavigateUp() {
        screensNavigator.navigateUp();
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
