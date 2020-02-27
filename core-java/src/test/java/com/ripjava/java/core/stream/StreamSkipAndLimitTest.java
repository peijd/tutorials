package com.ripjava.java.core.stream;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class StreamSkipAndLimitTest {


    @Test
    public void test_skip(){
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(i -> i % 2 == 0)
                .skip(2)
                .forEach(i -> System.out.print(i + " "));
    }


    @Test
    public void test_limit(){
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(i -> i % 2 == 0)
                .limit(2)
                .forEach(i -> System.out.print(i + " "));

        Stream.iterate(0, i -> i + 1)
                .filter(i -> i % 2 == 0)
                .limit(10)
                .forEach(i -> System.out.print(i + " "));
    }

    @Test
    public void test_skipAndLimit(){
        int pageSize = 10;
        int pageIndex = 5;
        Stream.iterate(0, i -> i + 1)
                .filter(i -> i % 2 == 0)
                .skip((pageIndex - 1) * pageSize)
                .limit(pageSize)
                .forEach(i -> System.out.print(i + " "));
    }


}
