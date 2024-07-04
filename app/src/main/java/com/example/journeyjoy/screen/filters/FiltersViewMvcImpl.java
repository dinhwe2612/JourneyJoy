package com.example.journeyjoy.screen.filters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toolbar;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.journeyjoy.R;
import com.example.journeyjoy.screen.common.ViewMvcFactory;
import com.example.journeyjoy.screen.common.toolbar.ToolbarViewMvc;
import com.example.journeyjoy.screen.common.views.BaseObservableViewMvc;

import hearsilent.discreteslider.DiscreteSlider;

public class FiltersViewMvcImpl extends BaseObservableViewMvc<FiltersViewMvc.Listener> implements FiltersViewMvc {

    Toolbar toolbar;
    ToolbarViewMvc toolbarViewMvc;

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
        toolbar.addView(toolbarViewMvc.getRootView());
        RecyclerView timeSelector1 = findViewById(R.id.selectTime1);
        timeSelector1.setAdapter(new TimeSelectorViewAdapter());
        timeSelector1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        RecyclerView timeSelector2 = findViewById(R.id.selectTime2);
        timeSelector2.setAdapter(new TimeSelectorViewAdapter());
        timeSelector2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        DiscreteSlider seekBar = findViewById(R.id.seekBar);
        seekBar.setOnValueChangedListener(new DiscreteSlider.OnValueChangedListener(){
            @Override
            public void onValueChanged(int minProgress, int maxProgress, boolean fromUser) {
                super.onValueChanged(minProgress, maxProgress, fromUser);
                EditText minEditText = findViewById(R.id.minEditText);
                EditText maxEditText = findViewById(R.id.maxEditText);
                minEditText.setText("$" + String.valueOf(minProgress));
                maxEditText.setText("$" + String.valueOf(maxProgress));
            }
        });
    }
}
