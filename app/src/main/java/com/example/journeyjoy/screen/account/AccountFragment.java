package com.example.journeyjoy.screen.account;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.journeyjoy.screen.common.controllers.BaseFragment;
import com.example.journeyjoy.screen.common.dialogs.DialogsManager;
import com.example.journeyjoy.screen.common.screensnavigator.ScreensNavigator;
import com.example.journeyjoy.utils.SharedPreferencesUtils;
import com.google.android.material.tabs.TabItem;

public class AccountFragment extends BaseFragment implements AccountViewMvc.Listener{

    public static AccountFragment newInstance() {
        return new AccountFragment();
    }

    ScreensNavigator mScreensNavigator;
    AccountViewMvc viewMvc;
    DialogsManager dialogsManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScreensNavigator = getCompositionRoot().getScreensNavigator();
        dialogsManager = getCompositionRoot().getDialogsManager();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewMvc = getCompositionRoot().getViewMvcFactory().getAccountViewMvc(container);
        String firstname = SharedPreferencesUtils.getString(requireContext(), "firstname", null);
        String lastname = SharedPreferencesUtils.getString(requireContext(), "lastname", null);
        viewMvc.loadPersonalInfo(firstname, lastname);
        Bitmap avatar = SharedPreferencesUtils.getImage(requireContext(), "avatar");
        if (avatar != null) {
            viewMvc.loadAvatar(avatar);
        }
        return viewMvc.getRootView();
    }

    @Override
    public void onPersonalInfoClicked() {
        mScreensNavigator.toPersonalInfo();
    }

    @Override
    public void onAnotherClick() {
        dialogsManager.showFunctionBeingDevelopedDialog();
        Log.d("AccountFragment", "onAnotherClick: ");
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
