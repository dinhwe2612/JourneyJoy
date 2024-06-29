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
    public HomeViewMvcImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        setRootView(inflater.inflate(R.layout.layout_home, parent, false));
        mSearchButton = findViewById(R.id.searchButton);
        mSearchBarText = findViewById(R.id.searchBarText);
        mToolbar = findViewById(R.id.toolbar);
        mToolbarViewMvc = viewMvcFactory.getToolbarViewMvc(mToolbar);
        mToolbarViewMvc.setTitle("Explore the beautiful world!");
        mToolbarViewMvc.setGravityTitleStart();
        mToolbar.addView(mToolbarViewMvc.getRootView());
    }
}
