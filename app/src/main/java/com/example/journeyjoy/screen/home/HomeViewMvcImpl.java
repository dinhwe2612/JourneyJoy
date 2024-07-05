package com.example.journeyjoy.screen.home;

import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.journeyjoy.R;
import com.example.journeyjoy.screen.common.ViewMvcFactory;
import com.example.journeyjoy.screen.common.toolbar.ToolbarViewMvc;
import com.example.journeyjoy.screen.common.views.BaseObservableViewMvc;

import org.w3c.dom.Text;

public class HomeViewMvcImpl extends BaseObservableViewMvc<HomeViewMvc.Listener>
        implements HomeViewMvc{

    EditText mSearchBarText;
    ImageButton mSearchButton;
    Toolbar mToolbar;
    ToolbarViewMvc mToolbarViewMvc;

    ImageButton mTransportBtn;
    public HomeViewMvcImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        setRootView(inflater.inflate(R.layout.layout_home, parent, false));
        mSearchButton = findViewById(R.id.searchButton);
        mSearchButton.setOnClickListener(v -> {
            for (Listener listener : getListeners()) {
                listener.onSearchClick(mSearchBarText.getText().toString());
            }
        });
        mSearchBarText = findViewById(R.id.searchBarText);
        mTransportBtn = findViewById(R.id.transportBtn);
        mTransportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Listener listener : getListeners()) {
                    listener.onTransportClick();
                }
            }
        });
        mToolbar = findViewById(R.id.toolbar);
        mToolbarViewMvc = viewMvcFactory.getToolbarViewMvc(mToolbar);
        mToolbarViewMvc.setTitle("Explore the beautiful world!");
        mToolbar.addView(mToolbarViewMvc.getRootView());
    }
}
