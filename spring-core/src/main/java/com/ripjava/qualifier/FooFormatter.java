package com.ripjava.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class FooFormatter implements Formatter {
    @Override
    public String format() {
        return "foo";
    }
}
