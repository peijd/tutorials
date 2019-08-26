package com.ripjava.configurable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class Account {
    @Autowired
    private Service service;


    public void callService(){
        service.service();
    }
}
