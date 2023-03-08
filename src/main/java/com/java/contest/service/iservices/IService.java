package com.java.contest.service.iservices;

import com.java.contest.core.entities.Node;
import com.java.contest.core.entities.NodeImg;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public interface IService {
    List<Node> getNodes();


    String createNode();

    void deleteNode(String id);

    ArrayList<JMenuItem> transferNodes();

    Node findNodeById(String id);

    void saveNode(String id, String header, String text, ArrayList<NodeImg> images);

    void save();
    JMenuItem transferNode(String header);
}
