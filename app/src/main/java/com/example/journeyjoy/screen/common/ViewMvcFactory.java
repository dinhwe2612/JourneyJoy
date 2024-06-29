package com.example.journeyjoy.screen.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toolbar;

import androidx.annotation.Nullable;

import com.example.journeyjoy.screen.common.navbottom.NavBottomViewMvc;
import com.example.journeyjoy.screen.common.navbottom.NavBottomViewMvcImpl;
import com.example.journeyjoy.screen.common.toolbar.ToolbarViewMvc;
import com.example.journeyjoy.screen.home.HomeViewMvc;
import com.example.journeyjoy.screen.home.HomeViewMvcImpl;

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
}
