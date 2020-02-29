package com.ripjava.java.core.stream;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPeekTest {

    @Test
    public void test_Stream_peek(){
        Stream<String> nameStream = Stream.of("a", "b", "c");
        // nameStream.peek(System.out::println);
        // nameStream.forEach(System.out::println);

        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());


    }
    @Test
    public void test_Stream_peek_state(){
        Stream<User> userStream = Stream.of(new User("aa"), new User("bb"), new User("cc"));
        userStream.peek(u -> u.setName(u.getName().toUpperCase()))
                .forEach(System.out::println);
    }

}
