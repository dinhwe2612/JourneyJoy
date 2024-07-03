package com.example.journeyjoy.screen.common.controllers;

import androidx.fragment.app.Fragment;

import com.example.journeyjoy.common.di.ControllerCompositionRoot;
import com.example.journeyjoy.screen.common.MainActivity;

public class BaseFragment extends Fragment {
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
