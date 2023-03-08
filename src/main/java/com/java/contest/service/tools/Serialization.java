package com.java.contest.service.tools;

import com.java.contest.service.nodelist.manager.Service;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serialization {
    public static void serialize(Service service){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/service.bin")))
        {
            oos.writeObject(service);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
}
