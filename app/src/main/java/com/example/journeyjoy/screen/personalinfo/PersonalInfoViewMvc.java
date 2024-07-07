package com.example.journeyjoy.screen.personalinfo;

import android.graphics.Bitmap;

import com.example.journeyjoy.screen.common.views.ObservableViewMvc;

public interface PersonalInfoViewMvc extends ObservableViewMvc<PersonalInfoViewMvc.Listener> {

    interface Listener {

        void onNavigateUpClick();
        void onSaveChangesClick(String firstname, String lastname, String email, String phone);
        void onChoosePhotoClick();
    }
    void loadPersonalInfo(String firstname, String lastname, String email, String phone);
    void loadAvatar(Bitmap bitmap);
}
