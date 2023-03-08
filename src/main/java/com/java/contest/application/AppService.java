package com.java.contest.application;

import com.java.contest.gui.UserForm;
import com.java.contest.service.nodelist.manager.Service;
import com.java.contest.service.tools.Deserialization;

public class AppService {

    public static void main(String[] args){
        Service service = Deserialization.deserialize();
        if (service == null){
            service = new Service();
        }
        UserForm e = new UserForm(service);
    }

}
