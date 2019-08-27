package com.ripjava.lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("studentBean")
public class Student {

    private String id;

    @Lookup
    public SchoolNotification getNotification(String name) {
        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}