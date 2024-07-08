package com.example.journeyjoy.screen.forgotpassword;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

import com.example.journeyjoy.R;
import com.example.journeyjoy.screen.common.ViewMvcFactory;
import com.example.journeyjoy.screen.common.toolbar.ToolbarViewMvc;
import com.example.journeyjoy.screen.common.views.BaseObservableViewMvc;

public class ForgotPasswordViewMvcImpl extends BaseObservableViewMvc<ForgotPasswordViewMvc.Listener>
        implements ForgotPasswordViewMvc{
    ToolbarViewMvc toolbarViewMvc;
    Toolbar toolbar;
    Button confirmForgot;
    EditText emailForgot;
    public ForgotPasswordViewMvcImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        setRootView(inflater.inflate(R.layout.layout_forgotpassword, parent, false));
        toolbar = findViewById(R.id.toolbar);
        toolbarViewMvc = viewMvcFactory.getToolbarViewMvc(parent);
        toolbarViewMvc.enableUpButtonAndListen(new ToolbarViewMvc.NavigateUpClickListener() {
            @Override
            public void onNavigateUpClick() {
                for (Listener listener : getListeners()) {
                    listener.onNavigateUp();
                }
            }
        });
        toolbar.addView(toolbarViewMvc.getRootView());
        confirmForgot = findViewById(R.id.confirmForgot);
        emailForgot = findViewById(R.id.emailForgot);
        confirmForgot.setOnClickListener(v -> {
            for (Listener listener : getListeners()) {
                listener.onForgotPassword(emailForgot.getText().toString());
            }
        });
    }
}
