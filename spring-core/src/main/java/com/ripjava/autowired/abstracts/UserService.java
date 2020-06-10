package com.ripjava.autowired.abstracts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService  extends ServiceV2{

    @Autowired
    public UserService(LogRepository logRepository) {
        super(logRepository);
    }
}
