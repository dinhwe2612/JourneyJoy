package com.example.journeyjoy.screen.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.journeyjoy.screen.account.AccountViewMvc;
import com.example.journeyjoy.screen.account.AccountViewMvcImpl;
import com.example.journeyjoy.screen.common.navbottom.NavBottomViewMvc;
import com.example.journeyjoy.screen.common.navbottom.NavBottomViewMvcImpl;
import com.example.journeyjoy.screen.common.toolbar.ToolbarViewMvc;
import com.example.journeyjoy.screen.home.HomeViewMvc;
import com.example.journeyjoy.screen.home.HomeViewMvcImpl;
import com.example.journeyjoy.screen.homebooking.HomeBookingViewMvc;
import com.example.journeyjoy.screen.homebooking.HomeBookingViewMvcImpl;
import com.example.journeyjoy.screen.personalinfo.PersonalInfoViewMvc;
import com.example.journeyjoy.screen.personalinfo.PersonalInfoViewMvcImpl;
import com.example.journeyjoy.screen.transportbooking.TransportBookingViewMvc;
import com.example.journeyjoy.screen.transportbooking.TransportBookingViewMvcImpl;

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
}
