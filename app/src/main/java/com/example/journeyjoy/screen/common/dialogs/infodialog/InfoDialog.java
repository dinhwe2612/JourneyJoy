package com.example.journeyjoy.screen.common.dialogs.infodialog;


import android.app.Dialog;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.journeyjoy.R;
import com.example.journeyjoy.screen.common.dialogs.BaseDialog;
import com.example.journeyjoy.screen.common.dialogs.DialogsManager;

public class InfoDialog extends BaseDialog {

    private static final String ARG_TITLE = "title";
    private static final String ARG_MESSAGE = "message";
    private static final String ARG_BUTTON_TEXT = "buttonText";

    private InfoDialog(){

    }
    public static InfoDialog newInstance(String title, String message, String buttonText) {
        InfoDialog dialog = new InfoDialog();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_MESSAGE, message);
        args.putString(ARG_BUTTON_TEXT, buttonText);
        dialog.setArguments(args);
        return dialog;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        if (getArguments() == null) {
            throw new IllegalStateException("Unexpected arguments dialog");
        }
        Dialog dialog = new Dialog(requireContext());
        dialog.setContentView(R.layout.dialog_info);
        TextView title = dialog.findViewById(R.id.titleText);
        TextView message = dialog.findViewById(R.id.messageText);
        TextView button = dialog.findViewById(R.id.dialogBtn);
        title.setText(getArguments().getString(ARG_TITLE));
        message.setText(getArguments().getString(ARG_MESSAGE));
        button.setText(getArguments().getString(ARG_BUTTON_TEXT));
        button.setOnClickListener(v -> dismiss());
        return dialog;
    }
}
