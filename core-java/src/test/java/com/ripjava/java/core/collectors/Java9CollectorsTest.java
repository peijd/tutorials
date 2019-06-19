package com.ripjava.java.core.collectors;

import org.apache.commons.collections4.MapUtils;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Java9CollectorsTest {

    @Test
    public void givenList_whenSatifyPredicate_thenMapValueWithOccurences() {
        List<Integer> numbers = List.of(1, 2, 2, 3, 5, 5);

        Map<Integer, Long> result = numbers.stream()
                .filter(val -> val > 3)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        assertEquals(1, result.size());

        MapUtils.debugPrint(System.out, "stream-filter", result);
        result = numbers.stream()
                .collect(Collectors.groupingBy(i -> i,
                        Collectors.filtering(val -> val > 3, Collectors.counting())));

        assertEquals(4, result.size());
        MapUtils.debugPrint(System.out, "Collectors-filtering", result);
    }

    @Test
    public void givenListOfBlogs_whenAuthorName_thenMapAuthorWithComments() {
        Blog blog1 = new Blog("1", "Nice", "Very Nice");
        Blog blog2 = new Blog("2", "Disappointing", "Ok", "Could be better");
        List<Blog> blogs = List.of(blog1, blog2);

        Map<String,  List<List<String>>> authorComments1 = blogs.stream()
                .collect(Collectors.groupingBy(Blog::getAuthorName,
                        Collectors.mapping(Blog::getComments, toList())));
        MapUtils.debugPrint(System.out, "Collectors-mapping", authorComments1);

        assertEquals(2, authorComments1.size());
        assertEquals(2, authorComments1.get("1").get(0).size());
        assertEquals(3, authorComments1.get("2").get(0).size());

        Map<String, List<String>> authorComments2 = blogs.stream()
                .collect(Collectors.groupingBy(Blog::getAuthorName,
                        Collectors.flatMapping(blog -> blog.getComments().stream(),
                                toList())));
        MapUtils.debugPrint(System.out, "Collectors-flatMapping", authorComments2);
        assertEquals(2, authorComments2.size());
        assertEquals(2, authorComments2.get("1").size());
        assertEquals(3, authorComments2.get("2").size());
    }
    @Test
    public void flatMappingVSmapping(){

        List<Integer> list = Stream.of(List.of(1, 2, 3, 4), List.of(5, 6, 7, 8))
                .collect(
                        Collectors.flatMapping(
                                l -> l.stream()
                                        .filter(i -> i % 2 == 0),
                                toList()
                        )
                );
        System.out.println(list);


    }

}
