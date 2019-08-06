package com.ripjava.java.core.date;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class LocalDateToDateConverter {

    public static Date convertToDateToSqlDate(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }

    public static Date convertToDateByInstant(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }
}
