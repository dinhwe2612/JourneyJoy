package com.example.journeyjoy.screen.signup;

import com.example.journeyjoy.screen.common.views.ObservableViewMvc;
import com.example.journeyjoy.screen.signin.SignInViewMvc;

public interface SignUpViewMvc extends ObservableViewMvc<SignUpViewMvc.Listener> {
    interface Listener {
        void onSignUpClick(String email, String password, String confirmPassword);
        void onNavigateUp();
    }
}
