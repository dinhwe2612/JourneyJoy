package com.example.journeyjoy.screen.transportbooking;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.journeyjoy.model.flight.FlightSearchCriteria;
import com.example.journeyjoy.screen.common.controllers.BaseFragment;
import com.example.journeyjoy.screen.common.dialogs.DialogsEventBus;
import com.example.journeyjoy.screen.common.dialogs.DialogsManager;
import com.example.journeyjoy.screen.common.dialogs.dateselectordialog.DateSelectEvent;
import com.example.journeyjoy.screen.common.dialogs.pickerdialog.PickEvent;
import com.example.journeyjoy.screen.common.navbottom.HideNavBottom;
import com.example.journeyjoy.screen.common.screensnavigator.ScreensNavigator;

import java.util.Objects;

public class TransportBookingFragment extends BaseFragment implements
        HideNavBottom, TransportBookingViewMvc.Listener, DialogsEventBus.Listener {
    public static Fragment newInstance() {
        return new TransportBookingFragment();
    }

    TransportBookingViewMvc viewMvc;

    ScreensNavigator mScreensNavigator;

    DialogsEventBus mDialogsEventBus;

    DialogsManager mDialogsManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScreensNavigator = getCompositionRoot().getScreensNavigator();
        mDialogsEventBus = getCompositionRoot().getDialogsEventBus();
        mDialogsManager = getCompositionRoot().getDialogsManager();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewMvc = getCompositionRoot().getViewMvcFactory().getTransportBookingViewMvc(container);
        return viewMvc.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        viewMvc.registerListener(this);
        mDialogsEventBus.registerListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        viewMvc.unregisterListener(this);
        mDialogsEventBus.unregisterListener(this);
    }

    @Override
    public void onNavigateUpClick() {
        mScreensNavigator.navigateUp();
    }

    @Override
    public void onSearchClick(FlightSearchCriteria flightSearchCriteria) {
        getCompositionRoot().setFlightSearchCriteria(flightSearchCriteria);
        mScreensNavigator.toFlights();
    }

    @Override
    public void onDateClick() {
        mDialogsManager.showDateSelectorDialog();
    }

    @Override
    public void onSelectStartingPoint() {
        mDialogsManager.showStartingPointPickerDialog(getCompositionRoot().getCityRepository().getNameOfCities());
    }

    @Override
    public void onSelectDestination() {
        mDialogsManager.showDestinationPickerDialog(getCompositionRoot().getCityRepository().getNameOfCities());
    }

    @Override
    public void showCommingSoonDialog() {
        mDialogsManager.showCommingSoonDialog();
    }

    @Override
    public void onDialogEvent(Object event) {
        if (event instanceof DateSelectEvent) {
            DateSelectEvent dateSelectedEvent = (DateSelectEvent) event;
            viewMvc.updateDate(dateSelectedEvent.getDate());
        }
        if (event instanceof PickEvent) {
            PickEvent pickEvent = (PickEvent) event;
            if (Objects.equals(((PickEvent) event).getPickerTitle(), "Starting point")) {
                viewMvc.updateStartingPoint(pickEvent.getPickerContent());
            }
            if (Objects.equals(((PickEvent) event).getPickerTitle(), "Destination")) {
                viewMvc.updateDestination(pickEvent.getPickerContent());
            }
        }
    }
}
