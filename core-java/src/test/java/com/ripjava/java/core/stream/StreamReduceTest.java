package com.ripjava.java.core.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StreamReduceTest {

    @Test
    public void test_StreamReduceWithAccumulator(){
        int[] array = {1,2,3,4,5};
        Arrays.stream(array).reduce((x, y) -> x+y).ifPresent(s -> System.out.println(s));
        Arrays.stream(array).reduce(Integer::sum).ifPresent(s -> System.out.println(s));
        Arrays.stream(array).reduce(StreamReduceTest::addIntData).ifPresent(s -> System.out.println(s));
    }

    @Test
    public void test_StreamReduceWithAccumulatorAndIdentity(){
        int[] array = {1,2,3,4,5};
        int start = 100;
        int sum =  Arrays.stream(array).reduce(start, (x, y) -> x+y);
        System.out.println(sum);
        sum = Arrays.stream(array).reduce(start, Integer::sum);
        System.out.println(sum);
        sum =  Arrays.stream(array).reduce(start, StreamReduceTest::addIntData);
        System.out.println(sum);
    }

    @Test
    public void test_StreamReduceWithCombiner(){
        List<Integer> array = Arrays.asList(1,2,3,4,5);
        int start = 100;
        int sum =  array.parallelStream().reduce(start, (x, y) -> x + y, (p, q) -> p + q);
        System.out.println(sum);
        start = 0;
        int sum2 =  array.parallelStream().reduce(start, (x, y) -> x + y, (p, q) -> p + q);
        System.out.println(sum2);

    }



    public static int addIntData(int num1, int num2) {
        return num1 + num2;
    }

}
