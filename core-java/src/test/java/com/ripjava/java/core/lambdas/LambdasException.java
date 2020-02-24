package com.ripjava.java.core.lambdas;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdasException {

    @Test
    public void test_ArithmeticException(){
        List<Integer> integers = Arrays.asList(3, 9, 7, 6, 10, 20, 0);
//        integers.forEach(i -> System.out.println(50 / i));
        integers.forEach(i -> {
            try {
                System.out.println(50 / i);
            } catch (ArithmeticException e) {
                System.err.println(
                        "Arithmetic Exception find  : " + e.getMessage());
            }
        });
    }

    @Test
    public void test_lambdaWrapper(){
        List<Integer> integers = Arrays.asList(3, 9, 7, 6, 10, 20, 0);
        integers.forEach(lambdaWrapper(i -> System.out.println(50 / i)));
    }


    @Test
    public void test_catchException() throws IOException {
        List<Integer> integers = Arrays.asList(3, 9, 7, 6, 10, 20, 0);
//        integers.forEach(i -> writeToFile(i));

//        integers.forEach(i -> {
//            try {
//                writeToFile(i);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });
        integers.forEach(throwingConsumerWrapper(i -> writeToFile(i)));
    }

    @Test
    public void test_genericsLambdaWrapper(){
        List<Integer> integers = Arrays.asList(3, 9, 7, 6, 10, 20, 0);
        integers.forEach(
                genericsLambdaWrapper(
                        i -> System.out.println(50 / i),
                        ArithmeticException.class));
    }

    public void test_handlingConsumerWrapper(){
        List<Integer> integers = Arrays.asList(3, 9, 7, 6, 10, 20, 0);
        integers.forEach(handlingConsumerWrapper(
                i -> writeToFile(i), IOException.class));
    }

    static Consumer<Integer> lambdaWrapper(Consumer<Integer> consumer) {
        return i -> {
            try {
                consumer.accept(i);
            } catch (ArithmeticException e) {
                System.err.println(
                        "Arithmetic Exception occured : " + e.getMessage());
            }
        };
    }

    static <T, E extends Exception> Consumer<T>
    genericsLambdaWrapper(Consumer<T> consumer, Class<E> clazz) {

        return i -> {
            try {
                consumer.accept(i);
            } catch (Exception ex) {
                try {
                    E exCast = clazz.cast(ex);
                    System.err.println(
                            "Exception occured : " + exCast.getMessage());
                } catch (ClassCastException ccEx) {
                    throw ex;
                }
            }
        };
    }

    static void writeToFile(Integer integer) throws IOException {
        // 写入文件的异常
    }

    static <T> Consumer<T> throwingConsumerWrapper(
            ThrowingConsumer<T, Exception> throwingConsumer) {

        return i -> {
            try {
                throwingConsumer.accept(i);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    static <T, E extends Exception> Consumer<T> handlingConsumerWrapper(
            ThrowingConsumer<T, E> throwingConsumer, Class<E> exceptionClass) {

        return i -> {
            try {
                throwingConsumer.accept(i);
            } catch (Exception ex) {
                try {
                    E exCast = exceptionClass.cast(ex);
                    System.err.println(
                            "Exception occured : " + exCast.getMessage());
                } catch (ClassCastException ccEx) {
                    throw new RuntimeException(ex);
                }
            }
        };
    }
}
