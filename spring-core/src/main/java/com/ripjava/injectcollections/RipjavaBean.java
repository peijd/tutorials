package com.ripjava.injectcollections;

public class RipjavaBean {
    private String name;

    public RipjavaBean(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RipjavaBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
