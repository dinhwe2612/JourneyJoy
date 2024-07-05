package com.example.journeyjoy.screen.transportbooking;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.example.journeyjoy.R;
import com.example.journeyjoy.screen.common.ViewMvcFactory;
import com.example.journeyjoy.screen.common.toolbar.ToolbarViewMvc;
import com.example.journeyjoy.screen.common.views.BaseObservableViewMvc;

public class TransportBookingViewMvcImpl extends BaseObservableViewMvc<TransportBookingViewMvc.Listener> implements TransportBookingViewMvc {

    Toolbar toolbar;
    ToolbarViewMvc toolbarViewMvc;

    boolean isEconomy = true;

    int idButton;

    public TransportBookingViewMvcImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        setRootView(inflater.inflate(R.layout.layout_transportbooking, parent, false));
        toolbar = findViewById(R.id.toolbar);
        toolbarViewMvc = viewMvcFactory.getToolbarViewMvc(toolbar);
        initToolbar();
        setSwapBtn();
        setChangeColorWhenFocus();
        setEconomy();
        setClickListeners();
        Button searchBtn = findViewById(R.id.searchBookingBtn);
        searchBtn.setOnClickListener(v -> {
            for (Listener listener : getListeners()) {
                listener.onSearchClick();
            }
        });
    }

    private void setClickListeners() {
        EditText departureEditText = findViewById(R.id.departureEditText);
        departureEditText.setOnClickListener(v -> {
            idButton = R.id.departureEditText;
            for (Listener listener : getListeners()) {
                listener.onDateClick();
            }
        });
        EditText returnEditText = findViewById(R.id.returnEditText);
        returnEditText.setOnClickListener(v -> {
            idButton = R.id.returnEditText;
            for (Listener listener : getListeners()) {
                listener.onDateClick();
            }
        });
        EditText toEditText = findViewById(R.id.toEditText);
        toEditText.setOnClickListener(v -> {
            for (Listener listener : getListeners()) {
                listener.onSelectDestination();
            }
        });
        EditText fromEditText = findViewById(R.id.fromEditText);
        fromEditText.setOnClickListener(v -> {
            for (Listener listener : getListeners()) {
                listener.onSelectStartingPoint();
            }
        });
    }

    void initToolbar() {
        toolbarViewMvc.setTitle("Transport Booking");
        toolbarViewMvc.enableUpButtonAndListen(new ToolbarViewMvc.NavigateUpClickListener() {
            @Override
            public void onNavigateUpClick() {
                for (Listener listener : getListeners()) {
                    listener.onNavigateUpClick();
                }
            }
        });
        toolbar.addView(toolbarViewMvc.getRootView());
    }
    void setSwapBtn() {
        EditText fromEditText = findViewById(R.id.fromEditText);
        EditText toEditText = findViewById(R.id.toEditText);
        ImageButton swapBtn = findViewById(R.id.swapBtn);
        swapBtn.setOnClickListener(v -> {
            String temp = fromEditText.getText().toString();
            fromEditText.setText(toEditText.getText().toString());
            toEditText.setText(temp);
        });
    }

    void setChangeColorWhenFocus() {
        int[][] arr = {
                {R.id.adultEditText, R.id.adultImageView, R.id.adultLine, R.drawable.ic_people_selected, R.drawable.ic_people_unselected},
                {R.id.babyEditText, R.id.babyImageView, R.id.babyLine, R.drawable.ic_baby_selected, R.drawable.ic_baby_unselected},
                {R.id.petEditText, R.id.petImageView, R.id.petLine, R.drawable.ic_pet_selected, R.drawable.ic_pet_unselected},
                {R.id.luggageEditText, R.id.luggageImageView, R.id.luggageLine, R.drawable.ic_luggage_selected, R.drawable.ic_luggage_unselected}
        };
        for(int i = 0; i < 4; ++i) {
            EditText editText = findViewById(arr[i][0]);
            ImageView imageView = findViewById(arr[i][1]);
            View line = findViewById(arr[i][2]);
            int finalI = i;
            editText.setOnFocusChangeListener((v, hasFocus) -> {
                if (hasFocus) {
                    editText.setTextColor(Color.parseColor("#01635D"));
                    imageView.setImageResource(arr[finalI][3]);
                    line.setBackgroundColor(Color.parseColor("#01635D"));
                } else {
                    editText.setTextColor(Color.parseColor("#727272"));
                    imageView.setImageResource(arr[finalI][4]);
                    line.setBackgroundColor(Color.parseColor("#727272"));
                }
            });
        }
    }
    void setEconomy() {
        Button economyBtn = findViewById(R.id.economyBtn);
        Button businessBtn = findViewById(R.id.businessBtn);
        economyBtn.setOnClickListener(v -> {
            isEconomy = true;
            economyBtn.setTextColor(Color.parseColor("#FFFFFF"));
            economyBtn.setBackgroundColor(Color.parseColor("#089083"));
            businessBtn.setTextColor(Color.parseColor("#089083"));
            businessBtn.setBackgroundColor(Color.parseColor("#FFFFFF"));
        });
        businessBtn.setOnClickListener(v -> {
            isEconomy = false;
            businessBtn.setTextColor(Color.parseColor("#FFFFFF"));
            businessBtn.setBackgroundColor(Color.parseColor("#089083"));
            economyBtn.setTextColor(Color.parseColor("#089083"));
            economyBtn.setBackgroundColor(Color.parseColor("#FFFFFF"));
        });
    }


    @Override
    public void updateDate(int year, int month, int day) {
        if (idButton == R.id.departureEditText) {
            EditText departureEditText = findViewById(R.id.departureEditText);
            departureEditText.setText(getDateFormat(year, month, day));
        }
        if (idButton == R.id.returnEditText) {
            EditText returnEditText = findViewById(R.id.returnEditText);
            returnEditText.setText(getDateFormat(year, month, day));
        }
    }

    @Override
    public void updateStartingPoint(String startingPoint) {
        EditText fromEditText = findViewById(R.id.fromEditText);
        fromEditText.setText(startingPoint);
    }

    @Override
    public void updateDestination(String destination) {
        EditText toEditText = findViewById(R.id.toEditText);
        toEditText.setText(destination);
    }

    String getDateFormat(int year, int month, int day) {
        return getMonth(month) + getDay(day) + ", " + year;
    }

    String getDay(int day) {
        if (day < 10) return "0" + day;
        return day + "";
    }
    String getMonth(int month) {
        switch (month) {
            case 1:
                return "Jan";
            case 2:
                return "Feb";
            case 3:
                return "Mar";
            case 4:
                return "Apr";
            case 5:
                return "May";
            case 6:
                return "Jun";
            case 7:
                return "Jul";
            case 8:
                return "Aug";
            case 9:
                return "Sep";
                case 10:
                return "Oct";
            case 11:
                return "Nov";
            case 12:
                return "Dec";
            default:
                return "";
        }
    }
}
