package com.example.journeyjoy.screen.flights;

import com.example.journeyjoy.screen.common.views.ObservableViewMvc;

public interface FlightsViewMvc extends ObservableViewMvc<FlightsViewMvc.Listener> {
    interface Listener {
        void onNavigateUpClick();
    }
}
