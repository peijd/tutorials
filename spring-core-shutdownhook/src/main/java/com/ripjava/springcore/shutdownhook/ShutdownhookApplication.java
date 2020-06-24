package com.ripjava.springcore.shutdownhook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class ShutdownhookApplication {

    public static void main(String[] args) {
        SpringApplication
                .run(ShutdownhookApplication.class, args);
    }

}
