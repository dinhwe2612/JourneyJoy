package com.example.journeyjoy.screen.homebooking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.journeyjoy.screen.common.controllers.BaseFragment;

public class HomeBookingFragment extends BaseFragment {
    public static Fragment newInstance() {
        return new HomeBookingFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        HomeBookingViewMvc homeBookingViewMvc = getCompositionRoot().getViewMvcFactory().getHomeBookingViewMvc(container);
        return homeBookingViewMvc.getRootView();
    }
}
