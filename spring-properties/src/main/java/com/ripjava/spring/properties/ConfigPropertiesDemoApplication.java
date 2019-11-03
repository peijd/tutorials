package com.ripjava.spring.properties;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.ripjava.spring.properties"})
public class ConfigPropertiesDemoApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigPropertiesDemoApplication.class)
                .run();
    }

}
