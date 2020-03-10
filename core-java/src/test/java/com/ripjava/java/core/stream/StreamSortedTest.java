package com.ripjava.java.core.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamSortedTest {

    @Test
    public void test_StreamSorted(){
        List<Book> list = new ArrayList<>();
        list.add(new Book("Apache", 200));
        list.add(new Book("Maven", 50));
        list.add(new Book("BBD ", 200));
        list.add(new Book("Gradle", 400));
        list.add(new Book("TDD ", 31));
        list.add(new Book("Spring", 150));
        list.add(new Book("Spring", 50));

        list.stream().sorted(Comparator.comparing(Book::getPages).thenComparing(Book::getName))
                .forEach(b -> System.out.println(b.getName()+ "," + b.getPages()));
    }

    @Test
    public void test_StreamSorted_MapByKey(){
        Map<Integer, Book> map  = new HashMap<>();
        map.put(15, new Book("Apache", 200));
        map.put(10, new Book("Maven", 50));
        map.put(30, new Book("Spring", 50));


        System.out.println("---Sort by Map Key---");
        // Sort by Map Key
        map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEach( e -> System.out.println("Key: " +e.getKey() + ", value: (" + e.getValue() + ")"));
        System.out.println("---Sort by Map Value---");
        // Sort by Map Value
        map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEach( e -> System.out.println("Key: " +((Map.Entry<Integer, Book>)e).getKey() + ", value: (" + ((Map.Entry<Integer, Book>)e).getValue() + ")"));
    }

}
