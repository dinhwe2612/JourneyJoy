package com.example.journeyjoy.screen.common.toolbar;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.journeyjoy.R;
import com.example.journeyjoy.screen.common.controllers.BaseActivity;
import com.example.journeyjoy.screen.common.views.BaseViewMvc;

public class ToolbarViewMvc extends BaseViewMvc {
    public interface NavigateUpClickListener {
        void onNavigateUpClick();
    }

    NavigateUpClickListener mNavigateUpClickListener;
    ImageButton mBtnBack;
    TextView mTitle;

    public ToolbarViewMvc(LayoutInflater inflater, ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_toolbar, parent, false));
        mBtnBack = findViewById(R.id.btn_back);
        mTitle = findViewById(R.id.txt_toolbar_title);
        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mNavigateUpClickListener != null) {
                    mNavigateUpClickListener.onNavigateUpClick();
                }
            }
        });
    }

    public void setTitle(String title) {
        mTitle.setText(title);
    }
    public void enableUpButtonAndListen(NavigateUpClickListener listener) {
        if (mNavigateUpClickListener != null) {
            throw new RuntimeException("NavigateUpClickListener must not be null");
        }
        mNavigateUpClickListener = listener;
        mBtnBack.setVisibility(View.VISIBLE);
    }
}
