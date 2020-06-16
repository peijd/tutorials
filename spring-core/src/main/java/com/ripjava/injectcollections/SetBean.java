package com.ripjava.injectcollections;

import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class SetBean {

    private Set<String> nameSet;

    public SetBean(Set<String> strings) {
        this.nameSet = strings;
    }

    public void printNameSet() {
        System.out.println(nameSet);
    }
}
