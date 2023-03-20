package com.java.contest.application;

import com.java.contest.gui.UserForm;
import com.java.contest.service.nodelist.manager.ServiceImpl;
import com.java.contest.service.tools.Deserialization;

public class AppService {

    public static void main(String[] args){
        ServiceImpl serviceImpl = Deserialization.deserialize();
        if (serviceImpl == null){
            serviceImpl = new ServiceImpl();
        }
        UserForm e = new UserForm(serviceImpl);
    }

}
