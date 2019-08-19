package com.ripjava.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FooService {

    @Autowired
//    @FormatterType("Foo")
    private Formatter fooFormatter;

    //    @Autowired
//    public void setFooFormatter(FooFormatter fooFormatter) {
//        this.fooFormatter = fooFormatter;
//    }
    public String doStuff() {
        return fooFormatter.format();
    }

}
