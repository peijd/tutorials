package com.ripjava.java.core.stream;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamFlatMapTest {

    @Test
    public void test_FlatMap(){
        Integer[][] data = {{1,2},{3,4},{5,6},{7,8,9}};
        Arrays.stream(data)
                .flatMap(row -> Arrays.stream(row))
                .filter(num -> num%2 == 0).
                forEach(System.out::println);
    }

    @Test
    public void test_FlatMapOrder(){
        List<Order> orders = Arrays.asList(
                new Order(Arrays.asList(new Item("AAA", 10),
                        new Item("BBB", 10),
                        new Item("CCC", 10)
                        )),
                new Order(Arrays.asList(new Item("DDD", 10),
                    new Item("EEE", 10),
                    new Item("FFF", 10)
                )),
                new Order(Arrays.asList(new Item("GGG", 10),
                        new Item("HHH", 10),
                        new Item("III", 10)
                        ))
        );
        orders.stream()
            .flatMap(order ->  order.getItems().stream())
            .forEach(System.out::println);
    }

    @Test
    public void test_FlatMapFiles(){
        Stream<String> lines = null;
        try {
            lines = Files.lines(Paths.get("src/test/resources/FlatMapTest.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        lines.flatMap(line -> Stream.of(line.split(" +")))
                .forEach(System.out::println);
    }
}
