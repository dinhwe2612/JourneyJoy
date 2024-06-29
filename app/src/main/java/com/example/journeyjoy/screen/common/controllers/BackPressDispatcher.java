package com.example.journeyjoy.screen.common.controllers;

public interface BackPressDispatcher {
    void registerListener(BackPressedListener listener);
    void unregisterListener(BackPressedListener listener);
}
