package com.example.journeyjoy.screen.common;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.journeyjoy.R;
import com.example.journeyjoy.screen.common.controllers.BaseActivity;
import com.example.journeyjoy.screen.common.fragmentframehelper.FragmentFrameWrapper;
import com.example.journeyjoy.screen.common.navbottom.NavBottomViewMvc;
import com.example.journeyjoy.screen.common.screensnavigator.ScreensNavigator;

public class MainActivity extends BaseActivity implements
        NavBottomViewMvc.Listener,
        FragmentFrameWrapper {
    private NavBottomViewMvc mViewMvc;
    private ScreensNavigator mScreensNavigator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewMvc = getCompositionRoot().getViewMvcFactory().getNavBottomViewMvc(null);
        mScreensNavigator = getCompositionRoot().getScreensNavigator();
        setContentView(mViewMvc.getRootView());
        if (savedInstanceState == null) {
            mScreensNavigator.toHome();
        }
    }

    @Override
    public void onNavBottomClick(int id) {
        if (id == R.id.homeLayout) {
            mScreensNavigator.toHome();
        } else if (id == R.id.bookingLayout) {

        } else if (id == R.id.notificationLayout) {

        } else if (id == R.id.profileLayout) {

        }
    }

    @Override
    public FrameLayout getFragmentFrame() {
        return mViewMvc.getFragmentFrame();
    }
}