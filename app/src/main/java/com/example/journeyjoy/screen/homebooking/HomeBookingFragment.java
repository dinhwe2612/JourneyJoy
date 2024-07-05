package com.example.journeyjoy.screen.homebooking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.journeyjoy.screen.common.controllers.BaseFragment;
import com.example.journeyjoy.screen.common.screensnavigator.ScreensNavigator;

public class HomeBookingFragment extends BaseFragment
    implements HomeBookingViewMvc.Listener{
    public static Fragment newInstance() {
        return new HomeBookingFragment();
    }

    ScreensNavigator mScreensNavigator;
    HomeBookingViewMvc viewMvc;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScreensNavigator = getCompositionRoot().getScreensNavigator();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewMvc = getCompositionRoot().getViewMvcFactory().getHomeBookingViewMvc(container);
        return viewMvc .getRootView();
    }

    @Override
    public void onTransportClicked() {
        mScreensNavigator.toTransportBooking();
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
