package com.ripjava.java.core.function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UseFooTest {

    private UseFoo  useFoo;

    @BeforeEach
    public void beforeAll(){
        useFoo = new UseFoo();
    }

    @Test
    public void testFunctionInterface(){
        Foo foo = parameter -> parameter + " from lambda";
        String result = useFoo.add("Message ", foo);
        assertEquals("Message  from lambda", result);
    }

    @Test
    public void testFunctionInterface2(){
        Function<String, String> fn = parameter -> parameter + " from lambda";
        String result = useFoo.add2("Message ", fn);
        assertEquals("Message  from lambda", result);
    }

    @Test
    public void testscopeExperiment(){
        System.out.println(useFoo.scopeExperiment());
    }
}
