package com.ripjava.configurable;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurableApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurableAppConfig.class);
        Account account = new Account();
        account.callService();

    }
}
