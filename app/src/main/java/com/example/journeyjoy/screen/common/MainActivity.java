package com.example.journeyjoy.screen.common;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.window.OnBackInvokedDispatcher;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.journeyjoy.R;
import com.example.journeyjoy.screen.common.controllers.BackPressDispatcher;
import com.example.journeyjoy.screen.common.controllers.BackPressedListener;
import com.example.journeyjoy.screen.common.controllers.BaseActivity;
import com.example.journeyjoy.screen.common.fragmentframehelper.FragmentFrameWrapper;
import com.example.journeyjoy.screen.common.navbottom.NavBottomViewMvc;
import com.example.journeyjoy.screen.common.screensnavigator.ScreensNavigator;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends BaseActivity implements
        NavBottomViewMvc.Listener,
        BackPressDispatcher,
        FragmentFrameWrapper {
    private NavBottomViewMvc mViewMvc;
    private ScreensNavigator mScreensNavigator;

    private Set<BackPressedListener> mBackPressedListeners = new HashSet<>();
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
            mScreensNavigator.toHomeBooking();
        } else if (id == R.id.notificationLayout) {

        } else if (id == R.id.profileLayout) {
            mScreensNavigator.toAccount();
        }
    }

    @Override
    public void onBackPressed() {
        boolean isBackPressConsumedByAnyListener = false;
        for (BackPressedListener listener : mBackPressedListeners) {
            if (listener.onBackPressed()) {
                isBackPressConsumedByAnyListener = true;
            }
        }
        if (!isBackPressConsumedByAnyListener) {
            super.onBackPressed();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewMvc.registerListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mViewMvc.unregisterListener(this);
    }

    @Override
    public FrameLayout getFragmentFrame() {
        return mViewMvc.getFragmentFrame();
    }

    @Override
    public void registerListener(BackPressedListener listener) {
        mBackPressedListeners.add(listener);
    }

    @Override
    public void unregisterListener(BackPressedListener listener) {
        mBackPressedListeners.remove(listener);
    }

    public void setBottomBarVisible(boolean visible) {
        if (visible) {
            mViewMvc.showNavBottom();
        } else {
            mViewMvc.hideNavBottom();
        }
    }
}