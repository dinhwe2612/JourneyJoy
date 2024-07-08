package com.example.journeyjoy.screen.signin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.journeyjoy.R;
import com.example.journeyjoy.screen.common.MainActivity;
import com.example.journeyjoy.screen.common.controllers.BaseFragment;
import com.example.journeyjoy.screen.common.screensnavigator.ScreensNavigator;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class SignInFragment extends BaseFragment implements SignInViewMvc.Listener {

    ScreensNavigator screensNavigator;
    SignInViewMvc viewMvc;
    FirebaseAuth mAuth;
    GoogleSignInClient mGoogleSignInClient;

    final int RC_SIGN_IN = 28;

    public static Fragment newInstance() {
        return new SignInFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screensNavigator = getCompositionRoot().getScreensNavigator();
        mAuth = FirebaseAuth.getInstance();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(getActivity(), gso);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewMvc = getCompositionRoot().getViewMvcFactory().getSignInViewMvc(container);
        return viewMvc.getRootView();
    }

    @Override
    public void onSigninClicked(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(getActivity(), task -> {
            if (task.isSuccessful()) {
                // Sign in success, update UI with the signed-in user's information
                Toast.makeText(getActivity(), "Authentication successful.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
            else {
                // If sign in fails, display a message to the user.
                Toast.makeText(getActivity(), "Authentication failed.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onSignupClicked() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onNavigateUpClick() {
        screensNavigator.navigateUp();
    }

    @Override
    public void onSignUpClick() {
        screensNavigator.toSignUp();
    }

    @Override
    public void onGoogleSignInClick() {
        startActivity(mGoogleSignInClient.getSignInIntent());
    }

    @Override
    public void onForgotPasswordClick() {
        screensNavigator.toForgotPassword();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);
            // Signed in successfully, show authenticated UI.
            Toast.makeText(getActivity(), "Authentication successful.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
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
