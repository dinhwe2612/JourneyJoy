package com.example.journeyjoy.screen.signup;

import com.example.journeyjoy.screen.common.views.ObservableViewMvc;

public interface SignInViewMvc extends ObservableViewMvc<SignInViewMvc.Listener> {
    interface Listener {
        void onSigninClicked();
        void onSignupClicked();
        void onNavigateUpClick();
    }
}
