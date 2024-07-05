package com.example.journeyjoy.screen.common.dialogs.pickerdialog;

public class PickEvent {
    final String pickerContent;
    final String pickerTitle;

    public PickEvent(String pickerContent, String pickerTitle) {
        this.pickerContent = pickerContent;
        this.pickerTitle = pickerTitle;
    }

    public String getPickerContent() {
        return pickerContent;
    }

    public String getPickerTitle() {
        return pickerTitle;
    }
}
