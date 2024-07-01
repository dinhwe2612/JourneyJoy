package com.example.journeyjoy.screen.homebooking;

import com.example.journeyjoy.screen.common.views.ObservableViewMvc;

public interface HomeBookingViewMvc extends ObservableViewMvc<HomeBookingViewMvc.Listener> {
    interface Listener {
        void onTransportClicked(int position);
    }
}
