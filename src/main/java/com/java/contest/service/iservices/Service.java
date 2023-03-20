package com.java.contest.service.iservices;

import com.java.contest.core.entities.Note;
import com.java.contest.core.entities.NoteImg;

import javax.swing.*;
import java.util.ArrayList;

public interface Service {


    String createNote();

    void deleteNote(String id);

    ArrayList<JMenuItem> transferNotes();

    Note findNoteById(String id);

    String saveNote(String id, String header, String text, ArrayList<NoteImg> images);

    void save();
}
