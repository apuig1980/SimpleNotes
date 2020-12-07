package com.toni.notes.notes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.toni.notes.R;
import com.toni.notes.notes.models.Note;
import com.toni.notes.utils.Constants;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    ArrayList<Note> notes;
    Context ctx;

    public NotesAdapter(ArrayList<Note> notes, Context ctx) {
        this.notes = notes;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.tvNoteTitle.setText(notes.get(position).getTitle());
        holder.tvNoteBody.setText(notes.get(position).getBody());

        holder.llNoteContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, DetailNoteActivity.class);
                intent.putExtra(Constants.EXTRA_NOTE_TITLE, notes.get(position).getTitle());
                intent.putExtra(Constants.EXTRA_NOTE_BODY, notes.get(position).getBody());
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
