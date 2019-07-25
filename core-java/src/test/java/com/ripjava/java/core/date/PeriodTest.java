package com.ripjava.java.core.date;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.Period;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PeriodTest {

    private static final Logger LOG = LoggerFactory.getLogger(PeriodTest.class);
    @Test
    public void test_Period() {
        LocalDate startDate = LocalDate.of(2017, 9, 16);
        LocalDate endDate = LocalDate.of(2019, 7, 25);

        Period period = Period.between(startDate, endDate);

        LOG.info(String.format("Years:%d months:%d days:%d", period.getYears(), period.getMonths(), period.getDays()));

        assertFalse(period.isNegative());


        Period fromUnits = Period.of(3, 10, 10);
        Period fromDays = Period.ofDays(50);
        Period fromMonths = Period.ofMonths(5);
        Period fromYears = Period.ofYears(10);
        Period fromWeeks = Period.ofWeeks(40);

        assertEquals(280, fromWeeks.getDays());

        Period fromCharYears = Period.parse("P2Y");
        assertEquals(2, fromCharYears.getYears());

        Period fromCharMonths = Period.parse("P3M");
        assertEquals(3, fromCharMonths.getMonths());

        Period fromCharWeeks = Period.parse("P4W");
        assertEquals(28, fromCharWeeks.getDays());

        Period fromCharDays = Period.parse("P5D");
        assertEquals(5, fromCharDays.getDays());

        Period fromCharof = Period.parse("P-1Y2M");
        assertEquals(-1, fromCharof.getYears());

        Period fromCharUnits = Period.parse("P2Y3M5D");
        assertEquals(5, fromCharUnits.getDays());

        assertEquals(59, period.plusDays(50).getDays());
        assertEquals(8, period.minusMonths(2).getMonths());

    }
}
