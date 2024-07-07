package com.example.journeyjoy.screen.account;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.journeyjoy.R;
import com.example.journeyjoy.screen.common.ViewMvcFactory;
import com.example.journeyjoy.screen.common.toolbar.ToolbarViewMvc;
import com.example.journeyjoy.screen.common.views.BaseObservableViewMvc;
import com.example.journeyjoy.screen.common.views.ObservableViewMvc;

public class AccountViewMvcImpl extends BaseObservableViewMvc<AccountViewMvc.Listener>
    implements AccountViewMvc {

    Toolbar toolbar;
    ToolbarViewMvc toolbarViewMvc;
    Button accountInfoBtn;
    Button paymentCardBtn;
    Button savedBtn;
    Button bookingHistoryBtn;
    Button settingsBtn;

    public AccountViewMvcImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        setRootView(inflater.inflate(R.layout.layout_account, parent, false));
        toolbar = findViewById(R.id.toolbar);
        toolbarViewMvc = viewMvcFactory.getToolbarViewMvc(toolbar);
        toolbarViewMvc.setTitle("Account");
        toolbar.addView(toolbarViewMvc.getRootView());
        accountInfoBtn = findViewById(R.id.personalIn4Btn);
        accountInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Listener listener : getListeners()) {
                    listener.onPersonalInfoClicked();
                }
            }
        });
        paymentCardBtn = findViewById(R.id.paymentCardBtn);
        paymentCardBtn.setOnClickListener(v -> {
            for (Listener listener : getListeners()) {
                listener.onAnotherClick();
            }
        });
        savedBtn = findViewById(R.id.savedBtn);
        savedBtn.setOnClickListener(v -> {
            for (Listener listener : getListeners()) {
                listener.onAnotherClick();
            }
        });
        bookingHistoryBtn = findViewById(R.id.bookingHistoryBtn);
        bookingHistoryBtn.setOnClickListener(v -> {
            for (Listener listener : getListeners()) {
                listener.onAnotherClick();
            }
        });
        settingsBtn = findViewById(R.id.settingsBtn);
        settingsBtn.setOnClickListener(v -> {
            for (Listener listener : getListeners()) {
                listener.onAnotherClick();
                }
        });
    }

    @Override
    public void loadPersonalInfo(String firstname, String lastname) {
        TextView fullName = findViewById(R.id.fullName);
        fullName.setText(firstname + " " + lastname);
    }

    @Override
    public void loadAvatar(Bitmap bitmap) {
        ImageView avatar = findViewById(R.id.avatar);
        avatar.setImageBitmap(bitmap);
    }
}
