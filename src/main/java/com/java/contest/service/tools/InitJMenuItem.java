package com.java.contest.service.tools;

import com.java.contest.core.entities.Node;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class InitJMenuItem {

    public static ArrayList<JMenuItem> transferNodes(List<Node> nodeList){
        ArrayList<JMenuItem> list = new ArrayList<>();
        for (Node n : nodeList){
            JMenuItem menuItem = new JMenuItem(n.getHeader());
            menuItem.addActionListener(new MenuNodeActionListener(n));
            list.add(menuItem);
        }
        return list;
    }

    public static JMenuItem transferNode(Node n){
        JMenuItem menuItem = new JMenuItem(n.getHeader());
        menuItem.addActionListener(new MenuNodeActionListener(n));
        return menuItem;
    }

}
