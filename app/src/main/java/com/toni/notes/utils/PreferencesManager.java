package com.toni.notes.utils;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class PreferencesManager {

    private Context ctx;

    public PreferencesManager(Context ctx) {
        this.ctx = ctx;
    }

    public boolean getPrefs(String key){
        SharedPreferences prefs = ctx.getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE);
        return prefs.getBoolean(key, false);
    }

    public void setPrefs(String key, boolean value){
        SharedPreferences.Editor editor = ctx.getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE).edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
}
