package com.example.journeyjoy.screen.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.journeyjoy.screen.account.AccountViewMvc;
import com.example.journeyjoy.screen.account.AccountViewMvcImpl;
import com.example.journeyjoy.screen.boardingpass.BoardingPassMvc;
import com.example.journeyjoy.screen.boardingpass.BoardingPassMvcImpl;
import com.example.journeyjoy.screen.common.navbottom.NavBottomViewMvc;
import com.example.journeyjoy.screen.common.navbottom.NavBottomViewMvcImpl;
import com.example.journeyjoy.screen.common.toolbar.ToolbarViewMvc;
import com.example.journeyjoy.screen.filters.FiltersViewMvc;
import com.example.journeyjoy.screen.filters.FiltersViewMvcImpl;
import com.example.journeyjoy.screen.flights.FlightsViewMvc;
import com.example.journeyjoy.screen.flights.FlightsViewMvcImpl;
import com.example.journeyjoy.screen.forgotpassword.ForgotPasswordViewMvc;
import com.example.journeyjoy.screen.forgotpassword.ForgotPasswordViewMvcImpl;
import com.example.journeyjoy.screen.home.HomeViewMvc;
import com.example.journeyjoy.screen.home.HomeViewMvcImpl;
import com.example.journeyjoy.screen.homebooking.HomeBookingViewMvc;
import com.example.journeyjoy.screen.homebooking.HomeBookingViewMvcImpl;
import com.example.journeyjoy.screen.personalinfo.PersonalInfoViewMvc;
import com.example.journeyjoy.screen.personalinfo.PersonalInfoViewMvcImpl;
import com.example.journeyjoy.screen.selectseats.SelectSeatsViewMvc;
import com.example.journeyjoy.screen.selectseats.SelectSeatsViewMvcImpl;
import com.example.journeyjoy.screen.signin.SignInViewMvc;
import com.example.journeyjoy.screen.signin.SignInViewMvcImpl;
import com.example.journeyjoy.screen.signup.SignUpViewMvc;
import com.example.journeyjoy.screen.signup.SignUpViewMvcImpl;
import com.example.journeyjoy.screen.transportbooking.TransportBookingViewMvc;
import com.example.journeyjoy.screen.transportbooking.TransportBookingViewMvcImpl;
import com.example.journeyjoy.screen.welcome.WelcomeViewMvc;
import com.example.journeyjoy.screen.welcome.WelcomeViewMvcImpl;

public class ViewMvcFactory {
    private final LayoutInflater mLayoutInflater;

    public ViewMvcFactory(LayoutInflater layoutInflater) {
        mLayoutInflater = layoutInflater;
    }

    public NavBottomViewMvc getNavBottomViewMvc(@Nullable ViewGroup parent) {
        return new NavBottomViewMvcImpl(mLayoutInflater, parent);
    }

    public HomeViewMvc getHomeViewMvc(@Nullable ViewGroup parent) {
        return new HomeViewMvcImpl(mLayoutInflater, parent, this);
    }

    public ToolbarViewMvc getToolbarViewMvc(@Nullable ViewGroup parent) {
        return new ToolbarViewMvc(mLayoutInflater, parent);
    }

    public HomeBookingViewMvc getHomeBookingViewMvc(@Nullable ViewGroup parent) {
        return new HomeBookingViewMvcImpl(mLayoutInflater, parent, this);
    }

    public AccountViewMvc getAccountViewMvc(@Nullable ViewGroup parent) {
        return new AccountViewMvcImpl(mLayoutInflater, parent, this);
    }

    public PersonalInfoViewMvc getPersonalInfoViewMvc(@Nullable ViewGroup parent) {
        return new PersonalInfoViewMvcImpl(mLayoutInflater, parent, this);
    }

    public TransportBookingViewMvc getTransportBookingViewMvc(@Nullable ViewGroup container) {
        return new TransportBookingViewMvcImpl(mLayoutInflater, container, this);
    }

    public SignInViewMvc getSignInViewMvc(@Nullable ViewGroup parent) {
        return new SignInViewMvcImpl(mLayoutInflater, parent, this);
    }

    public WelcomeViewMvc getWelcomeViewMvc(@Nullable ViewGroup parent) {
        return new WelcomeViewMvcImpl(mLayoutInflater, parent, this);
    }

    public FlightsViewMvc getFlightsViewMvc(@Nullable ViewGroup parent) {
        return new FlightsViewMvcImpl(mLayoutInflater, parent, this);
    }

    public FiltersViewMvc getFiltersViewMvc(@Nullable ViewGroup parent) {
        return new FiltersViewMvcImpl(mLayoutInflater, parent, this);
    }

    public SelectSeatsViewMvc getSelectSeatsViewMvc(@Nullable ViewGroup parent) {
        return new SelectSeatsViewMvcImpl(mLayoutInflater, parent, this);
    }

    public BoardingPassMvc getBoardingPassMvc(@Nullable ViewGroup parent) {
        return new BoardingPassMvcImpl(mLayoutInflater, parent, this);
    }

    public SignUpViewMvc getSignUpViewMvc(@Nullable ViewGroup parent) {
        return new SignUpViewMvcImpl(mLayoutInflater, parent, this);
    }

    public ForgotPasswordViewMvc getForgotPasswordViewMvc(@Nullable ViewGroup parent) {
        return new ForgotPasswordViewMvcImpl(mLayoutInflater, parent, this);
    }
}
