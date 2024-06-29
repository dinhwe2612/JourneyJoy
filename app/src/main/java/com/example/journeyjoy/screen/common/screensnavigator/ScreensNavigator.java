package com.example.journeyjoy.screen.common.screensnavigator;

import com.example.journeyjoy.screen.common.fragmentframehelper.FragmentFrameHelper;
import com.example.journeyjoy.screen.home.HomeFragment;

public class ScreensNavigator {
    private FragmentFrameHelper mFragmentFrameHelper;

    public ScreensNavigator(FragmentFrameHelper fragmentFrameHelper) {
        mFragmentFrameHelper = fragmentFrameHelper;
    }
    public void toHome() {
        mFragmentFrameHelper.replaceFragment(HomeFragment.newInstance());
    }

    public void toBooking() {

    }

    public void toNotifications() {

    }

    void toProfile() {

    }
}
