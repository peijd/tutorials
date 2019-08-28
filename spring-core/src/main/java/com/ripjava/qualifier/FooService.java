package com.ripjava.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FooService {
    @Autowired
//    @Qualifier("fooFormatter")
    private Formatter fooFormatter;

    public void format(){
        System.out.printf(fooFormatter.format());
    }
}
