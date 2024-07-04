package com.example.journeyjoy.screen.selectseats;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toolbar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeyjoy.R;
import com.example.journeyjoy.screen.common.ViewMvcFactory;
import com.example.journeyjoy.screen.common.toolbar.ToolbarViewMvc;
import com.example.journeyjoy.screen.common.views.BaseObservableViewMvc;
import com.example.journeyjoy.screen.selectseats.seatnumberlistview.SeatNumberViewAdapter;
import com.example.journeyjoy.screen.selectseats.seatslistview.SeatViewAdapter;
import com.example.journeyjoy.screen.selectseats.travellerlsitview.TravellerViewAdapter;

public class SelectSeatsViewMvcImpl extends BaseObservableViewMvc<SelectSeatsViewMvc.Listener> implements SelectSeatsViewMvc {

    Toolbar toolbar;
    ToolbarViewMvc toolbarViewMvc;

    public SelectSeatsViewMvcImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        setRootView(inflater.inflate(R.layout.layout_selectseats, parent, false));
        toolbar = findViewById(R.id.toolbar);
        toolbarViewMvc = viewMvcFactory.getToolbarViewMvc(parent);
        toolbarViewMvc.setTitle("Select Seats");
        toolbarViewMvc.enableUpButtonAndListen(new ToolbarViewMvc.NavigateUpClickListener() {
            @Override
            public void onNavigateUpClick() {
                for (Listener listener : getListeners()) {
                    listener.onNavigateUp();
                }
            }
        });
        toolbar.addView(toolbarViewMvc.getRootView());

        RecyclerView seatListA = findViewById(R.id.seatListA);
        seatListA.setAdapter(new SeatViewAdapter());
        seatListA.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView seatListB = findViewById(R.id.seatListB);
        seatListB.setAdapter(new SeatViewAdapter());
        seatListB.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView seatListC = findViewById(R.id.seatListC);
        seatListC.setAdapter(new SeatViewAdapter());
        seatListC.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView seatListD = findViewById(R.id.seatListD);
        seatListD.setAdapter(new SeatViewAdapter());
        seatListD.setLayoutManager(new LinearLayoutManager(getContext()));

        RecyclerView seatNumber = findViewById(R.id.seatNumber);
        seatNumber.setAdapter(new SeatNumberViewAdapter());
        seatNumber.setLayoutManager(new LinearLayoutManager(getContext()));

        RecyclerView numberTraveller = findViewById(R.id.travellerRV);
        numberTraveller.setAdapter(new TravellerViewAdapter());
        numberTraveller.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }
}
