package com.ripjava.java.core.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class NoClassDefFoundErrorTest {


    @Test
    public void test_NoClassDefFoundError(){
        ClassWithInitErrors test;
        try {
            test = new ClassWithInitErrors();
        } catch (Throwable t) {
            System.out.println(t);
        }
        assertThrows(NoClassDefFoundError.class, () -> { new ClassWithInitErrors();});
    }
}
