package com.ripjava.autowired;

import org.springframework.stereotype.Component;
//@FormatterType("Bar")
@Component
public class BarFormatter implements Formatter {
    @Override
    public String format() {
        return "bar";
    }
}
