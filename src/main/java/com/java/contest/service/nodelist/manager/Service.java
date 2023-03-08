package com.java.contest.service.nodelist.manager;

import com.java.contest.core.entities.Node;
import com.java.contest.core.entities.NodeImg;
import com.java.contest.service.iservices.IService;
import com.java.contest.service.tools.InitJMenuItem;
import com.java.contest.service.tools.Serialization;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Service implements IService, Serializable {

    private final ArrayList<Node> nodes;

    public Service(){
        nodes = new ArrayList<>();
    }

    public List<Node> getNodes(){

        return nodes;
    }

    public String createNode(){
        Node node = new Node();
        nodes.add(node);
        return node.getId();
    }

    private Node createNode(String header){
        Node node = new Node(header);
        nodes.add(node);
        return node;
    }

    public void deleteNode(String id){

        nodes.removeIf(item -> item.getId().equals(id));
    }

    public ArrayList<JMenuItem> transferNodes(){
        return InitJMenuItem.transferNodes(nodes);
    }

    public JMenuItem transferNode(String id){
        Node node = findNodeById(id);
        return InitJMenuItem.transferNode(node);
    }

    public Node findNodeById(String id){
        return nodes.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }

    public String saveNode(String id, String header, String text, ArrayList<NodeImg> images){
        Node node = findNodeById(id);
        if (node != null) {
            node.updateFields(header, text, images);
            return node.getId();
        }
        else{
            Node newNode = createNode(header);
            newNode.updateFields(header, text, images);
            return newNode.getId();
        }
    }

    public void save(){
        Serialization.serialize(this);
    }
}
