package com.ripjava.lazy;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class City {

    public City() {
        System.out.println("City bean initialized");
    }

    public void test(){
        System.out.println("test");
    }
}
