package com.example.journeyjoy.screen.splash;

import com.example.journeyjoy.screen.common.views.ObservableViewMvc;

public interface SplashViewMvc extends ObservableViewMvc<SplashViewMvc.Listener> {
    public interface Listener {
        void onSplashFinished();
    }
    public void startSplash();
}
