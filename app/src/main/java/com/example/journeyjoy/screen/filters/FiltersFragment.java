package com.example.journeyjoy.screen.filters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.journeyjoy.model.flight.FlightFilters;
import com.example.journeyjoy.screen.common.controllers.BaseFragment;
import com.example.journeyjoy.screen.common.navbottom.HideNavBottom;
import com.example.journeyjoy.screen.common.screensnavigator.ScreensNavigator;

public class FiltersFragment extends BaseFragment implements FiltersViewMvc.Listener, HideNavBottom {

    public static Fragment newInstance() {
        return new FiltersFragment();
    }
    FiltersViewMvc viewMvc;
    ScreensNavigator screensNavigator;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screensNavigator = getCompositionRoot().getScreensNavigator();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewMvc = getCompositionRoot().getViewMvcFactory().getFiltersViewMvc(container);
        return viewMvc.getRootView();
    }

    @Override
    public void onDoneClick(FlightFilters filters) {
        getCompositionRoot().getFlightSearchService().setCurrentFilters(filters);
        screensNavigator.navigateUp();
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
