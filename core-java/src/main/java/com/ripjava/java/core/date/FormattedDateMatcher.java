package com.ripjava.java.core.date;

import java.util.regex.Pattern;

public class FormattedDateMatcher implements DateMatcher {

    private Pattern datePattern;

    public FormattedDateMatcher(String regex) {
        datePattern = Pattern.compile(
                regex);
    }
    @Override
    public boolean matches(String date) {
        return datePattern.matcher(date).matches();
    }
}
