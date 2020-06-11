package com.ripjava.beanfactory.getbean;

public class Dog implements Animal{
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
