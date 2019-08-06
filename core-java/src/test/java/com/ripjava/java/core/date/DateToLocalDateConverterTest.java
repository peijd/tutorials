package com.ripjava.java.core.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateToLocalDateConverterTest {
    @Test
    public void test_convertToLocalDateByDate() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, 10, 10);
        Date dateToConvert = calendar.getTime();

        LocalDate localDate = DateToLocalDateConverter.convertToLocalDateByDate(dateToConvert);

        assertEquals(2010, localDate.get(ChronoField.YEAR));
        assertEquals(11, localDate.get(ChronoField.MONTH_OF_YEAR));
        assertEquals(10, localDate.get(ChronoField.DAY_OF_MONTH));
    }

    @Test
    public void test_convertToLocalDateByMilli() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, 10, 10);
        Date dateToConvert = calendar.getTime();

        LocalDate localDate = DateToLocalDateConverter.convertToLocalDateByMilli(dateToConvert);

        assertEquals(2010, localDate.get(ChronoField.YEAR));
        assertEquals(11, localDate.get(ChronoField.MONTH_OF_YEAR));
        assertEquals(10, localDate.get(ChronoField.DAY_OF_MONTH));
    }

    @Test
    public void test_convertToLocalDateFromSqlDate() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, 10, 10);
        Date dateToConvert = calendar.getTime();

        LocalDate localDate = DateToLocalDateConverter.convertToLocalDateFromSqlDate(dateToConvert);

        assertEquals(2010, localDate.get(ChronoField.YEAR));
        assertEquals(11, localDate.get(ChronoField.MONTH_OF_YEAR));
        assertEquals(10, localDate.get(ChronoField.DAY_OF_MONTH));
    }

    @Test
    public void test_convertToLocalDate() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, 10, 10);
        Date dateToConvert = calendar.getTime();

        LocalDate localDateTime = DateToLocalDateConverter.convertToLocalDate(dateToConvert);

        assertEquals(2010, localDateTime.get(ChronoField.YEAR));
        assertEquals(11, localDateTime.get(ChronoField.MONTH_OF_YEAR));
        assertEquals(10, localDateTime.get(ChronoField.DAY_OF_MONTH));
    }
}
