package com.example.journeyjoy.screen.common.dialogs;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import com.example.journeyjoy.common.di.ControllerCompositionRoot;
import com.example.journeyjoy.screen.common.MainActivity;
import com.example.journeyjoy.screen.common.controllers.BaseActivity;

public class BaseDialog extends DialogFragment {
    private ControllerCompositionRoot mControllerCompositionRoot;
    protected ControllerCompositionRoot getCompositionRoot() {
        if (mControllerCompositionRoot == null) {
            mControllerCompositionRoot = new ControllerCompositionRoot(
                    ((BaseActivity) requireActivity()).getActivityCompositionRoot()
            );
        }
        return mControllerCompositionRoot;
    }
}
