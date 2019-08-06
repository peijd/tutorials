package com.ripjava.java.core.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalDateTimeToDateConverterTest {

    @Test
    public void test_convertToDateBySqlTimestamp() {
        LocalDateTime dateToConvert = LocalDateTime.of(2010, 11, 10, 8, 20);

        Date date = LocalDateTimeToDateConverter.convertToDateBySqlTimestamp(dateToConvert);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        assertEquals(2010, calendar.get(Calendar.YEAR));
        assertEquals(10, calendar.get(Calendar.MONTH));
        assertEquals(10, calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(8, calendar.get(Calendar.HOUR));
        assertEquals(20, calendar.get(Calendar.MINUTE));
        assertEquals(0, calendar.get(Calendar.SECOND));
    }

    @Test
    public void test_convertToDateByInstant() {
        LocalDateTime dateToConvert = LocalDateTime.of(2010, 11, 10, 8, 20);

        Date date = LocalDateTimeToDateConverter.convertToDateByInstant(dateToConvert);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        assertEquals(2010, calendar.get(Calendar.YEAR));
        assertEquals(10, calendar.get(Calendar.MONTH));
        assertEquals(10, calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(8, calendar.get(Calendar.HOUR));
        assertEquals(20, calendar.get(Calendar.MINUTE));
        assertEquals(0, calendar.get(Calendar.SECOND));
    }
}
