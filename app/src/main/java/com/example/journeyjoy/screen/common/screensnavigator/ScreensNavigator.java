package com.example.journeyjoy.screen.common.screensnavigator;

import android.util.Log;

import com.example.journeyjoy.screen.account.AccountFragment;
import com.example.journeyjoy.screen.common.fragmentframehelper.FragmentFrameHelper;
import com.example.journeyjoy.screen.home.HomeFragment;
import com.example.journeyjoy.screen.homebooking.HomeBookingFragment;
import com.example.journeyjoy.screen.personalinfo.PersonalInfoFragment;
import com.example.journeyjoy.screen.transportbooking.TransportBookingFragment;

public class ScreensNavigator {
    private FragmentFrameHelper mFragmentFrameHelper;

    public ScreensNavigator(FragmentFrameHelper fragmentFrameHelper) {
        mFragmentFrameHelper = fragmentFrameHelper;
    }
    public void toHome() {
        Log.d("ScreensNavigator", "toHome");
        mFragmentFrameHelper.replaceFragmentAndClearBackstack(HomeFragment.newInstance());
    }

    public void toHomeBooking() {
        Log.d("ScreensNavigator", "toHomeBooking");
        mFragmentFrameHelper.replaceFragmentAndClearBackstack(HomeBookingFragment.newInstance());
    }

    public void toNotifications() {

    }

    public void toAccount() {
        mFragmentFrameHelper.replaceFragmentAndClearBackstack(AccountFragment.newInstance());
    }

    public void toPersonalInfo() {
        mFragmentFrameHelper.replaceFragment(PersonalInfoFragment.newInstance());
    }

    public void toTransportBooking() {
        mFragmentFrameHelper.replaceFragment(TransportBookingFragment.newInstance());
    }

    public void navigateUp() {
        mFragmentFrameHelper.navigateUp();
    }
}
