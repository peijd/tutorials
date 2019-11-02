package com.ripjava.spring.properties.json;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(scanBasePackageClasses = { JsonProperties.class, CustomJsonProperties.class})
public class ConfigPropertiesDemoApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigPropertiesDemoApplication.class)
                .initializers(new JsonPropertyContextInitializer())
                .run();
    }
}
