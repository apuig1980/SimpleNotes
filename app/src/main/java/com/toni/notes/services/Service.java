package com.toni.notes.services;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.toni.notes.notes.models.Note;
import com.toni.notes.utils.Constants;
import com.toni.notes.utils.PreferencesManager;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Service
{
    public static class PersistenceService extends AppCompatActivity
    {
        public static ArrayList<Note> getNotes(PreferencesManager prefs)
        {
            Gson gson = new Gson();
            String savedJsonNotes = prefs.getNotes(Constants.NOTES_LIST);
            Type type = new TypeToken<ArrayList<Note>>(){}.getType();
            return gson.fromJson(savedJsonNotes, type);
        }

        public static void saveNotes(PreferencesManager prefs, ArrayList<Note> notes)
        {
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<Note>>(){}.getType();
            String json = gson.toJson(notes, type);
            prefs.setNotes(Constants.NOTES_LIST, json);
        }
    }
}
