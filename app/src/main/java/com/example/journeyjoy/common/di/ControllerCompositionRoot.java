package com.example.journeyjoy.common.di;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.journeyjoy.R;
import com.example.journeyjoy.screen.common.ViewMvcFactory;
import com.example.journeyjoy.screen.common.fragmentframehelper.FragmentFrameHelper;
import com.example.journeyjoy.screen.common.fragmentframehelper.FragmentFrameWrapper;
import com.example.journeyjoy.screen.common.navbottom.NavBottomViewMvc;
import com.example.journeyjoy.screen.common.screensnavigator.ScreensNavigator;
import com.example.journeyjoy.screen.home.HomeViewMvc;

public class ControllerCompositionRoot {
    private final ActivityCompositionRoot mActivityCompositionRoot;

    public ControllerCompositionRoot(ActivityCompositionRoot activityCompositionRoot) {
        mActivityCompositionRoot = activityCompositionRoot;
    }

    private FragmentActivity getActivity() {
        return mActivityCompositionRoot.getActivity();
    }

    private Context getContext() {
        return getActivity();
    }

    private FragmentManager getFragmentManager() {
        return getActivity().getSupportFragmentManager();
    }

    private LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(getContext());
    }

    public ViewMvcFactory getViewMvcFactory() {
        return new ViewMvcFactory(getLayoutInflater());
    }

    public ScreensNavigator getScreensNavigator() {
        return new ScreensNavigator(getFragmentFrameHelper());

    }

    private FragmentFrameHelper getFragmentFrameHelper() {
        return new FragmentFrameHelper(getActivity(), getFragmentFrameWrapper(), getFragmentManager());
    }

    private FragmentFrameWrapper getFragmentFrameWrapper() {
        return (FragmentFrameWrapper)getActivity();
    }
}
