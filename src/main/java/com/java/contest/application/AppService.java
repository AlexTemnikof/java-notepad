package com.java.contest.application;

import com.java.contest.gui.UserForm;
import com.java.contest.service.iservices.IService;
import com.java.contest.service.nodelist.manager.Service;
import com.java.contest.service.tools.Deserialization;

public class AppService {

    public static void main(String[] args){
        start();
        Service service = Deserialization.deserialize();
        if (service == null){
            service = new Service();
        }
        UserForm e = new UserForm(service);
    }

    private static void start(){
        init();
        //todo: implement
    }

    private static void init(){

    }

    public static void stop(){

    }
}
