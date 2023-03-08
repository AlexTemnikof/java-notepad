package com.java.contest.service.tools;

import com.java.contest.core.entities.Node;
import com.java.contest.gui.UserForm;

import java.awt.event.*;

public class MenuNodeActionListener implements ActionListener {

    private Node node;

    public MenuNodeActionListener(Node node){
        this.node = node;
    }
    public void actionPerformed(ActionEvent e) {
        method();
    }

    private void method(){
        UserForm.open(node.getId(), node.getHeader(), node.getBodyText(), node.getImages());
    }
}
