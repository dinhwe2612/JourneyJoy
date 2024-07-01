package com.example.journeyjoy.screen.transportbooking;

import com.example.journeyjoy.screen.common.views.ObservableViewMvc;

public interface TransportBookingViewMvc extends ObservableViewMvc<TransportBookingViewMvc.Listener> {
    interface Listener {
        void onNavigateUpClick();
    }
}
