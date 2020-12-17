package com.toni.notes.notes;

import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.toni.notes.BaseActivity;
import com.toni.notes.R;
import com.toni.notes.notes.models.Note;
import com.toni.notes.services.Service;
import com.toni.notes.utils.Constants;

import java.util.ArrayList;

public class DetailNoteActivity extends BaseActivity
{
    private String _noteId;
    private TextView tvNoteTitle;
    private TextView tvNoteBody;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);

        tvNoteTitle = findViewById(R.id.tvNoteTitle);
        tvNoteBody = findViewById(R.id.tvNoteBody);

        String noteId = getIntent().getStringExtra(Constants.EXTRA_ID);
        _noteId = noteId;

        Note currentNote = getCurrentNote();
        String currentTitle = currentNote.getTitle();
        String currentBody = currentNote.getBody();

        setDefaultTexts(currentTitle, currentBody);


        tvNoteTitle.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View v, boolean hasFocus)
            {
                if (!hasFocus)
                {
                    saveNote(noteId, tvNoteTitle.getText().toString(), tvNoteBody.getText().toString());
                }
            }
        });


        tvNoteBody.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View v, boolean hasFocus)
            {
                if(!hasFocus)
                {
                    saveNote(noteId, tvNoteTitle.getText().toString(), tvNoteBody.getText().toString());
                }
            }
        });
    }

    private void setDefaultTexts(String currentTitle, String currentBody)
    {
        if (!currentTitle.equals(getString(R.string.defaultTitle)))
        {
            tvNoteTitle.setText(currentTitle);
        }

        if (!currentBody.equals(getString(R.string.defaultBody)))
        {
            tvNoteBody.setText(currentBody);
        }
    }

    private Note getCurrentNote()
    {
        ArrayList<Note> notesList = Service.PersistenceService.getNotes(prefs);

        for (Note savedNote : notesList)
        {
            if (savedNote.getId().equals(_noteId))
            {
                return savedNote;
            }
        }
        return null;
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        saveNote(_noteId, tvNoteTitle.getText().toString(), tvNoteBody.getText().toString());
    }

    private void saveNote(String noteId, String title, String body)
    {
        ArrayList<Note> notesList = Service.PersistenceService.getNotes(prefs);

        for (Note savedNote : notesList)
        {
            if (savedNote.getId().equals(noteId))
            {
                _noteId = noteId;
                savedNote.setTitle(title);
                savedNote.setBody(body);
            }
        }
        Service.PersistenceService.saveNotes(prefs, notesList);
    }
}
