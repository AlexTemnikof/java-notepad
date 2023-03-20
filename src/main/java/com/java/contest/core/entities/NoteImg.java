package com.java.contest.core.entities;

import javax.swing.*;
import java.io.Serializable;

public class NoteImg implements Serializable {
    private Integer index;
    private ImageIcon img;

    public NoteImg(){
    }

    public NoteImg(Integer index, ImageIcon img){
        this.index = index;
        this.img = img;
    }

    public int getIndex(){
        return index;
    }

    public ImageIcon getImg(){
        return img;
    }

}
