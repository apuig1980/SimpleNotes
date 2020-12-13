package com.toni.notes.notes.models;

import java.util.UUID;

public class Note {
    private String title;
    private String body;
    private String id;

    public Note(String title, String body, UUID id) {
        this.title = title;
        this.body = body;
        this.id = id.toString();
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getId() { return id.toString(); }

    public void setTitle(String title){ this.title = title; }

    public void setBody(String body){this.body = body; }
}
