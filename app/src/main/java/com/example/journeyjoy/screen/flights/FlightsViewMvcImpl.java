package com.example.journeyjoy.screen.flights;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toolbar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeyjoy.R;
import com.example.journeyjoy.screen.common.ViewMvcFactory;
import com.example.journeyjoy.screen.common.toolbar.ToolbarViewMvc;
import com.example.journeyjoy.screen.common.views.BaseObservableViewMvc;
import com.example.journeyjoy.screen.flights.flightdatelistview.FlightDateViewAdapter;
import com.example.journeyjoy.screen.flights.flightinfolistview.FlightDateViewDecorator;
import com.example.journeyjoy.screen.flights.flightinfolistview.FlightInfoViewAdapter;

public class FlightsViewMvcImpl extends BaseObservableViewMvc<FlightsViewMvc.Listener> implements FlightsViewMvc {

    Toolbar mToolbar;
    ToolbarViewMvc mToolbarViewMvc;
    RecyclerView mFlightDates, mFlightInfos;
    public FlightsViewMvcImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        setRootView(inflater.inflate(R.layout.layout_flights, parent, false));
        mToolbar = findViewById(R.id.toolbar);
        mToolbarViewMvc = viewMvcFactory.getToolbarViewMvc(parent);
        mToolbarViewMvc.setTitle("Flights");
        mToolbarViewMvc.enableUpButtonAndListen(new ToolbarViewMvc.NavigateUpClickListener() {
            @Override
            public void onNavigateUpClick() {
                for (Listener listener : getListeners()) {
                    listener.onNavigateUpClick();
                }
            }
        });
        mToolbar.addView(mToolbarViewMvc.getRootView());
        mFlightDates = findViewById(R.id.flightDateList);
        mFlightDates.setAdapter(new FlightDateViewAdapter());
        mFlightDates.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mFlightInfos = findViewById(R.id.flightInfoList);
        mFlightInfos.addItemDecoration(new FlightDateViewDecorator(25));
        mFlightInfos.setAdapter(new FlightInfoViewAdapter());
        mFlightInfos.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }
}
