package com.toni.notes.utils;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class PreferencesManager {

    private Context ctx;

    public PreferencesManager(Context ctx) {
        this.ctx = ctx;
    }

    public void deleteAllPrefs(){
        SharedPreferences prefs = ctx.getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE);
        prefs.edit().clear().commit();
        prefs.edit().apply();

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

    public void setNotes(String key, String value){
        SharedPreferences.Editor editor = ctx.getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getNotes(String key){
        SharedPreferences prefs = ctx.getSharedPreferences(Constants.PREFS_NAME, MODE_PRIVATE);
        return prefs.getString(key, "");
    }
}
