package com.ripjava.java.core.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateToLocalDateTimeConverterTest {

    @Test
    public void Test_convertToLocalDateTimeByInstant() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, 10, 10, 8, 20);
        Date dateToConvert = calendar.getTime();

        LocalDateTime localDateTime = DateToLocalDateTimeConverter.convertToLocalDateTimeByInstant(dateToConvert);

        assertEquals(2010, localDateTime.get(ChronoField.YEAR));
        assertEquals(11, localDateTime.get(ChronoField.MONTH_OF_YEAR));
        assertEquals(10, localDateTime.get(ChronoField.DAY_OF_MONTH));
        assertEquals(8, localDateTime.get(ChronoField.HOUR_OF_DAY));
        assertEquals(20, localDateTime.get(ChronoField.MINUTE_OF_HOUR));
    }

    @Test
    public void test_convertToLocalDateTimeFromSqlTimestamp() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, 10, 10, 8, 20);
        Date dateToConvert = calendar.getTime();

        LocalDateTime localDateTime = DateToLocalDateTimeConverter.convertToLocalDateTimeFromSqlTimestamp(dateToConvert);

        assertEquals(2010, localDateTime.get(ChronoField.YEAR));
        assertEquals(11, localDateTime.get(ChronoField.MONTH_OF_YEAR));
        assertEquals(10, localDateTime.get(ChronoField.DAY_OF_MONTH));
        assertEquals(8, localDateTime.get(ChronoField.HOUR_OF_DAY));
        assertEquals(20, localDateTime.get(ChronoField.MINUTE_OF_HOUR));
    }

    @Test
    public void test_convertToLocalDateTimeByMilli() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, 10, 10, 8, 20);
        Date dateToConvert = calendar.getTime();

        LocalDateTime localDateTime = DateToLocalDateTimeConverter.convertToLocalDateTimeByMilli(dateToConvert);

        assertEquals(2010, localDateTime.get(ChronoField.YEAR));
        assertEquals(11, localDateTime.get(ChronoField.MONTH_OF_YEAR));
        assertEquals(10, localDateTime.get(ChronoField.DAY_OF_MONTH));
        assertEquals(8, localDateTime.get(ChronoField.HOUR_OF_DAY));
        assertEquals(20, localDateTime.get(ChronoField.MINUTE_OF_HOUR));
    }

    @Test
    public void test_convertToLocalDateTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, 10, 10, 8, 20);
        Date dateToConvert = calendar.getTime();

        LocalDateTime localDateTime = DateToLocalDateTimeConverter.convertToLocalDateTime(dateToConvert);

        assertEquals(2010, localDateTime.get(ChronoField.YEAR));
        assertEquals(11, localDateTime.get(ChronoField.MONTH_OF_YEAR));
        assertEquals(10, localDateTime.get(ChronoField.DAY_OF_MONTH));
        assertEquals(8, localDateTime.get(ChronoField.HOUR_OF_DAY));
        assertEquals(20, localDateTime.get(ChronoField.MINUTE_OF_HOUR));
    }
}
