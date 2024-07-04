package com.example.journeyjoy.screen.selectseats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.journeyjoy.screen.common.controllers.BaseFragment;
import com.example.journeyjoy.screen.common.screensnavigator.ScreensNavigator;

public class SelectSeatsFragment extends BaseFragment implements
        SelectSeatsViewMvc.Listener {
    public static Fragment newInstance() {
        return new SelectSeatsFragment();
    }
    SelectSeatsViewMvc viewMvc;
    ScreensNavigator screensNavigator;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screensNavigator = getCompositionRoot().getScreensNavigator();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewMvc = getCompositionRoot().getViewMvcFactory().getSelectSeatsViewMvc(container);
        return viewMvc.getRootView();
    }


    @Override
    public void onNavigateUp() {
        screensNavigator.navigateUp();
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
