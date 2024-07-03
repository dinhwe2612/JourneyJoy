package com.example.journeyjoy.screen.welcome;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.journeyjoy.R;
import com.example.journeyjoy.screen.common.ViewMvcFactory;
import com.example.journeyjoy.screen.common.views.BaseObservableViewMvc;

public class WelcomeViewMvcImpl extends BaseObservableViewMvc<WelcomeViewMvc.Listener> implements WelcomeViewMvc{
    public WelcomeViewMvcImpl(LayoutInflater inflater, ViewGroup container, ViewMvcFactory viewMvcFactory) {
        setRootView(inflater.inflate(R.layout.layout_welcome, container, false));
        Button signUpBtn = findViewById(R.id.SignUpBtn);
        signUpBtn.setOnClickListener(v -> {
            for (Listener listener : getListeners()) {
                listener.onSignUpClicked();
            }
        });
        Button loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(v -> {
            for (Listener listener : getListeners()) {
                listener.onLoginClicked();
            }
        });
    }
}
