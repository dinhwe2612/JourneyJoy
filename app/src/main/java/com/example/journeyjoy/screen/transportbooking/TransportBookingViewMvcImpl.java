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

    public TransportBookingViewMvcImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        setRootView(inflater.inflate(R.layout.layout_transportbooking, parent, false));
        toolbar = findViewById(R.id.toolbar);
        toolbarViewMvc = viewMvcFactory.getToolbarViewMvc(toolbar);
        initToolbar();
        setSwapBtn();
        setChangeColorWhenFocus();
        setEconomy();
        Button searchBtn = findViewById(R.id.searchBookingBtn);
        searchBtn.setOnClickListener(v -> {
            for (Listener listener : getListeners()) {
                listener.onSearchClick();
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


}
