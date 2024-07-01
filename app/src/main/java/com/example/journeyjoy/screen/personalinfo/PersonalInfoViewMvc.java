package com.example.journeyjoy.screen.personalinfo;

import com.example.journeyjoy.screen.common.views.ObservableViewMvc;

public interface PersonalInfoViewMvc extends ObservableViewMvc<PersonalInfoViewMvc.Listener> {
    interface Listener {
        void onSaveChanges();

        void onNavigateUpClick();
    }
}
