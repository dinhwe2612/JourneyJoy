package com.example.journeyjoy.screen.common.controllers;

import androidx.appcompat.app.AppCompatActivity;

import com.example.journeyjoy.common.CustomApplication;
import com.example.journeyjoy.common.di.ActivityCompositionRoot;
import com.example.journeyjoy.common.di.ControllerCompositionRoot;

public class BaseActivity extends AppCompatActivity {
    private ActivityCompositionRoot mActivityCompositionRoot;

    private ControllerCompositionRoot mControllerCompositionRoot;

    public ActivityCompositionRoot getActivityCompositionRoot() {
        if (mActivityCompositionRoot == null) {
            mActivityCompositionRoot = new ActivityCompositionRoot(
                    ((CustomApplication)getApplication()).getCompositionRoot(),
                    this
            );
        }
        return mActivityCompositionRoot;
    }
    protected ControllerCompositionRoot getCompositionRoot() {
        if (mControllerCompositionRoot == null) {
            mControllerCompositionRoot = new ControllerCompositionRoot(getActivityCompositionRoot());
        }
        return mControllerCompositionRoot;
    }
}
