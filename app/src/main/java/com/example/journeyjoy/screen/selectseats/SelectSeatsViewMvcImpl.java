package com.example.journeyjoy.screen.selectseats;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeyjoy.R;
import com.example.journeyjoy.model.city.City;
import com.example.journeyjoy.model.flight.Flight;
import com.example.journeyjoy.model.ticket.Ticket;
import com.example.journeyjoy.screen.common.ViewMvcFactory;
import com.example.journeyjoy.screen.common.toolbar.ToolbarViewMvc;
import com.example.journeyjoy.screen.common.views.BaseObservableViewMvc;
import com.example.journeyjoy.screen.selectseats.seatnumberlistview.SeatNumberViewAdapter;
import com.example.journeyjoy.screen.selectseats.seatslistview.SeatViewAdapter;
import com.example.journeyjoy.screen.selectseats.travellerlistview.TravellerViewAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SelectSeatsViewMvcImpl extends BaseObservableViewMvc<SelectSeatsViewMvc.Listener> implements
        SelectSeatsViewMvc,
        SeatViewAdapter.Listener,
        TravellerViewAdapter.Listener {

    Toolbar toolbar;
    ToolbarViewMvc toolbarViewMvc;
    RecyclerView[] seatList = new RecyclerView[4];
    SeatViewAdapter[] seatAdapter = new SeatViewAdapter[4];
    RecyclerView seatNumber;
    RecyclerView numberTraveller;
    Flight flight;
    List<Pair<Integer, Integer>> selectedSeats;
    Button continueBtn;
    TextView detailSeatText;
    TextView totalPriceText;
    TravellerViewAdapter travellerAdapter;
    String[] seatName;
    int numberOfAdults = 0;
    int numberOfChildren = 0;

    int totalPrice = 0;

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

        detailSeatText = findViewById(R.id.detailSeatText);
        totalPriceText = findViewById(R.id.totalPriceText);

        seatList[0] = findViewById(R.id.seatListA);
        seatList[1] = findViewById(R.id.seatListB);
        seatList[2] = findViewById(R.id.seatListC);
        seatList[3] = findViewById(R.id.seatListD);

        seatNumber = findViewById(R.id.seatNumber);
        seatNumber.setAdapter(new SeatNumberViewAdapter());
        seatNumber.setLayoutManager(new LinearLayoutManager(getContext()));

        numberTraveller = findViewById(R.id.travellerRV);

        continueBtn = findViewById(R.id.continueBtn);
        continueBtn.setOnClickListener(v -> {
            if (travellerAdapter.isEndOfList()) {
                Ticket ticket = getTicket();
                for (Listener listener : getListeners()) {
                    listener.onContinueClick(ticket);
                }
            } else {
                travellerAdapter.nextTraveller();
                numberTraveller.scrollToPosition(travellerAdapter.getSelectedTraveller());
            }
        });
    }

    private Ticket getTicket() {
        String flightNumber = flight.getFlightNumber();
        City from = flight.getOrigin();
        City to = flight.getDestination();
        Date date = flight.getFlightDate();
        String time = flight.getFlightTime();
        String classType = "";
        return new Ticket("hihi", flightNumber, from, to, date, time, classType, seatName, numberOfAdults, numberOfChildren);
    }

    @Override
    public void bindFlight(Flight flight) {
        this.flight = flight;
        boolean[][] seat = flight.getIsBooked();
        for (int i = 0; i < 4; i++) {
            seatAdapter[i] = new SeatViewAdapter(i, seat[i], this);
            seatList[i].setAdapter(seatAdapter[i]);
            seatList[i].setLayoutManager(new LinearLayoutManager(getContext()));
        }
    }

    @Override
    public void bindNumberOfTravelers(int numberOfAdults, int numberOfChildren) {
        int numberOfTravelers = numberOfAdults + numberOfChildren;
        this.numberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;
        selectedSeats = new ArrayList<>();
        for (int i = 0; i < numberOfTravelers; i++) {
            selectedSeats.add(null);
        }
        seatName = new String[numberOfTravelers];
        travellerAdapter = new TravellerViewAdapter(numberOfTravelers, this);
        numberTraveller.setAdapter(travellerAdapter);
        numberTraveller.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public boolean onSeatClicked(int col, int row) {
        boolean isAvailable = seatAdapter[col].isAvailable(row);
        int currentTraveller = travellerAdapter.getSelectedTraveller();
        if (selectedSeats.get(currentTraveller) == null) {
            if (isAvailable) {
                selectedSeats.set(currentTraveller, new Pair<>(col, row));
                setSeatName(currentTraveller);
                addTotalPrice();
                return true;
            }
        } else {
            if (selectedSeats.get(currentTraveller).first == col && selectedSeats.get(currentTraveller).second == row ) {
                if (!isAvailable) {
                    selectedSeats.set(currentTraveller, null);
                    setSeatName(currentTraveller);
                    decreaseTotalPrice();
                    return true;
                }
            }
        }
        return false;
    }

    void setSeatName(int currentTraveller) {
        //Traveller 1/Seat 2A
        if (selectedSeats.get(currentTraveller) == null) {
            detailSeatText.setText("Select a seat");
            seatName[currentTraveller] = "";
            return;
        }
        seatName[currentTraveller] = "";
        String name = "Traveller " + (currentTraveller + 1) + "/Seat ";
        seatName[currentTraveller] += (selectedSeats.get(currentTraveller).second + 1);
        if (selectedSeats.get(currentTraveller).first == 0) {
            seatName[currentTraveller] += "A";
        } else if (selectedSeats.get(currentTraveller).first == 1) {
            seatName[currentTraveller] += "B";
        } else if (selectedSeats.get(currentTraveller).first == 2) {
            seatName[currentTraveller] += "C";
        } else if (selectedSeats.get(currentTraveller).first == 3) {
            seatName[currentTraveller] += "D";
        }
        name += seatName[currentTraveller];
        detailSeatText.setText(name);
    }

    void addTotalPrice() {
        totalPrice += flight.getPrice();
        totalPriceText.setText("$" + totalPrice + ".00");
    }

    void decreaseTotalPrice() {
        totalPrice -= flight.getPrice();
        totalPriceText.setText("$" + totalPrice + ".00");
    }

    @Override
    public void onSelectedTravellerChanged(int newTraveller) {
        setSeatName(newTraveller);
    }
}
