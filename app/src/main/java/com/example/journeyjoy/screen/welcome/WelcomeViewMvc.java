package com.example.journeyjoy.screen.welcome;

import com.example.journeyjoy.screen.common.views.ObservableViewMvc;

public interface WelcomeViewMvc extends ObservableViewMvc<WelcomeViewMvc.Listener> {
    interface Listener {
        void onSignUpClicked();
        void onLoginClicked();
    }
}
