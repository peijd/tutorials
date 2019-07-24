package com.ripjava.java.core.date;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemporalAdjusterTest {

    @Test
    public void test_AdjustNextSunday() {
        LocalDate localDate = LocalDate.of(2017, 9, 16);
        LocalDate nextSunday = localDate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));

        String expected = "2017-09-17";

        assertEquals(expected, nextSunday.toString());
    }

    @Test
    public void test_AdjustLastDayOfMonth () {
        LocalDate localDate = LocalDate.of(2017, 9, 16);
        LocalDate lastDayOfMonth = localDate.with(TemporalAdjusters.lastDayOfMonth());

        String expected = "2017-09-30";

        assertEquals(expected, lastDayOfMonth.toString());
    }

    @Test
    public void test_AdjustFourteenDaysAfterDate() {
        LocalDate localDate = LocalDate.of(2017, 9, 16);
        TemporalAdjuster temporalAdjuster = t -> t.plus(Period.ofDays(14));
        LocalDate result = localDate.with(temporalAdjuster);

        String fourteenDaysAfterDate = "2017-09-30";

        assertEquals(fourteenDaysAfterDate, result.toString());
    }

    static TemporalAdjuster NEXT_WORKING_DAY = TemporalAdjusters.ofDateAdjuster(date -> {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int daysToAdd;
        if (dayOfWeek == DayOfWeek.FRIDAY)
            daysToAdd = 3;
        else if (dayOfWeek == DayOfWeek.SATURDAY)
            daysToAdd = 2;
        else
            daysToAdd = 1;
        return date.plusDays(daysToAdd);
    });

    @Test
    public void test_AdjustNextWorkingDay() {
        LocalDate localDate = LocalDate.of(2017, 9, 16);
        TemporalAdjuster temporalAdjuster = NEXT_WORKING_DAY;
        LocalDate date = localDate.with(temporalAdjuster);

        assertEquals("2017-09-18", date.toString());
    }

    @Test
    public void test_AdjustAndImplementInterfaceForNextWorkingDay() {
        LocalDate localDate = LocalDate.of(2017, 9, 16);
        CustomTemporalAdjuster temporalAdjuster = new CustomTemporalAdjuster();
        LocalDate nextWorkingDay = localDate.with(temporalAdjuster);

        assertEquals("2017-09-18", nextWorkingDay.toString());
    }
}
