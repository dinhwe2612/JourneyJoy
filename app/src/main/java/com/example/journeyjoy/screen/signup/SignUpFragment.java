package com.example.journeyjoy.screen.signup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.journeyjoy.screen.common.controllers.BaseFragment;
import com.example.journeyjoy.screen.common.screensnavigator.ScreensNavigator;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpFragment extends BaseFragment implements
        SignUpViewMvc.Listener{
    SignUpFragment() {}
    public static Fragment newInstance() {
        return new SignUpFragment();
    }

    ScreensNavigator screensNavigator;
    SignUpViewMvc viewMvc;
    FirebaseAuth firebaseAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screensNavigator = getCompositionRoot().getScreensNavigator();
        firebaseAuth = FirebaseAuth.getInstance();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewMvc = getCompositionRoot().getViewMvcFactory().getSignUpViewMvc(container);
        return viewMvc.getRootView();
    }

    @Override
    public void onSignUpClick(String email, String password, String confirmPassword) {
        if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(requireContext(),"All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!password.equals(confirmPassword)) {
            Toast.makeText(requireContext(),"Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                Toast.makeText(requireContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                return;
            }
            onNavigateUp();
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
