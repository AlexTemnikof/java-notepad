package com.java.contest.service.tools;

import com.java.contest.core.entities.Note;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class InitJMenuItem {

    public static ArrayList<JMenuItem> transferNodes(List<Note> noteList){
        ArrayList<JMenuItem> list = new ArrayList<>();
        for (Note n : noteList){
            JMenuItem menuItem = new JMenuItem(n.getHeader());
            menuItem.addActionListener(new MenuNodeActionListener(n));
            list.add(menuItem);
        }
        return list;
    }

    public static JMenuItem transferNode(Note n){
        JMenuItem menuItem = new JMenuItem(n.getHeader());
        menuItem.addActionListener(new MenuNodeActionListener(n));
        return menuItem;
    }

}
