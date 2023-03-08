package com.java.contest.core.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Node implements Serializable {

    private final String id;
    private String header;
    private String bodyText;
    private ArrayList<NodeImg> images;
    private Date lastEditDate;

    public Node(){
        id = UUID.randomUUID().toString();
        header = "New node";
        bodyText = "Type here...";
        images = new ArrayList<NodeImg>();
        lastEditDate = new Date();
    }

    public Node(String header){
        id = UUID.randomUUID().toString();
        this.header = header;
        bodyText = "Write here...";
        images = new ArrayList<>();
        lastEditDate = new Date();
    }

    Node(String header, String bodyText,
         ArrayList<NodeImg> images, Date lastEditDate){
        id = UUID.randomUUID().toString();
        this.header = header;
        this.bodyText = bodyText;
        this.images = images;
        this.lastEditDate = lastEditDate;
    }

    public void updateFields(String header, String bodyText, ArrayList<NodeImg> nodeImgArrayList){
        this.header = header;
        this.bodyText = bodyText;
        this.images = nodeImgArrayList;
    }

    public void textEdit(String text){
        bodyText = text;
    }

    public String getId(){
        return id;
    }
    public String getHeader(){
        return header;
    }

    public String getBodyText(){
        return bodyText;
    }

    public ArrayList<NodeImg> getImages(){
        return images;
    }

    public Date getLastEditDate(){
        return lastEditDate;
    }
}
