package com.ripjava.java.core.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatesBetweenTwoDateTest {

    @Test
    public void test_getDatesBetweenUsingJava7() {
        Date startDate = Calendar.getInstance().getTime();

        Calendar endCalendar = Calendar.getInstance();

        endCalendar.add(Calendar.DATE, 2);
        Date endDate = endCalendar.getTime();

        List<Date> dates = DatesBetweenTwoDate.getDatesBetweenUsingJava7(startDate, endDate);
        assertEquals(dates.size(), 2);

        Calendar calendar = Calendar.getInstance();
        Date date1 = calendar.getTime();

        // 我们这里为了简单，就直接使用过期的API了
        assertEquals(dates.get(0).getDay(), date1.getDay());
        assertEquals(dates.get(0).getMonth(), date1.getMonth());
        assertEquals(dates.get(0).getYear(), date1.getYear());

        calendar.add(Calendar.DATE, 1);
        Date date2 = calendar.getTime();
        assertEquals(dates.get(1).getDay(), date2.getDay());
        assertEquals(dates.get(1).getMonth(), date2.getMonth());
        assertEquals(dates.get(1).getYear(), date2.getYear());
    }


    @Test
    public void test_getDatesBetweenUsingJava8() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays(2);

        List<LocalDate> dates = DatesBetweenTwoDate.getDatesBetweenUsingJava8(startDate, endDate);
        assertEquals(dates.size(), 2);
        assertEquals(dates.get(0), LocalDate.now());
        assertEquals(dates.get(1), LocalDate.now().plusDays(1));
    }

    @Test
    public void test_getDatesBetweenUsingJava9() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays(2);

        List<LocalDate> dates = DatesBetweenTwoDate.getDatesBetweenUsingJava9(startDate, endDate);
        assertEquals(dates.size(), 2);
        assertEquals(dates.get(0), LocalDate.now());
        assertEquals(dates.get(1), LocalDate.now().plusDays(1));
    }

}
