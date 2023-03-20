package com.java.contest.service.tools;

import com.java.contest.service.nodelist.manager.ServiceImpl;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public abstract class Deserialization {
    public static ServiceImpl deserialize(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/service.bin")))
        {
            ServiceImpl s =  (ServiceImpl)ois.readObject();
            return s;
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        return null;
    }
}
