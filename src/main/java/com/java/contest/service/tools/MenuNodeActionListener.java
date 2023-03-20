package com.java.contest.service.tools;

import com.java.contest.core.entities.Note;
import com.java.contest.gui.UserForm;

import java.awt.event.*;

public class MenuNodeActionListener implements ActionListener {

    private Note note;

    public MenuNodeActionListener(Note note){
        this.note = note;
    }
    public void actionPerformed(ActionEvent e) {
        method();
    }

    private void method(){
        UserForm.open(note.getId(), note.getHeader(), note.getBodyText(), note.getImages());
    }
}
