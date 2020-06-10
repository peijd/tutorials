package com.ripjava.autowired.abstracts;

public abstract class ServiceV2 {
    private LogRepository logRepository;

    public ServiceV2(LogRepository logRepository) {
        this.logRepository = logRepository;
    }
}
