package com.java.contest.service.nodelist.manager;

import com.java.contest.core.entities.Note;
import com.java.contest.core.entities.NoteImg;
import com.java.contest.service.iservices.Service;
import com.java.contest.service.tools.InitJMenuItem;
import com.java.contest.service.tools.Serialization;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ServiceImpl implements Service, Serializable {

    private final ArrayList<Note> notes;

    public ServiceImpl(){
        notes = new ArrayList<>();
    }

    public List<Note> getNotes(){

        return notes;
    }

    public String createNote(){
        Note note = new Note();
        notes.add(note);
        return note.getId();
    }

    private Note createNote(String header){
        Note note = new Note(header);
        notes.add(note);
        return note;
    }

    public void deleteNote(String id){

        notes.removeIf(item -> item.getId().equals(id));
    }

    public ArrayList<JMenuItem> transferNotes(){
        return InitJMenuItem.transferNodes(notes);
    }

    public JMenuItem transferNote(String id){
        Note note = findNoteById(id);
        return InitJMenuItem.transferNode(note);
    }

    public Note findNoteById(String id){
        return notes.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }

    public String saveNote(String id, String header, String text, ArrayList<NoteImg> images){
        Note note = findNoteById(id);
        if (note != null) {
            note.updateFields(header, text, images);
            return note.getId();
        }
        else{
            Note newNote = createNote(header);
            newNote.updateFields(header, text, images);
            return newNote.getId();
        }
    }

    public void save(){
        Serialization.serialize(this);
    }
}
