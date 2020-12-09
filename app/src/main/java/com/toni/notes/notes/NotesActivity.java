package com.toni.notes.notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.toni.notes.BaseActivity;
import com.toni.notes.LoginActivity;
import com.toni.notes.R;
import com.toni.notes.notes.models.Note;
import com.toni.notes.utils.Constants;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class NotesActivity extends BaseActivity {
    RecyclerView rvNotes;
    ArrayList<Note> notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        populateNoteList();

        initializeAddNoteButton();

        setRecyclerView();
    }

    private void populateNoteList() {
        notes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            notes.add(new Note("Pasear perro" + i, "Hace mucho tiempo que no sale"));
        }
    }

    private void initializeAddNoteButton() {
        ImageButton btAddNote = findViewById(R.id.ibAddNote);


        btAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notes.add(0, new Note("New Note", "Description"));
                setRecyclerView();
                saveNewNote();
            }
        });
    }

    private void saveNewNote(){
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Note>>() {
        }.getType();
        String json = gson.toJson(notes, type);
    }

    private void setRecyclerView() {
        rvNotes = findViewById(R.id.rvNotes);

        NotesAdapter adapter = new NotesAdapter(notes, NotesActivity.this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(NotesActivity.this);

        rvNotes.setAdapter(adapter);
        rvNotes.setLayoutManager(manager);
        rvNotes.setHasFixedSize(true);
    }

    /*private void showList()
    {
        setRecyclerView();

        //setLogoutEvents();
    }*/



    /*private void setLogoutEvents() {
        Button btLogout = findViewById(R.id.btLogout);

        btLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prefs.setPrefs(Constants.USER_LOGGED, false);
                Intent intent = new Intent(NotesActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }*/
}