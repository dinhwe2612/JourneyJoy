package com.example.journeyjoy.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

public class SharedPreferencesUtils {

    private static final String PREF_NAME = "MyPrefs";

    // Save a string to SharedPreferences
    public static void saveString(Context context, String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    // Retrieve a string from SharedPreferences
    public static String getString(Context context, String key, String defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, defaultValue);
    }

    // Save a bitmap image to SharedPreferences
    public static void saveImage(Context context, String key, Bitmap image) {
        String encodedImage = encodeToBase64(image);
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, encodedImage);
        editor.apply();
    }

    // Retrieve a bitmap image from SharedPreferences
    public static Bitmap getImage(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String encodedImage = sharedPreferences.getString(key, null);
        if (encodedImage != null) {
            return decodeFromBase64(encodedImage);
        }
        return null;
    }

    // Convert a Bitmap to a Base64 encoded string
    private static String encodeToBase64(Bitmap image) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

    // Decode a Base64 encoded string to a Bitmap
    private static Bitmap decodeFromBase64(String input) {
        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }
}
