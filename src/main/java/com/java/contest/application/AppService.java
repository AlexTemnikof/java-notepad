package com.java.contest.application;

import com.java.contest.gui.UserForm;
import com.java.contest.service.iservices.IService;
import com.java.contest.service.nodelist.manager.Service;

public class AppService {

    public static void main(String[] args){
        start();
        IService nodeListManager = new Service();
        UserForm e = new UserForm(nodeListManager);
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
