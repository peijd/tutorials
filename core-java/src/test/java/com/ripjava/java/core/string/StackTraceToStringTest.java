package com.ripjava.java.core.string;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

public class StackTraceToStringTest {

    @Test
    public void test_StackTraceToStringByStringWriter(){
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);

            System.out.println(sw.toString());
        }
    }

    @Test
    public void test_StackTraceToStringByExceptionUtils(){
        try {
            throw new IndexOutOfBoundsException();
        } catch (Exception e) {
            System.out.println(ExceptionUtils.getStackTrace(e));
        }
    }
}
