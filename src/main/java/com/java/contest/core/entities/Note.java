package com.java.contest.core.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Note implements Serializable {

    private final String id;
    private String header;
    private String bodyText;
    private ArrayList<NoteImg> images;
    private Date lastEditDate;

    public Note(){
        id = UUID.randomUUID().toString();
        header = "New node";
        bodyText = "Type here...";
        images = new ArrayList<NoteImg>();
        lastEditDate = new Date();
    }

    public Note(String header){
        id = UUID.randomUUID().toString();
        this.header = header;
        bodyText = "Write here...";
        images = new ArrayList<>();
        lastEditDate = new Date();
    }

    Note(String header, String bodyText,
         ArrayList<NoteImg> images, Date lastEditDate){
        id = UUID.randomUUID().toString();
        this.header = header;
        this.bodyText = bodyText;
        this.images = images;
        this.lastEditDate = lastEditDate;
    }

    public void updateFields(String header, String bodyText, ArrayList<NoteImg> noteImgArrayList){
        this.header = header;
        this.bodyText = bodyText;
        this.images = noteImgArrayList;
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

    public ArrayList<NoteImg> getImages(){
        return images;
    }

    public Date getLastEditDate(){
        return lastEditDate;
    }
}
