package com.java.contest.service.tools;

import com.java.contest.service.nodelist.manager.ServiceImpl;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serialization {
    public static void serialize(ServiceImpl serviceImpl){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/service.bin")))
        {
            oos.writeObject(serviceImpl);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
}
