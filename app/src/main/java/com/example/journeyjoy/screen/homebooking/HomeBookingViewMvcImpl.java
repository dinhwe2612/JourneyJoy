package com.example.journeyjoy.screen.homebooking;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import androidx.annotation.Nullable;

import com.example.journeyjoy.R;
import com.example.journeyjoy.screen.common.ViewMvcFactory;
import com.example.journeyjoy.screen.common.toolbar.ToolbarViewMvc;
import com.example.journeyjoy.screen.common.views.BaseObservableViewMvc;
import com.vipulasri.ticketview.TicketView;

import java.util.zip.Inflater;

public class HomeBookingViewMvcImpl extends BaseObservableViewMvc<HomeBookingViewMvc.Listener> implements
        HomeBookingViewMvc {


    Toolbar toolbar;
    ToolbarViewMvc toolbarViewMvc;
    public HomeBookingViewMvcImpl(LayoutInflater layoutInflater, @Nullable ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        setRootView(layoutInflater.inflate(R.layout.layout_bookinghome, parent, false));
        toolbar = findViewById(R.id.toolbar);
        toolbarViewMvc = viewMvcFactory.getToolbarViewMvc(toolbar);
        toolbarViewMvc.setTitle("Booking");
        toolbar.addView(toolbarViewMvc.getRootView());
        TicketView ticketView = findViewById(R.id.ticketViewTransport);
        ticketView.setOnClickListener(v -> {
            for (Listener listener : getListeners()) {
                listener.onTransportClicked();
            }
        });
    }
}
