package com.example.journeyjoy.screen.personalinfo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.example.journeyjoy.R;
import com.example.journeyjoy.screen.common.ViewMvcFactory;
import com.example.journeyjoy.screen.common.toolbar.ToolbarViewMvc;
import com.example.journeyjoy.screen.common.views.BaseObservableViewMvc;
import com.example.journeyjoy.utils.SharedPreferencesUtils;

public class PersonalInfoViewMvcImpl extends BaseObservableViewMvc<PersonalInfoViewMvc.Listener>
        implements PersonalInfoViewMvc {

    ToolbarViewMvc toolbarViewMvc;
    Toolbar toolbar;
    EditText firstnameEditText;
    EditText phoneEditText;
    EditText emailEditText;
    EditText lastnameEditText;
    Button saveChangesBtn;
    ImageButton choosePhotoBtn;
    ImageView imageView;
    public PersonalInfoViewMvcImpl(LayoutInflater inflater, ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        setRootView(inflater.inflate(R.layout.layout_personalinfo, parent, false));
        bindView();
        toolbarViewMvc = viewMvcFactory.getToolbarViewMvc(parent);
        toolbarViewMvc.setTitle("Personal Information");
        toolbarViewMvc.enableUpButtonAndListen(new ToolbarViewMvc.NavigateUpClickListener() {
            @Override
            public void onNavigateUpClick() {
                for (Listener listener : getListeners()) {
                    listener.onNavigateUpClick();
                }
            }
        });
        toolbar.addView(toolbarViewMvc.getRootView());
        saveChangesBtn.setOnClickListener(v -> {
            for (Listener listener : getListeners()) {
                listener.onSaveChangesClick(firstnameEditText.getText().toString(), lastnameEditText.getText().toString(), emailEditText.getText().toString(), phoneEditText.getText().toString());
            }
        });
        choosePhotoBtn.setOnClickListener(v -> {
            for (Listener listener : getListeners()) {
                listener.onChoosePhotoClick();
            }
        });
    }

    void bindView() {
        toolbar = findViewById(R.id.toolbar);
        firstnameEditText = findViewById(R.id.firstnameEditText);
        lastnameEditText = findViewById(R.id.lastnameEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        emailEditText = findViewById(R.id.emailEditText);
        saveChangesBtn = findViewById(R.id.saveChangesBtn);
        choosePhotoBtn = findViewById(R.id.choosePhotoBtn);
        imageView = findViewById(R.id.imageView);
    }

    @Override
    public void loadPersonalInfo(String firstname, String lastname, String email, String phone) {
        firstnameEditText.setText(firstname);
        lastnameEditText.setText(lastname);
        emailEditText.setText(email);
        phoneEditText.setText(phone);
    }

    @Override
    public void loadAvatar(Bitmap bitmap) {
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            imageView.setImageResource(R.drawable.ic_event);
        }
    }
}
