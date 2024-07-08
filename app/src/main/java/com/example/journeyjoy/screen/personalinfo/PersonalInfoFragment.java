package com.example.journeyjoy.screen.personalinfo;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.journeyjoy.screen.common.controllers.BaseFragment;
import com.example.journeyjoy.screen.common.screensnavigator.ScreensNavigator;
import com.example.journeyjoy.utils.SharedPreferencesUtils;

import java.io.IOException;

public class PersonalInfoFragment extends BaseFragment implements
    PersonalInfoViewMvc.Listener{

    private static final int PICK_IMAGE_REQUEST = 1;
    ScreensNavigator mScreensNavigator;
    PersonalInfoViewMvc viewMvc;
    public static Fragment newInstance() {
        return new PersonalInfoFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScreensNavigator = getCompositionRoot().getScreensNavigator();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewMvc = getCompositionRoot().getViewMvcFactory().getPersonalInfoViewMvc(container);
        bindInfo();
        return viewMvc.getRootView();
    }

    void bindInfo() {
        String firstname = SharedPreferencesUtils.getString(requireContext(), "firstname", null);
        String lastname = SharedPreferencesUtils.getString(requireContext(), "lastname", null);
        String phone = SharedPreferencesUtils.getString(requireContext(), "phone", null);
        String email = SharedPreferencesUtils.getString(requireContext(), "email", null);
        if (firstname == null) {
            firstname = "Victoria";
        }
        if (lastname == null) {
            lastname = "Yoker";
        }
        if (phone == null) {
            phone = "+380 12 345 67 89";
        }
        if (email == null) {
            email = "levi.woodbury@examplepetstore.com";
        }
        viewMvc.loadPersonalInfo(firstname, lastname, phone, email);
        Bitmap avatar = SharedPreferencesUtils.getImage(requireContext(), "avatar");
        if (avatar != null) {
            viewMvc.loadAvatar(avatar);
        }
    }


    @Override
    public void onNavigateUpClick() {
        mScreensNavigator.navigateUp();
    }

    @Override
    public void onSaveChangesClick(String firstname, String lastname, String phone, String email) {
        SharedPreferencesUtils.saveString(requireContext(), "firstname", firstname);
        SharedPreferencesUtils.saveString(requireContext(), "lastname", lastname);
        SharedPreferencesUtils.saveString(requireContext(), "phone", phone);
        SharedPreferencesUtils.saveString(requireContext(), "email", email);
        mScreensNavigator.navigateUp();
    }

    @Override
    public void onChoosePhotoClick() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), imageUri);
                SharedPreferencesUtils.saveImage(requireContext(), "avatar", bitmap);
                viewMvc.loadAvatar(bitmap);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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
