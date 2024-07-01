package com.example.journeyjoy.screen.account;

import com.example.journeyjoy.screen.common.views.ObservableViewMvc;

public interface AccountViewMvc extends ObservableViewMvc<AccountViewMvc.Listener> {
    interface Listener {
        void onPersonalInfoClicked();
    }
}
