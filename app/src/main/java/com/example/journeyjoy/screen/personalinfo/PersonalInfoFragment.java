package com.example.journeyjoy.screen.personalinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.journeyjoy.screen.common.controllers.BaseFragment;
import com.example.journeyjoy.screen.common.screensnavigator.ScreensNavigator;

public class PersonalInfoFragment extends BaseFragment implements
    PersonalInfoViewMvc.Listener{

    ScreensNavigator mScreensNavigator;
    PersonalInfoViewMvc viewMvc;
    public static Fragment newInstance() {
        return new PersonalInfoFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScreensNavigator = getCompositionRoot().getScreensNavigator();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewMvc = getCompositionRoot().getViewMvcFactory().getPersonalInfoViewMvc(container);
        return viewMvc.getRootView();
    }

    @Override
    public void onSaveChanges() {

    }

    @Override
    public void onNavigateUpClick() {
        mScreensNavigator.navigateUp();
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
