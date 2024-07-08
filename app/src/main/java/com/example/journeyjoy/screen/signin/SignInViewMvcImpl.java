package com.example.journeyjoy.screen.signin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.journeyjoy.R;
import com.example.journeyjoy.screen.common.ViewMvcFactory;
import com.example.journeyjoy.screen.common.toolbar.ToolbarViewMvc;
import com.example.journeyjoy.screen.common.views.BaseObservableViewMvc;

public class SignInViewMvcImpl extends BaseObservableViewMvc<SignInViewMvc.Listener> implements SignInViewMvc {
    Toolbar toolbar;
    ToolbarViewMvc toolbarViewMvc;
    EditText emailEditText;
    EditText passEditText;
    TextView signUpSignIn;
    ImageButton googleSignInBtn;
    TextView forgotPassword;

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
        emailEditText = findViewById(R.id.EmailEditText);
        passEditText = findViewById(R.id.passEditText);
        Button signInBtn = (Button) findViewById(R.id.SignInBtn2);
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = emailEditText.getText().toString();
                String password = passEditText.getText().toString();
                for (Listener listener : getListeners()) {
                    listener.onSigninClicked(username, password);
                }
            }
        });
        signUpSignIn = findViewById(R.id.signUpSignIn);
        signUpSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Listener listener : getListeners()) {
                    listener.onSignUpClick();
                }
            }
        });
        googleSignInBtn = findViewById(R.id.googleSignInBtn);
        googleSignInBtn.setOnClickListener(v -> {
            for (Listener listener : getListeners()) {
                listener.onGoogleSignInClick();
            }
        });
        forgotPassword = findViewById(R.id.forgotPassword);
        forgotPassword.setOnClickListener(v -> {
            for (Listener listener : getListeners()) {
                listener.onForgotPasswordClick();
            }
        });
    }
}
