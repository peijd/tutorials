package com.ripjava.injectstaticvalue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InjectPropertyToStaticField {
    @Value("${name}")
    public String name;

    @Value("${name}")
    public static String NAME_NULL;

    public static String NAME_STATIC;

    @Value("${name}")
    public void setNameStatic(String name){
        InjectPropertyToStaticField.NAME_STATIC = name;
    }
}
