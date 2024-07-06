package com.example.journeyjoy.screen.flights;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeyjoy.R;
import com.example.journeyjoy.model.flight.Flight;
import com.example.journeyjoy.screen.common.ViewMvcFactory;
import com.example.journeyjoy.screen.common.toolbar.ToolbarViewMvc;
import com.example.journeyjoy.screen.common.views.BaseObservableViewMvc;
import com.example.journeyjoy.screen.flights.flightdatelistview.FlightDateViewAdapter;
import com.example.journeyjoy.screen.flights.flightinfolistview.FlightDateViewDecorator;
import com.example.journeyjoy.screen.flights.flightinfolistview.FlightInfoViewAdapter;

import org.w3c.dom.Text;

import java.util.Date;
import java.util.List;

public class FlightsViewMvcImpl extends BaseObservableViewMvc<FlightsViewMvc.Listener> implements
        FlightsViewMvc{

    Toolbar mToolbar;
    ToolbarViewMvc mToolbarViewMvc;
    RecyclerView mFlightDates, mFlightInfos;

    FlightDateViewAdapter mFlightDateAdapter;
    FlightInfoViewAdapter mFlightInfoAdapter;
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

        mFlightDates.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mFlightInfos = findViewById(R.id.flightInfoList);
        mFlightInfos.addItemDecoration(new FlightDateViewDecorator(25, 25));

        mFlightInfos.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        ImageButton filterBtn = findViewById(R.id.filterBtn);
        filterBtn.setOnClickListener(v -> {
            for (Listener listener : getListeners()) {
                listener.onFilterClick();
            }
        });
    }

    @Override
    public void bindFlights(FlightInfoViewAdapter adapter) {
        mFlightInfos.setAdapter(adapter);
    }

    @Override
    public void bindDates(FlightDateViewAdapter adapter) {
        mFlightDates.setAdapter(adapter);
    }

    @Override
    public void bindNumberOfFlightsStatement(int numberOfFlights, String from, String to) {
        TextView numberOfFlightsView = findViewById(R.id.numberOfFlights);
        String numberOfFlightsText = numberOfFlights + " flights avaliable " + from + " to " + to;
        numberOfFlightsView.setText(numberOfFlightsText);
    }
}
