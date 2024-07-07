package com.example.journeyjoy.screen.account;

import android.graphics.Bitmap;

import com.example.journeyjoy.screen.common.views.ObservableViewMvc;

public interface AccountViewMvc extends ObservableViewMvc<AccountViewMvc.Listener> {
    interface Listener {
        void onPersonalInfoClicked();
        void onAnotherClick();
    }
    void loadPersonalInfo(String firstname, String lastname);
    void loadAvatar(Bitmap bitmap);
}
