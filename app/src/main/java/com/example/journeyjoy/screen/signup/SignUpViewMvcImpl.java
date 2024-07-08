package com.example.journeyjoy.screen.signup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toolbar;

import com.example.journeyjoy.R;
import com.example.journeyjoy.screen.common.ViewMvcFactory;
import com.example.journeyjoy.screen.common.toolbar.ToolbarViewMvc;
import com.example.journeyjoy.screen.common.views.BaseObservableViewMvc;

public class SignUpViewMvcImpl extends BaseObservableViewMvc<SignUpViewMvc.Listener> implements
        SignUpViewMvc {
    Toolbar toolbar;
    ToolbarViewMvc toolbarViewMvc;
    EditText emailSignin;
    EditText passwordSignin;
    EditText confirmPasswordSignin;
    Button signup;
    public SignUpViewMvcImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        setRootView(inflater.inflate(R.layout.layout_signup, parent, false));
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
        emailSignin = findViewById(R.id.emailSignup);
        passwordSignin = findViewById(R.id.passSignup);
        confirmPasswordSignin = findViewById(R.id.confirmPassSignup);
        signup = findViewById(R.id.SignInBtn3);
        signup.setOnClickListener(v -> {
            String email = emailSignin.getText().toString();
            String password = passwordSignin.getText().toString();
            String confirmPassword = confirmPasswordSignin.getText().toString();
            for (Listener listener : getListeners()) {
                listener.onSignUpClick(email, password, confirmPassword);
            }
        });
    }
}
