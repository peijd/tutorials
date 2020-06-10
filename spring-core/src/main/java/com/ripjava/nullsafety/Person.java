package com.ripjava.nullsafety;

import org.springframework.lang.NonNull;

public class Person {

    @NonNull
    private String fullName;

    void setFullName(String fullName) {
        if (fullName != null && fullName.isEmpty()) {
            fullName = null;
        }
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
