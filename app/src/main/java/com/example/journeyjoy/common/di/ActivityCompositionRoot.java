package com.example.journeyjoy.common.di;

import static java.security.AccessController.getContext;

import androidx.fragment.app.FragmentActivity;

import com.example.journeyjoy.model.city.City;
import com.example.journeyjoy.screen.common.dialogs.DialogsEventBus;
import com.example.journeyjoy.screen.common.dialogs.DialogsManager;

import java.util.ArrayList;

public class ActivityCompositionRoot {
    private final CompositionRoot mCompositionRoot;
    private final FragmentActivity mActivity;


    public ActivityCompositionRoot(CompositionRoot compositionRoot, FragmentActivity activity) {
        mCompositionRoot = compositionRoot;
        mActivity = activity;
    }

    public FragmentActivity getActivity() {
        return mActivity;
    }

    public DialogsEventBus getDialogsEventBus() {
        return mCompositionRoot.getDialogsEventBus();
    }

    public ArrayList<String> getNameOfCities() {
        return mCompositionRoot.getNameOfCities();
    }
}
