package com.example.journeyjoy.screen.common.dialogs.pickerdialog;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.journeyjoy.R;
import com.example.journeyjoy.model.city.City;
import com.example.journeyjoy.screen.common.dialogs.BaseDialog;
import com.example.journeyjoy.screen.common.dialogs.DialogsEventBus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PickerDialog extends BaseDialog {

    public static final String ARG_TITLE = "title";
    public static final String ARG_MESSAGE = "message";
    public  static final String ARG_BUTTON_TEXT = "button_text";
    public static final String ARG_ITEMS = "items";

    private PickerDialog() {

    }
    public static PickerDialog newInstance(String title, String message, String buttonText, ArrayList<String> items) {
        PickerDialog dialog = new PickerDialog();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_MESSAGE, message);
        args.putString(ARG_BUTTON_TEXT, buttonText);
        args.putStringArrayList(ARG_ITEMS, new ArrayList<>(items));
        dialog.setArguments(args);
        return dialog;
    }

    String selectedItem;

    DialogsEventBus dialogsEventBus;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialogsEventBus = getCompositionRoot().getDialogsEventBus();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        if (getArguments() == null) {
            throw new IllegalArgumentException("Arguments dialog must be not null");
        }
        Dialog dialog = new Dialog(requireContext());
        dialog.setContentView(R.layout.dialog_picker);
        TextView title = dialog.findViewById(R.id.titlePicker);
        TextView message = dialog.findViewById(R.id.messagePicker);
        TextView button = dialog.findViewById(R.id.dialogBtnPicker);
        title.setText(getArguments().getString(ARG_TITLE));
        message.setText(getArguments().getString(ARG_MESSAGE));
        button.setText(getArguments().getString(ARG_BUTTON_TEXT));
        button.setOnClickListener(v -> {
            dialogsEventBus.postEvent(new PickEvent(selectedItem, title.getText().toString()));
            dismiss();
        });
        List<String> items = getArguments().getStringArrayList(ARG_ITEMS);
        NumberPicker picker = dialog.findViewById(R.id.picker);
        picker.setMinValue(0);
        picker.setMaxValue(items.size() - 1);
        picker.setDisplayedValues(items.toArray(new String[0]));
        selectedItem = items.get(0);
        picker.setOnValueChangedListener((picker1, oldVal, newVal) -> {
            selectedItem = items.get(newVal);
        });

        return dialog;
    }
}
