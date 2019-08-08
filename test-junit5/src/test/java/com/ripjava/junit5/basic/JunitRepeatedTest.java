package com.ripjava.junit5.basic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JunitRepeatedTest {

    @BeforeEach
    void beforeEachTest() {
        System.out.println("=====================");
        System.out.println("Before Each Test");
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("After Each Test");
        System.out.println("=====================");
    }

    @RepeatedTest(3)
    void repeatedTest(TestInfo testInfo) {
        System.out.println("重复执行测试");
        assertEquals(2, Math.addExact(1, 1), "1 + 1 =  2");
    }

    @RepeatedTest(value = 3, name = RepeatedTest.LONG_DISPLAY_NAME)
    void repeatedTestWithLongName() {
        System.out.println("显示完整的的方法名");

        assertEquals(2, Math.addExact(1, 1), "1 + 1 = 2");
    }

    @RepeatedTest(value = 3, name = RepeatedTest.SHORT_DISPLAY_NAME)
    void repeatedTestWithShortName() {
        System.out.println("忽略方法名");
        assertEquals(2, Math.addExact(1, 1), "1 + 1 = 2");
    }

    @RepeatedTest(value = 3, name = "自定的测试名字 {currentRepetition}/{totalRepetitions}")
    void repeatedTestWithCustomDisplayName(TestInfo testInfo) {
        assertEquals(2, Math.addExact(1, 1), "1 + 1 = 2");
    }

    @RepeatedTest(3)
    void repeatedTestWithRepetitionInfo(RepetitionInfo repetitionInfo) {
        System.out.println("当前的次数 #" + repetitionInfo.getCurrentRepetition());

        assertEquals(3, repetitionInfo.getTotalRepetitions());
    }
}
