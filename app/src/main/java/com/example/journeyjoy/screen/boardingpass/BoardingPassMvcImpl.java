package com.example.journeyjoy.screen.boardingpass;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeyjoy.R;
import com.example.journeyjoy.model.ticket.Ticket;
import com.example.journeyjoy.screen.common.ViewMvcFactory;
import com.example.journeyjoy.screen.common.toolbar.ToolbarViewMvc;
import com.example.journeyjoy.screen.common.views.BaseObservableViewMvc;
import com.example.journeyjoy.utils.FormatUtils;

public class BoardingPassMvcImpl extends BaseObservableViewMvc<BoardingPassMvc.Listener> implements
        BoardingPassMvc {

    ToolbarViewMvc toolbarViewMvc;
    Toolbar toolbar;
    TextView nameFlight;
    TextView fromCode, toCode;
    TextView fromName, toName;
    TextView dateTicket, departureTicket;
    TextView numberAdults;
    TextView numberTicket;
    TextView classTicket;
    Ticket ticket;
    RecyclerView seatsTicket;
    public BoardingPassMvcImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        setRootView(inflater.inflate(R.layout.layout_boardingpass, parent, false));
        bindView();
        toolbarViewMvc = viewMvcFactory.getToolbarViewMvc(parent);
        toolbarViewMvc.setTitle("Boarding Pass");
        toolbarViewMvc.enableUpButtonAndListen(new ToolbarViewMvc.NavigateUpClickListener() {
            @Override
            public void onNavigateUpClick() {
                for (Listener listener : getListeners()) {
                    listener.onNavigateUp();
                }
            }
        });
        toolbar.addView(toolbarViewMvc.getRootView());
    }

    private void setData() {
        nameFlight.setText("British Airways Flight " + ticket.getFlightNumber());
        fromCode.setText(ticket.getFromCity().getAbbreviation());
        toCode.setText(ticket.getToCity().getAbbreviation());
        fromName.setText(ticket.getFromCity().getName());
        toName.setText(ticket.getToCity().getName());
        dateTicket.setText(FormatUtils.formatFlightDate(ticket.getDepartureDate()));
        departureTicket.setText(ticket.getDepartureTime());
        numberAdults.setText(String.valueOf(ticket.getNumberOfAdults()) + " Adult" + (ticket.getNumberOfAdults() > 1 ? "s" : ""));
        numberTicket.setText(String.valueOf(ticket.getTicketNumber()));
        classTicket.setText(ticket.getClassType());
        seatsTicket.setAdapter(new SeatsTicketAdapter(ticket.getSeatNumber()));
        seatsTicket.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    void bindView() {
        toolbar = findViewById(R.id.toolbar);
        nameFlight = findViewById(R.id.nameFlight);
        fromCode = findViewById(R.id.fromCode);
        toCode = findViewById(R.id.toCode);
        fromName = findViewById(R.id.fromName);
        toName = findViewById(R.id.toName);
        dateTicket = findViewById(R.id.dateTicket);
        departureTicket = findViewById(R.id.departureTicket);
        numberAdults = findViewById(R.id.numberAdults);
        numberTicket = findViewById(R.id.numberTicket);
        classTicket = findViewById(R.id.classTicket);
        seatsTicket = findViewById(R.id.seatsTicket);
    }

    @Override
    public void bindTicket(Ticket ticket) {
        this.ticket = ticket;
        setData();
    }
}
