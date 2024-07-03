package com.example.journeyjoy.screen.common;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import com.example.journeyjoy.R;
import com.example.journeyjoy.screen.common.controllers.BaseActivity;
import com.example.journeyjoy.screen.common.fragmentframehelper.FragmentFrameWrapper;
import com.example.journeyjoy.screen.common.screensnavigator.ScreensNavigator;
import com.example.journeyjoy.screen.welcome.WelcomeViewMvc;

public class WelcomeActivity extends BaseActivity implements FragmentFrameWrapper {

    ScreensNavigator screensNavigator;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_frame);
        screensNavigator = getCompositionRoot().getScreensNavigator();
        if (savedInstanceState == null) {
            screensNavigator.toWelcome();
        }
    }

    @Override
    public FrameLayout getFragmentFrame() {
        return findViewById(R.id.FrameContent);
    }

}
