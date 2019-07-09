package com.ripjava.java.core.serialization;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 105907155265255418L;
    static String country = "CHN";
    private int age;
    private String name;
    transient int height;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static String getCountry() {
        return country;
    }

    public static void setCountry(String country) {
        Person.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
