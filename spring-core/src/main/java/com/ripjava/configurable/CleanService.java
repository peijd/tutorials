package com.ripjava.configurable;

import org.springframework.stereotype.Component;

@Component
public class CleanService implements  Service{
    public void service(){
        System.out.println("clean room");
    }
}
