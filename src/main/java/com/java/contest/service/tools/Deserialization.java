package com.java.contest.service.tools;

import com.java.contest.service.nodelist.manager.Service;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public abstract class Deserialization {
    //todo: implement
    public static Service deserialize(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/service.bin")))
        {
            Service s =  (Service)ois.readObject();
            return s;
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        return null;
    }
}
