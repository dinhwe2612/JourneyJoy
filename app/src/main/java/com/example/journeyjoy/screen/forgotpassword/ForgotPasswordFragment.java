package com.example.journeyjoy.screen.forgotpassword;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.journeyjoy.screen.common.controllers.BaseFragment;
import com.example.journeyjoy.screen.common.screensnavigator.ScreensNavigator;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordFragment extends BaseFragment implements
        ForgotPasswordViewMvc.Listener{
    ForgotPasswordFragment() {}
    public static ForgotPasswordFragment newInstance() {
        return new ForgotPasswordFragment();
    }

    ForgotPasswordViewMvc viewMvc;
    FirebaseAuth mAuth;
    ScreensNavigator screensNavigator;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screensNavigator = getCompositionRoot().getScreensNavigator();
        mAuth = FirebaseAuth.getInstance();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewMvc = getCompositionRoot().getViewMvcFactory().getForgotPasswordViewMvc(container);
        return viewMvc.getRootView();
    }

    @Override
    public void onForgotPassword(String email) {
        if (email.isEmpty()) {
            return;
        }
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(getContext(), "Email sent", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onNavigateUp() {
        screensNavigator.navigateUp();
    }

    @Override
    public void onStart() {
        super.onStart();
        viewMvc.registerListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        viewMvc.unregisterListener(this);
    }
}
