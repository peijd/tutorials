package com.ripjava.java.core.date;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormattedDateMatcherTest {

    @Test
    public void test_FormattedDateMatcher_Length() {
        DateMatcher matcher = new FormattedDateMatcher("^\\d{4}-\\d{2}-\\d{2}$");
        assertTrue(matcher.matches("2017-12-31"));
        assertTrue(matcher.matches("2018-01-01"));
        assertTrue(matcher.matches("0000-00-00"));
        assertTrue(matcher.matches("1029-99-72"));

        assertFalse(matcher.matches("2018-01"));
        assertFalse(matcher.matches("2018-01-01-01"));
        assertFalse(matcher.matches("2018-01-XX"));
        assertFalse(matcher.matches(" 2018-01-01"));
        assertFalse(matcher.matches("2018-01-01 "));
        assertFalse(matcher.matches("2018/01/01"));
    }

    @Test
    public void test_FormattedDateMatcher_YEAR() {
        DateMatcher matcher = new FormattedDateMatcher("^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$");
        assertTrue(matcher.matches("2017-12-31"));
        assertTrue(matcher.matches("2018-01-01"));
        assertTrue(matcher.matches("1900-01-01"));
        assertTrue(matcher.matches("2205-02-31"));
        assertTrue(matcher.matches("2999-12-31"));

        assertFalse(matcher.matches("0000-00-00"));
        assertFalse(matcher.matches("1029-99-72"));
        assertFalse(matcher.matches("1899-12-31"));
        assertFalse(matcher.matches("2019-05-35"));
        assertFalse(matcher.matches("2018-13-05"));
        assertFalse(matcher.matches("3000-01-01"));
    }
    @Test
    public void test_FormattedDateMatcher_LeapYear() {
        DateMatcher matcher = new FormattedDateMatcher("^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$");
        assertTrue(matcher.matches("2020-02-29"));
        assertTrue(matcher.matches("2024-02-29"));
        assertTrue(matcher.matches("2400-02-29"));

        assertFalse(matcher.matches("2019-02-29"));
        assertFalse(matcher.matches("2100-02-29"));
        assertFalse(matcher.matches("3200-02-29"));
        assertFalse(matcher.matches("2020/02/29"));
    }

    @Test
    public void test_FormattedDateMatcher_February() {
        DateMatcher matcher = new FormattedDateMatcher("^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$");
        assertTrue(matcher.matches("2018-02-01"));
        assertTrue(matcher.matches("2019-02-13"));
        assertTrue(matcher.matches("2020-02-25"));

        assertFalse(matcher.matches("2000-02-30"));
        assertFalse(matcher.matches("2400-02-62"));
        assertFalse(matcher.matches("2018/02/28"));
    }
    @Test
    public void test_FormattedDateMatcher_31DaysMonth() {
        DateMatcher matcher = new FormattedDateMatcher("^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$");

        assertTrue(matcher.matches("2018-01-31"));
        assertTrue(matcher.matches("2021-07-31"));
        assertTrue(matcher.matches("2022-08-31"));

        assertFalse(matcher.matches("2018-01-32"));
        assertFalse(matcher.matches("2019-03-64"));
        assertFalse(matcher.matches("2018-10-32"));
    }

    @Test
    public void test_FormattedDateMatcher_30DaysMonth() {
        DateMatcher matcher = new FormattedDateMatcher("^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$");

        assertTrue(matcher.matches("2018-04-30"));
        assertTrue(matcher.matches("2019-06-30"));
        assertTrue(matcher.matches("2020-09-30"));

        assertFalse(matcher.matches("2018-04-31"));
        assertFalse(matcher.matches("2019-06-31"));
        assertFalse(matcher.matches("2018/04/30"));
    }

}
