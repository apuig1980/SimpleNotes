package com.toni.notes.notes.models;

import java.util.UUID;

public class Note {
    private String title;
    private String body;
    private UUID id;

    public Note(String title, String body, UUID id) {
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public UUID getId() { return id; }
}
