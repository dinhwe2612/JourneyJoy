package com.example.journeyjoy.screen.common.navbottom;

import android.widget.FrameLayout;

import com.example.journeyjoy.screen.common.views.ObservableViewMvc;

public interface NavBottomViewMvc extends ObservableViewMvc<NavBottomViewMvc.Listener> {
    interface Listener {
        void onNavBottomClick(int id);
    }
    FrameLayout getFragmentFrame();
}
