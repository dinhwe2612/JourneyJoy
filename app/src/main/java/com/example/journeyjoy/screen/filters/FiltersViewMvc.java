package com.example.journeyjoy.screen.filters;

import com.example.journeyjoy.model.flight.FlightFilters;
import com.example.journeyjoy.screen.common.views.BaseObservableViewMvc;
import com.example.journeyjoy.screen.common.views.ObservableViewMvc;

public interface FiltersViewMvc extends ObservableViewMvc<FiltersViewMvc.Listener> {
    interface Listener {
        void onDoneClick(FlightFilters filters);
        void onNavigateUp();

    }
}
