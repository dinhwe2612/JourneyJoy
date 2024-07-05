package com.example.journeyjoy.screen.common.dialogs;

import com.example.journeyjoy.common.BaseObservable;

public class DialogsEventBus extends BaseObservable<DialogsEventBus.Listener> {
    public interface Listener {
        void onDialogEvent(Object event);
    }

    public void postEvent(Object event) {
        for (Listener listener : getListeners()) {
            listener.onDialogEvent(event);
        }
    }
}
