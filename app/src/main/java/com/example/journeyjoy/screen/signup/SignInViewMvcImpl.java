package com.example.journeyjoy.screen.signup;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toolbar;

import com.example.journeyjoy.R;
import com.example.journeyjoy.screen.common.ViewMvcFactory;
import com.example.journeyjoy.screen.common.toolbar.ToolbarViewMvc;
import com.example.journeyjoy.screen.common.views.BaseObservableViewMvc;

public class SignInViewMvcImpl extends BaseObservableViewMvc<SignInViewMvc.Listener> implements SignInViewMvc {
    Toolbar toolbar;
    ToolbarViewMvc toolbarViewMvc;
    public SignInViewMvcImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        setRootView(inflater.inflate(R.layout.layout_signin, parent, false));
        toolbar = findViewById(R.id.toolbar);
        toolbarViewMvc = viewMvcFactory.getToolbarViewMvc(parent);
        toolbarViewMvc.enableUpButtonAndListen(new ToolbarViewMvc.NavigateUpClickListener() {
            @Override
            public void onNavigateUpClick() {
                for (Listener listener : getListeners()) {
                    listener.onNavigateUpClick();
                }
            }
        });
        toolbar.addView(toolbarViewMvc.getRootView());
        Button signInBtn = (Button) findViewById(R.id.SignInBtn2);
        Log.d("SignInViewMvcImpl", "onCreate: ");
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SignInViewMvcImpl", "onClick: ");
                for (Listener listener : getListeners()) {
                    listener.onSigninClicked();
                }
            }
        });

    }
}
