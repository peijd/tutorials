package com.ripjava.spring.properties.yaml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class YamlConfigApplication {

    public static void main(String[] args) {
        new SpringApplication(YamlConfigApplication.class).run();
    }
}
