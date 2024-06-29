package com.example.journeyjoy.screen.common.views;

import java.util.List;

public interface ObservableViewMvc<ListenerType> extends ViewMvc {
    void registerListener(ListenerType listener);
    void unregisterListener(ListenerType listener);
}
