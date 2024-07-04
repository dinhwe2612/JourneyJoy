package com.example.journeyjoy.screen.filters;

import com.example.journeyjoy.screen.common.views.BaseObservableViewMvc;
import com.example.journeyjoy.screen.common.views.ObservableViewMvc;

public interface FiltersViewMvc extends ObservableViewMvc<FiltersViewMvc.Listener> {
    interface Listener {
        void onApplyClicked();
        void onNavigateUp();
    }
}
