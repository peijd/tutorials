package com.ripjava.java.core.date;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DurationTest {

    @Test
    public void test_Duration() {
        Instant start = Instant.parse("2019-07-25T09:53:30.00Z");
        Instant end = Instant.parse("2019-07-25T09:54:30.00Z");

        Duration duration = Duration.between(start, end);

        assertFalse(duration.isNegative());


        assertEquals(60, duration.getSeconds());
        assertEquals(1, duration.toMinutes());

        Duration fromDays = Duration.ofDays(1);
        assertEquals(86400, fromDays.getSeconds());

        Duration fromMinutes = Duration.ofMinutes(60);
        assertEquals(1, fromMinutes.toHours());

        assertEquals(120, duration.plusSeconds(60).getSeconds());
        assertEquals(30, duration.minusSeconds(30).getSeconds());

        assertEquals(120, duration.plus(60, ChronoUnit.SECONDS).getSeconds());
        assertEquals(30, duration.minus(30, ChronoUnit.SECONDS).getSeconds());

        // 20.345秒
        Duration fromChar1 = Duration.parse("PT20.345S");
        assertEquals(20, fromChar1.getSeconds());

        // 15分
        Duration fromChar2 = Duration.parse("PT15M");
        assertEquals(15, fromChar2.toMinutes());

        // 10小时
        Duration fromChar3 = Duration.parse("PT10H");
        assertEquals(10, fromChar3.toHours());

        // 2天
        Duration fromChar4 = Duration.parse("P2D");
        assertEquals(2, fromChar4.toDays());

        // 2天3小时4分
        Duration fromChar5 = Duration.parse("P2DT3H4M");
        assertEquals(2, fromChar5.toDays());
        assertEquals(2 * 24 + 3, fromChar5.toHours());
        assertEquals(51 * 60 + 4, fromChar5.toMinutes());

        // 负6小时和正3分
        Duration fromChar6 = Duration.parse("PT-6H3M");
        assertEquals(-6 * 60 * 60 + 3 * 60, fromChar6.getSeconds());

        // 负6小时和负3分
        Duration fromChar7 = Duration.parse("-PT6H3M");
        assertEquals(-6 * 60 * 60 - 3 * 60, fromChar7.getSeconds());

        // 正6小时和负3分
        Duration fromChar8 = Duration.parse("-PT-6H+3M");
        assertEquals(6 * 60 * 60 - 3 * 60, fromChar8.getSeconds());

        LocalTime start1 = LocalTime.of(1, 20, 25, 1024);
        LocalTime end1 = LocalTime.of(3, 22, 27, 1544);

        assertEquals(7322, Duration.between(start1, end1).getSeconds());
    }
}
