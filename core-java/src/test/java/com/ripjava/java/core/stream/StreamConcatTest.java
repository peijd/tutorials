package com.ripjava.java.core.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class StreamConcatTest {

    @Test
    public void test_concatStream(){
        Stream<String> s1 = Stream.of("1AA", "1BB", "1CC");
        Stream<String> s2 = Stream.of("2AA", "2BB", "2CC");
        Stream<String> s = Stream.concat(s1, s2);
        s.forEach(e->System.out.print(e+" "));
    }

    @Test
    public void test_concatList(){
        List<Book> list1 = new ArrayList<>();
        List<Book> list2 = new ArrayList<>();
        list1.add(new Book("Java", 200));
        list1.add(new Book("Spring", 300));
        list1.add(new Book("Junit ", 150));

        list2.add(new Book("Java", 200));
        list2.add(new Book("Spring MVC", 300));
        list2.add(new Book("Spring Cloud", 400));

        List<Book> list = Stream.concat(list1.stream(), list2.stream()).distinct().collect(Collectors.toList());
        list.forEach(b->System.out.println(b.getName()+", "+ b.getPages()));
    }

    @Test
    public void test_concatSet(){
        Set<Book> set1 = new HashSet<>();
        Set<Book> set2 = new HashSet<>();
        set1.add(new Book("Java", 200));
        set1.add(new Book("Spring", 300));
        set1.add(new Book("Junit", 150));

        set2.add(new Book("Java", 200));
        set2.add(new Book("Spring MVC", 300));
        set2.add(new Book("Spring Cloud", 400));
        Set<Book> set = Stream.concat(set1.stream(), set2.stream()).collect(Collectors.toSet());
        set.forEach(b->System.out.println(b.getName()+", "+ b.getPages()));
    }

    @Test
    public void test_concatArray(){
        Book[] bk1 = new Book[3];
        Book[] bk2 = new Book[3];

        bk1[0] = new Book("Java", 200);
        bk1[1] = new Book("Spring", 300);
        bk1[2] = new Book("Junit", 150);

        bk2[0] = new Book("Java", 200);
        bk2[1] = new Book("Spring MVC", 300);
        bk2[2] = new Book("Spring Cloud", 400);

        Book[] bks = (Book[]) Stream.concat(Stream.of(bk1), Stream.of(bk2)).distinct().toArray(b -> new Book[b]);
        for(Book b : bks) {
            System.out.println(b.getName()+", "+ b.getPages());
        }
    }

}
