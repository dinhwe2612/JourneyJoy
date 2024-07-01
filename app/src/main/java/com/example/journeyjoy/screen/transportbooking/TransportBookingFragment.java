package com.example.journeyjoy.screen.transportbooking;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.journeyjoy.screen.common.controllers.BaseFragment;

public class TransportBookingFragment extends BaseFragment {
    public static Fragment newInstance() {
        return new TransportBookingFragment();
    }

    TransportBookingViewMvc viewMvc;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewMvc = getCompositionRoot().getViewMvcFactory().getTransportBookingViewMvc(container);
        return viewMvc.getRootView();
    }
}
