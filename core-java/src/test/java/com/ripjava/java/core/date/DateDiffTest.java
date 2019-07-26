package com.ripjava.java.core.date;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateDiffTest {

    @Test
    public void test_TwoDatesDiffBeforeJava8()
            throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
        Date firstDate = sdf.parse("2019/07/24");
        Date secondDate = sdf.parse("2019/07/30");

        long diffInMillis = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);

        assertEquals(diff, 6);
    }


    @Test
    public void  test_TwoDatesDiffInJava8() {
        LocalDate now = LocalDate.now();
        LocalDate sixDaysBehind = now.minusDays(6);

        Period period = Period.between(now, sixDaysBehind);
        int diff = Math.abs(period.getDays());

        assertEquals(diff, 6);
    }
    @Test
    public void test_TwoDateTimesInJava8() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime sixMinutesBehind = now.minusMinutes(6);

        Duration duration = Duration.between(now, sixMinutesBehind);
        long diff = Math.abs(duration.toMinutes());

        assertEquals(diff, 6);
    }

    @Test
    public void test_TwoDatesDiffInJava8ByChronoUnit() {
        LocalDate now = LocalDate.now();
        LocalDate sixDaysAfter = now.plusDays(6);

        long diff = ChronoUnit.DAYS.between(now, sixDaysAfter);

        assertEquals(diff, 6);
    }

    @Test
    public void test_TwoDateTimesInJava8ByChronoUnit() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tenSecondsLater = now.plusSeconds(10);

        long diff = ChronoUnit.SECONDS.between(now, tenSecondsLater);

        assertEquals(diff, 10);
    }

    @Test
    public void test_TwoZonedDateTimesDiffInJava8() {
        LocalDateTime ldt = LocalDateTime.now();
        ZonedDateTime now = ldt.atZone(ZoneId.of("Asia/Tokyo"));
        ZonedDateTime sixMinutesBehind = now
                .withZoneSameInstant(ZoneId.of("Asia/Shanghai"))
                .minusMinutes(6);

        long diff = ChronoUnit.MINUTES.between(sixMinutesBehind, now);

        assertEquals(diff, 6);
    }

    @Test
    public void test_TwoZonedDateTimesDiffInJava8ByTemporal() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tenSecondsLater = now.plusSeconds(10);

        long diff = now.until(tenSecondsLater, ChronoUnit.SECONDS);

        assertEquals(diff, 10);
    }
}
