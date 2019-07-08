package com.ripjava.java.core.doublebrace;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toSet;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DoubleBraceTest {

    @Test
    public void test_InitializeSetWithoutDoubleBraces() {
        final Set<String> countries = new HashSet<>();
        countries.add("CHN");
        countries.add("JPN");
        countries.add("USA");
        assertTrue(countries.contains("CHN"));
    }

    @Test
    public void test_InitializeSetWithDoubleBraces() {
        Set<String> countries = new HashSet<String>() {
            {
                add("CHN");
                add("JPN");
                add("USA");
            }
        };
        assertTrue(countries.contains("CHN"));
    }

    @Test
    public void test_InitializeWithStream() {
        Set<String> countries = Stream.of("CHN", "JPN", "USA")
                .collect(collectingAndThen(toSet(), Collections::unmodifiableSet));

        assertTrue(countries.contains("CHN"));
    }

    @Test
    public void test_InitializeWithCollectionFactoryMethods() {
        Set<String> countries = Set.of("CHN", "JPN", "USA");

        assertTrue(countries.contains("CHN"));
    }


}
