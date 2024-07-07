package com.example.journeyjoy.screen.filters;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toolbar;

import androidx.core.util.Pair;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeyjoy.R;
import com.example.journeyjoy.model.flight.FlightFilters;
import com.example.journeyjoy.screen.common.ViewMvcFactory;
import com.example.journeyjoy.screen.common.toolbar.ToolbarViewMvc;
import com.example.journeyjoy.screen.common.views.BaseObservableViewMvc;
import com.example.journeyjoy.utils.FormatUtils;

import hearsilent.discreteslider.DiscreteSlider;

public class FiltersViewMvcImpl extends BaseObservableViewMvc<FiltersViewMvc.Listener> implements FiltersViewMvc {

    Toolbar toolbar;
    ToolbarViewMvc toolbarViewMvc;
    DiscreteSlider seekBar;
    EditText minEditText;
    EditText maxEditText;
    RecyclerView timeSelector1;
    RecyclerView timeSelector2;

    TimeSelectorViewAdapter timeSelectorViewAdapter1;
    TimeSelectorViewAdapter timeSelectorViewAdapter2;

    public FiltersViewMvcImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        setRootView(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_filters, parent, false));
        toolbar = findViewById(R.id.toolbar);
        toolbarViewMvc = viewMvcFactory.getToolbarViewMvc(parent);
        toolbarViewMvc.setTitle("Filters");
        toolbarViewMvc.enableUpButtonAndListen(new ToolbarViewMvc.NavigateUpClickListener() {
            @Override
            public void onNavigateUpClick() {
                for (Listener listener : getListeners()) {
                    listener.onNavigateUp();
                }
            }
        });
        minEditText = findViewById(R.id.minEditText);
        maxEditText = findViewById(R.id.maxEditText);
        toolbar.addView(toolbarViewMvc.getRootView());
        timeSelector1 = findViewById(R.id.selectTime1);
        timeSelectorViewAdapter1 = new TimeSelectorViewAdapter();
        timeSelector1.setAdapter(timeSelectorViewAdapter1);
        timeSelector1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        timeSelector2 = findViewById(R.id.selectTime2);
        timeSelectorViewAdapter2 = new TimeSelectorViewAdapter();
        timeSelector2.setAdapter(timeSelectorViewAdapter2);
        timeSelector2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnValueChangedListener(new DiscreteSlider.OnValueChangedListener(){
            @Override
            public void onValueChanged(int minProgress, int maxProgress, boolean fromUser) {
                super.onValueChanged(minProgress, maxProgress, fromUser);
                minEditText.setText(String.valueOf(minProgress));
                maxEditText.setText(String.valueOf(maxProgress));
            }
        });

        minEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()) {
                    try {
                        int minProgress = Integer.parseInt(s.toString());
                        if (minProgress < 1) {
                            minEditText.setText("1");
                            return;
                        }
                        if (minProgress > seekBar.getMaxProgress()) {
                            minEditText.setText(String.valueOf(seekBar.getMaxProgress()));
                            return;
                        }
                        int cursorPosition = minEditText.getSelectionStart();
                        seekBar.setMinProgress(minProgress - 1);
                        minEditText.setSelection(Math.min(cursorPosition, s.length()));
                    } catch (NumberFormatException e) {
                        Log.e("minEditText", "Invalid number format");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        maxEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()) {
                    try {
                        int maxProgress = Integer.parseInt(s.toString());
                        if (maxProgress > 500) {
                            maxEditText.setText("500");
                            return;
                        }
                        if (maxProgress < seekBar.getMinProgress()) {
                            maxEditText.setText(String.valueOf(seekBar.getMinProgress()));
                            return;
                        }
                        int cursorPosition = maxEditText.getSelectionStart();
                        seekBar.setMaxProgress(maxProgress - 1);
                        maxEditText.setSelection(Math.min(cursorPosition, s.length()));
                    } catch (NumberFormatException e) {
                        Log.e("maxEditText", "Invalid number format");
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        Button resetBtn = findViewById(R.id.resetBtn);
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFilters();
            }
        });
        Button doneBtn = findViewById(R.id.doneBtn);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Listener listener : getListeners()) {
                    listener.onDoneClick(getFilters());
                }
            }
        });
    }

    FlightFilters getFilters() {
        Pair<String, String> timeRange1 = FormatUtils.getTimeRange(timeSelectorViewAdapter1.getSelectedPosition());
        Pair<String, String> timeRange2 = FormatUtils.getTimeRange(timeSelectorViewAdapter2.getSelectedPosition());
        String minDeparture = timeRange1.first, maxDeparture = timeRange1.second;
        String minArrival = timeRange2.first, maxArrival = timeRange2.second;
        int minPrice = seekBar.getMinProgress(), maxPrice = seekBar.getMaxProgress();
        FlightFilters.SortBy sortBy = null;
        int selectedId = ((RadioGroup) findViewById(R.id.radioGroup)).getCheckedRadioButtonId();
        if (selectedId == R.id.radioButtonArrival) {
            sortBy = FlightFilters.SortBy.ARRIVAL;
        } else if (selectedId == R.id.radioButtonDeparture) {
            sortBy = FlightFilters.SortBy.DEPARTURE;
        } else if (selectedId == R.id.radioButtonPrice) {
            sortBy = FlightFilters.SortBy.Price;
        } else if (selectedId == R.id.radioButtonFare) {
            sortBy = FlightFilters.SortBy.LowestFare;
        } else if (selectedId == R.id.radioButtonDuration) {
            sortBy = FlightFilters.SortBy.Duration;
        }

        FlightFilters filters = new FlightFilters(minDeparture, maxDeparture, minArrival, maxArrival, minPrice, maxPrice, sortBy);
        return filters;
    }

    public void resetFilters() {
        seekBar.setMinProgress(0);
        seekBar.setMaxProgress(500);
        minEditText.setText("$0");
        maxEditText.setText("$500");
        timeSelector1.scrollToPosition(0);
        timeSelector2.scrollToPosition(0);
        timeSelectorViewAdapter1.setSelectedPosition(0);
        timeSelectorViewAdapter2.setSelectedPosition(0);
    }
}
