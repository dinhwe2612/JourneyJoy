package com.example.journeyjoy.screen.account;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
                Log.d(
                        "AccountViewMvcImpl",
                        "onPersonalInfoClicked"
                );
                for (Listener listener : getListeners()) {
                    listener.onPersonalInfoClicked();
                }
            }
        });
    }
}
