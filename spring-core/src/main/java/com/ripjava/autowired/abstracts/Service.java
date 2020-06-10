package com.ripjava.autowired.abstracts;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class Service {

    private LogRepository logRepository;

    @Autowired
    public final void setLogRepository(LogRepository logRepository) {
        this.logRepository = logRepository;
    }
}
