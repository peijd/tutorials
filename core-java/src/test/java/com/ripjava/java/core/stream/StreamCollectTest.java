package com.ripjava.java.core.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectTest {

    @Test
    public void test_StreamCollect(){
        List<String> list = Arrays.asList("A", "B", "C");
        String parallelResult = list.parallelStream().collect(StringBuilder::new,
                (response, element) -> response.append(" ").append(element),
                (response1, response2) -> response1.append(",").append(response2.toString()))
                .toString();
        String result = list.stream().collect(StringBuilder::new,
                (response, element) -> response.append(" ").append(element),
                (response1, response2) -> response1.append(",").append(response2.toString()))
                .toString();
        System.out.println("Result: " + result);
        System.out.println("Parallel Result: " + parallelResult);
    }

    @Test
    public  void  test_StreamCollect_summarizingInt(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        IntSummaryStatistics stats = list.stream()
                .collect(Collectors.summarizingInt(i -> i));
        System.out.println("Sum:"+stats.getSum());
    }


    @Test
    public  void  test_StreamCollect_joining(){
        List<String> list = Arrays.asList("A","B","C","D");
        String result=  list.stream().collect(Collectors.joining(", "));
        System.out.println("Joining Result: "+ result);
    }

    @Test
    public  void  test_StreamCollect_averagingInt(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        Double result = list.stream().collect(Collectors.averagingInt(v-> v ));
        System.out.println("Average: "+result);
    }

    @Test
    public  void  test_StreamCollect_counting(){
        List<Integer> list = Arrays.asList(1,2,3,4);
        long result=  list.stream().collect(Collectors.counting());
        System.out.println("Count: "+ result);
    }
    @Test
    public  void  test_StreamCollect_toList(){
        String[] strArray = {"AA", "BB", "CC"};
        List<String> list = Arrays.stream(strArray).collect(Collectors.toList());
        list.forEach(s->System.out.println(s));
    }
    @Test
    public  void  test_StreamCollect_toMap(){
        List<Person> list = new ArrayList<>();
        list.add(new Person(100, "A"));
        list.add(new Person(200, "B"));
        list.add(new Person(300, "C"));
        Map<Integer, String> map = list.stream()
                .collect(Collectors.toMap(Person::getId, Person::getName));
        map.forEach((x, y) -> System.out.println("Key: " + x +", value: "+ y));
    }

    class Person {
        private Integer id;
        private String name;
        public Person(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
        public Integer getId() {
            return id;
        }
        public String getName() {
            return name;
        }
    }
}
