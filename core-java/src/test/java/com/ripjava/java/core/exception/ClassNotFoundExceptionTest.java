package com.ripjava.java.core.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class ClassNotFoundExceptionTest {

    @Test
    public void test_ClassNotFoundException() {
        assertThrows(java.lang.ClassNotFoundException.class, () -> {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        });
    }
}
