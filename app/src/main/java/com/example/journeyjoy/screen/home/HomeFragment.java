package com.example.journeyjoy.screen.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.journeyjoy.screen.common.controllers.BaseFragment;

public class HomeFragment extends BaseFragment implements
        HomeViewMvc.Listener{
    public static Fragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        HomeViewMvc viewMvc = getCompositionRoot().getViewMvcFactory().getHomeViewMvc(container);
        Log.d("HomeFragment", "onCreateView:");
        return viewMvc.getRootView();
    }

    @Override
    public void onSearchClick(String keyword) {

    }
}
