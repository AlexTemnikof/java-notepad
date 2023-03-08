package com.java.contest.core.entities;

import javax.swing.*;
import java.io.Serializable;

public class NodeImg implements Serializable {
    private Integer index;
    private ImageIcon img;

    public NodeImg(){
    }

    public NodeImg(Integer index, ImageIcon img){
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
