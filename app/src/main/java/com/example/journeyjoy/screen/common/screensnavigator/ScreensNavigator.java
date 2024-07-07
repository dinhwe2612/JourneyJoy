package com.example.journeyjoy.screen.common.screensnavigator;

import android.util.Log;

import com.example.journeyjoy.model.ticket.Ticket;
import com.example.journeyjoy.screen.account.AccountFragment;
import com.example.journeyjoy.screen.boardingpass.BoardingPassFragment;
import com.example.journeyjoy.screen.common.fragmentframehelper.FragmentFrameHelper;
import com.example.journeyjoy.screen.filters.FiltersFragment;
import com.example.journeyjoy.screen.flights.FlightsFragment;
import com.example.journeyjoy.screen.home.HomeFragment;
import com.example.journeyjoy.screen.homebooking.HomeBookingFragment;
import com.example.journeyjoy.screen.personalinfo.PersonalInfoFragment;
import com.example.journeyjoy.screen.selectseats.SelectSeatsFragment;
import com.example.journeyjoy.screen.signup.SignInFragment;
import com.example.journeyjoy.screen.transportbooking.TransportBookingFragment;
import com.example.journeyjoy.screen.welcome.WelcomeFragment;

public class ScreensNavigator {
    private FragmentFrameHelper mFragmentFrameHelper;

    public ScreensNavigator(FragmentFrameHelper fragmentFrameHelper) {
        mFragmentFrameHelper = fragmentFrameHelper;
    }
    public void toHome() {
        Log.d("ScreensNavigator", "toHome");
        mFragmentFrameHelper.replaceFragment(HomeFragment.newInstance());
    }

    public void toHomeBooking() {
        Log.d("ScreensNavigator", "toHomeBooking");
        mFragmentFrameHelper.replaceFragment(HomeBookingFragment.newInstance());
    }

    public void toNotifications() {

    }

    public void toAccount() {
        mFragmentFrameHelper.replaceFragment(AccountFragment.newInstance());
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

    public void toWelcome() {
        mFragmentFrameHelper.replaceFragment(WelcomeFragment.newInstance());
    }

    public void toSignIn() {
        mFragmentFrameHelper.replaceFragment(SignInFragment.newInstance());
    }

    public void toFlights() {
        mFragmentFrameHelper.replaceFragment(FlightsFragment.newInstance());
    }

    public void toFilters() {
        mFragmentFrameHelper.replaceFragment(FiltersFragment.newInstance());
    }

    public void toSelectSeats(String flightNumber) {
        mFragmentFrameHelper.replaceFragmentDontAddToBackstack(SelectSeatsFragment.newInstance(flightNumber));
    }

    public void toBoardingPass(String ticketNumber) {
        mFragmentFrameHelper.replaceFragmentDontAddToBackstack(BoardingPassFragment.newInstance(ticketNumber));
    }
}
