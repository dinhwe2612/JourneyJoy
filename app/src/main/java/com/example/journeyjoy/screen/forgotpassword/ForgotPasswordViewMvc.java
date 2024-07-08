package com.example.journeyjoy.screen.forgotpassword;

import com.example.journeyjoy.screen.common.views.ObservableViewMvc;

public interface ForgotPasswordViewMvc extends ObservableViewMvc<ForgotPasswordViewMvc.Listener> {
    interface Listener {
        void onForgotPassword(String email);

        void onNavigateUp();
    }
}
