package com.example.journeyjoy.screen.signin;

import com.example.journeyjoy.screen.common.views.ObservableViewMvc;

public interface SignInViewMvc extends ObservableViewMvc<SignInViewMvc.Listener> {
    interface Listener {
        void onSigninClicked(String email, String password);
        void onSignupClicked();
        void onNavigateUpClick();

        void onSignUpClick();

        void onGoogleSignInClick();
        void onForgotPasswordClick();
    }
}
