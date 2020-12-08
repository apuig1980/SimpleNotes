package com.toni.notes.notes;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.toni.notes.R;

public class NoteViewHolder extends RecyclerView.ViewHolder {

        LinearLayout llNoteContainer;
        TextView tvNoteTitle, tvNoteBody;
        ImageButton ibDelete;

    public NoteViewHolder(@NonNull View view) {
        super(view);

        llNoteContainer = view.findViewById(R.id.llNoteContainer);
        tvNoteTitle = view.findViewById(R.id.tvNoteTitle);
        tvNoteBody = view.findViewById(R.id.tvNoteBody);
        ibDelete = view.findViewById(R.id.ibDelete);

    }
}
