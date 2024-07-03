package com.example.journeyjoy.screen.transportbooking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.journeyjoy.screen.common.controllers.BaseFragment;
import com.example.journeyjoy.screen.common.navbottom.HideNavBottom;
import com.example.journeyjoy.screen.common.screensnavigator.ScreensNavigator;

public class TransportBookingFragment extends BaseFragment implements HideNavBottom, TransportBookingViewMvc.Listener {
    public static Fragment newInstance() {
        return new TransportBookingFragment();
    }

    TransportBookingViewMvc viewMvc;

    ScreensNavigator mScreensNavigator;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScreensNavigator = getCompositionRoot().getScreensNavigator();
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
    }

    @Override
    public void onStop() {
        super.onStop();
        viewMvc.unregisterListener(this);
    }

    @Override
    public void onNavigateUpClick() {
        mScreensNavigator.navigateUp();
    }

    @Override
    public void onSearchClick() {
        mScreensNavigator.toFlights();
    }
}
