package com.ripjava.java.core.function;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionInterfaceTest {


    @Test
    public void testCompose(){
        Function<Integer, String> intToString = integer -> integer.toString();
        Function<String, String> quote = s -> "'" + s + "'";

        Function<Integer, String> quoteIntToString = quote.compose(intToString);

        assertEquals("'5'", quoteIntToString.apply(5));
    }
}
