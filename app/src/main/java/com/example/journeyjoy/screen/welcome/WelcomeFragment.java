package com.example.journeyjoy.screen.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.journeyjoy.screen.common.controllers.BaseFragment;
import com.example.journeyjoy.screen.common.screensnavigator.ScreensNavigator;

public class WelcomeFragment extends BaseFragment implements WelcomeViewMvc.Listener {

    public static Fragment newInstance() {
        return new WelcomeFragment();
    }
    private WelcomeViewMvc viewMvc;
    ScreensNavigator screensNavigator;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screensNavigator = getCompositionRoot().getScreensNavigator();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewMvc = getCompositionRoot().getViewMvcFactory().getWelcomeViewMvc(container);
        return viewMvc.getRootView();
    }

    @Override
    public void onSignUpClicked() {
        screensNavigator.toSignIn();
    }

    @Override
    public void onLoginClicked() {
        screensNavigator.toSignIn();
    }

    @Override
    public void onStart() {
        super.onStart();
        viewMvc.registerListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        viewMvc.unregisterListener(this);
    }
}
