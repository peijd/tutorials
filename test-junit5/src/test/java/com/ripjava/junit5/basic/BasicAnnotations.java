package com.ripjava.junit5.basic;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class BasicAnnotations {

    private static final Logger log = Logger.getLogger(BasicAnnotations.class.getName());

    @BeforeAll
    static void setup() {
        log.info("@BeforeAll - 只执行一次，在所有测试开始之前");
    }

    @BeforeEach
    void init() {
        log.info("@BeforeEach - 执行多次，每次执行测试之前都要执行");
    }

    @DisplayName("这是一个什么测试")
    @Test
    void tes_Xxx() {
        log.info("Success");
    }

    @Test
    @Disabled("比如这个测试方法还没有实现或过时")
    void test_Something() {
    }

    @Test
    void test_lambdaExpressions() {
        assertTrue(Stream.of(1, 2, 3)
                .mapToInt(i -> i)
                .sum() > 5, () -> "和应该大于5");
    }

    @Test
    void test_groupAssertions() {
        int[] numbers = {0, 1, 2, 3, 4};

        assertAll("numbers",
                () -> assertEquals(numbers[0], 0),
                () -> assertEquals(numbers[3], 3),
                () -> assertEquals(numbers[4], 4));
    }

    @Test
    void test_trueAssumption() {
        assumeTrue(5 > 1);
        assertEquals(5 + 2, 7);
    }

    @Test
    void test_falseAssumption() {
        assumeFalse(5 < 1);
        assertEquals(5 + 2, 7);
    }

    @Test
    void test_assumptionThat() {
        String someString = "Just a string";
        assumingThat(
                someString.equals("Just a string"),
                () -> assertEquals(2 + 2, 4)
        );
    }

    @Test
    void shouldThrowException() {
        Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
            throw new UnsupportedOperationException("Not supported");
        });
        assertEquals(exception.getMessage(), "Not supported");
    }

    @Test
    void assertThrowsException() {
        String str = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Integer.valueOf(str);
        });
    }

    @TestFactory
    public Stream<DynamicTest> translateDynamicTestsFromStream() {
        List<String> in = new ArrayList<>(Arrays.asList("Hello", "Yes", "No"));
        List<String> out = new ArrayList<>(Arrays.asList("こにちは", "はい", "いいえ"));
        return in.stream()
                .map(word ->
                        DynamicTest.dynamicTest("Test translate " + word, () -> {
                            int id = in.indexOf(word);
                            assertEquals(out.get(id), translate(word));
                        })
                );
    }

    private String translate(String word) {
        if ("Hello".equalsIgnoreCase(word)) {
            return "こにちは";
        } else if ("Yes".equalsIgnoreCase(word)) {
            return "はい";
        } else if ("No".equalsIgnoreCase(word)) {
            return "いいえ";
        }
        return "Error";
    }

    @AfterEach
    void tearDown() {
        log.info("@AfterEach - 执行多次，每次执行测试之后都要执行");
    }

    @AfterAll
    static void done() {
        log.info("@AfterAll - 只执行一次，在所有测试结束之后");
    }

}
