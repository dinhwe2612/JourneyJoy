package com.example.journeyjoy.screen.home;

import android.view.View;

import com.example.journeyjoy.screen.common.views.ObservableViewMvc;

public interface HomeViewMvc extends ObservableViewMvc<HomeViewMvc.Listener> {
    public interface Listener {
        void onSearchClick(String keyword);
    }
}
