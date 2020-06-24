package com.ripjava.springcore.shutdownhook.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class TestBean {

    @PreDestroy
    public void destroyBean(){
        System.out.println("TestBean 已销毁 ...");
    }
}
