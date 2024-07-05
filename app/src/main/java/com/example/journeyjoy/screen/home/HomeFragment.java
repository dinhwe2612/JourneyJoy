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
import com.example.journeyjoy.screen.common.dialogs.DialogsEventBus;
import com.example.journeyjoy.screen.common.dialogs.DialogsManager;
import com.example.journeyjoy.screen.common.dialogs.infodialog.InfoDialog;
import com.example.journeyjoy.screen.common.screensnavigator.ScreensNavigator;

public class HomeFragment extends BaseFragment implements
        HomeViewMvc.Listener{
    public static Fragment newInstance() {
        return new HomeFragment();
    }

    ScreensNavigator screensNavigator;
    HomeViewMvc viewMvc;

    DialogsManager dialogsManager;
    DialogsEventBus dialogsEventBus;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screensNavigator = getCompositionRoot().getScreensNavigator();
        dialogsManager = getCompositionRoot().getDialogsManager();
        dialogsEventBus = getCompositionRoot().getDialogsEventBus();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewMvc = getCompositionRoot().getViewMvcFactory().getHomeViewMvc(container);
        return viewMvc.getRootView();
    }

    @Override
    public void onSearchClick(String keyword) {
        dialogsManager.showSearchDialog(keyword);
    }

    @Override
    public void onStart() {
        super.onStart();
        viewMvc.registerListener(this);
//        dialogsEventBus.registerListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        viewMvc.unregisterListener(this);
//        dialogsEventBus.unregisterListener(this);
    }

    @Override
    public void onTransportClick() {
        screensNavigator.toTransportBooking();
    }

}
