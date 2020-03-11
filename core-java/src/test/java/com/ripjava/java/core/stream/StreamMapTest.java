package com.ripjava.java.core.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMapTest {

    @Test
    public void test_StreamMap(){
        List<String> listOfStrings = Arrays.asList("1", "2", "3", "4", "5");

        List<Integer> listOfIntegers = listOfStrings.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        System.out.println(listOfIntegers);
    }

    @Test
    public void test_MapToList(){
        Map<String, Integer> map  = new HashMap<>();
        map.put("Apache", 200);
        map.put("Maven", 50);
        map.put("Spring", 150);

        List<Book> list = map.entrySet().stream().sorted(Comparator.comparing(e -> e.getKey()))
                .map(e -> new Book(e.getKey(), e.getValue()))
                .collect(Collectors.toList());

        System.out.println(list);
    }

    @Test
    public void test_MapToAntherObject(){
        List<Book> list = new ArrayList<>();
        list.add(new Book("Apache", 200));
        list.add(new Book("Maven", 50));
        list.add(new Book("BBD ", 200));
        list.add(new Book("Gradle", 400));
        list.add(new Book("TDD ", 31));
        list.add(new Book("Spring", 150));
        list.add(new Book("Spring", 50));

        List<NewBook> books = list.stream().filter(b -> b.getPages() > 100)
                .map(b -> new NewBook(b.getName(), b.getPages(), b.getPages() / 10))
                .collect(Collectors.toList());
        System.out.println(books);
    }

    @Test
    public void test_MapToInt(){
        List<Book> list = new ArrayList<>();
        list.add(new Book("Apache", 200));
        list.add(new Book("Maven", 50));
        list.add(new Book("BBD ", 200));
        list.add(new Book("Gradle", 400));
        list.add(new Book("TDD ", 31));
        list.add(new Book("Spring", 150));
        list.add(new Book("Spring", 50));

        List<Integer> ints = list.stream().mapToInt(b -> b.getPages()).boxed()
                .collect(Collectors.toList());;

        System.out.println(ints);
    }
}
