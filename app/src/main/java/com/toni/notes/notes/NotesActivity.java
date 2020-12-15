package com.toni.notes.notes;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.toni.notes.BaseActivity;
import com.toni.notes.R;
import com.toni.notes.notes.models.Note;
import com.toni.notes.services.Service;
import com.toni.notes.utils.Constants;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.UUID;

public class NotesActivity extends BaseActivity
{

    private ArrayList<Note> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        populateNoteList();
        initializeAddNoteButton();
        setRecyclerView();
    }

    private void populateNoteList()
    {
        notes = new ArrayList<Note>();
        String savedJsonNotes = prefs.getNotes(Constants.NOTES_LIST);

        if (!savedJsonNotes.isEmpty())
        {
            ArrayList<Note> savedNotes = Service.PersistenceService.getNotes(prefs);

            for (Note savedNote : savedNotes)
            {
                notes.add(savedNote);
            }
        }
    }

    private void initializeAddNoteButton()
    {
        ImageButton btAddNote = findViewById(R.id.ibAddNote);

        btAddNote.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                UUID noteId = UUID.randomUUID();
                notes.add(0, new Note(getString(R.string.defaultTitle), getString(R.string.defaultBody), noteId));
                setRecyclerView();
                saveNewNote();
            }
        });
    }

    private void setRecyclerView()
    {
        RecyclerView rvNotes = findViewById(R.id.rvNotes);

        NotesAdapter adapter = new NotesAdapter(notes, NotesActivity.this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(NotesActivity.this);

        rvNotes.setAdapter(adapter);
        rvNotes.setLayoutManager(manager);
        rvNotes.setHasFixedSize(true);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        setContentView(R.layout.activity_notes);
        populateNoteList();
        initializeAddNoteButton();
        setRecyclerView();
    }

    private void saveNewNote()
    {
        Service.PersistenceService.saveNotes(prefs, notes);
    }

}