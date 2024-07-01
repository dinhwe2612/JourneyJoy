package com.example.journeyjoy.screen.transportbooking;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.example.journeyjoy.R;
import com.example.journeyjoy.screen.common.ViewMvcFactory;
import com.example.journeyjoy.screen.common.toolbar.ToolbarViewMvc;
import com.example.journeyjoy.screen.common.views.BaseObservableViewMvc;

public class TransportBookingViewMvcImpl extends BaseObservableViewMvc<TransportBookingViewMvc.Listener> implements TransportBookingViewMvc {

    Toolbar toolbar;
    ToolbarViewMvc toolbarViewMvc;
    public TransportBookingViewMvcImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        setRootView(inflater.inflate(R.layout.layout_transportbooking, parent, false));
        toolbar.findViewById(R.id.toolbar);
        toolbarViewMvc = viewMvcFactory.getToolbarViewMvc(toolbar);
        toolbarViewMvc.setTitle("Transport Booking");
        toolbarViewMvc.enableUpButtonAndListen(new ToolbarViewMvc.NavigateUpClickListener() {
            @Override
            public void onNavigateUpClick() {
                for (Listener listener : getListeners()) {
                    listener.onNavigateUpClick();
                }
            }
        });
        toolbar.addView(toolbarViewMvc.getRootView());
    }

}
