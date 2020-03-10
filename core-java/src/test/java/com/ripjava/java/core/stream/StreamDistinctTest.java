package com.ripjava.java.core.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamDistinctTest {

    @Test
    public void test_Distinct(){
        List<String> list = Arrays.asList("AA", "BB", "CC", "BB", "CC", "AA", "AA");
        long l = list.stream().distinct().count();
        System.out.println("去重后流的元素个数:"+l);
        String output = list.stream().distinct().collect(Collectors.joining(","));
        System.out.println(output);
    }


    @Test
    public void test_DistinctObjectList(){
        List<Book> list = new ArrayList<>();
        list.add(new Book("Java", 200));
        list.add(new Book("Spring", 300));
        list.add(new Book("Junit ", 150));
        list.add(new Book("Spring", 300));
        list.add(new Book("Junit ", 150));
        list.add(new Book("Spring MVC", 200));

        long l = list.stream().distinct().count();
        System.out.println("去重后流的元素个数:"+l);
        list.stream().distinct().forEach(b -> System.out.println(b.getName()+ "," + b.getPages()));
    }
    static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
    @Test
    public void test_DistinctObjectListByProperty(){
        List<Book> list = new ArrayList<>();
        list.add(new Book("Java", 200));
        list.add(new Book("Java", 300));
        list.add(new Book("Spring", 300));
        list.add(new Book("Spring", 500));
        list.add(new Book("Junit ", 150));
        list.add(new Book("Spring", 300));
        list.add(new Book("Junit ", 150));
        list.add(new Book("Spring MVC", 200));

        list.stream().filter(distinctByKey(b -> b.getName()))
                .forEach(b -> System.out.println(b.getName()+ "," + b.getPages()));
    }
}
