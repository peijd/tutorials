package com.ripjava.java.core.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalDateToDateConverterTest {
    @Test
    public void test_convertToDateToSqlDate() {
        LocalDate dateToConvert = LocalDate.of(2010, 11, 10);

        Date date = LocalDateToDateConverter.convertToDateToSqlDate(dateToConvert);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        assertEquals(2010, calendar.get(Calendar.YEAR));
        assertEquals(10, calendar.get(Calendar.MONTH));
        assertEquals(10, calendar.get(Calendar.DAY_OF_MONTH));
    }

    @Test
    public void test_convertToDateByInstant() {
        LocalDate dateToConvert = LocalDate.of(2010, 11, 10);

        Date date = LocalDateToDateConverter.convertToDateByInstant(dateToConvert);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        assertEquals(2010, calendar.get(Calendar.YEAR));
        assertEquals(10, calendar.get(Calendar.MONTH));
        assertEquals(10, calendar.get(Calendar.DAY_OF_MONTH));
    }
}
