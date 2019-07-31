package com.ripjava.java.core.date;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DateWithoutTimeTest {

    private static final long MILLISECONDS_PER_DAY = 24 * 60 * 60 * 1000;

    @Test
    public void test_DateWithoutTimeUsingCalendar() {

        Date dateWithoutTime = DateWithoutTime.getDateWithoutTimeUsingCalendar();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateWithoutTime);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        calendar.setTimeInMillis(dateWithoutTime.getTime() + MILLISECONDS_PER_DAY - 1);
        assertEquals(day, calendar.get(Calendar.DAY_OF_MONTH));

        calendar.setTimeInMillis(dateWithoutTime.getTime() + MILLISECONDS_PER_DAY);

        assertNotEquals(day, calendar.get(Calendar.DAY_OF_MONTH));
    }

    @Test
    public void test_DateWithoutTimeUsingFormat() throws ParseException {

        Date dateWithoutTime = DateWithoutTime.getDateWithoutTimeUsingFormat();
    System.out.println(dateWithoutTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateWithoutTime);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        calendar.setTimeInMillis(dateWithoutTime.getTime() + MILLISECONDS_PER_DAY - 1);
        assertEquals(day, calendar.get(Calendar.DAY_OF_MONTH));

        calendar.setTimeInMillis(dateWithoutTime.getTime() + MILLISECONDS_PER_DAY);

        assertNotEquals(day, calendar.get(Calendar.DAY_OF_MONTH));
    }

    @Test
    public void test_LocalDate() {
        LocalDate localDate = DateWithoutTime.getLocalDate();
System.out.println(localDate);
        long millisLocalDate = localDate
                .atStartOfDay()
                .toInstant(OffsetDateTime
                        .now()
                        .getOffset())
                .toEpochMilli();

        Calendar calendar = Calendar.getInstance();

        calendar.setTimeInMillis(
                millisLocalDate + MILLISECONDS_PER_DAY - 1);

        assertEquals(
                localDate.getDayOfMonth(),
                calendar.get(Calendar.DAY_OF_MONTH));

        calendar.setTimeInMillis(millisLocalDate + MILLISECONDS_PER_DAY);

        assertNotEquals(
                localDate.getDayOfMonth(),
                calendar.get(Calendar.DAY_OF_MONTH));
    }

}
