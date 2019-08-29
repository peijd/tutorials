package com.ripjava.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Configuration
@PropertySource(name = "valuesProperties", value = "values.properties")
@ComponentScan("com.ripjava.value")
public class ValueApplication {


    public static void main(String[] args) {
        System.setProperty("systemValue", "Some system parameter value");
        System.setProperty("priority", "System property");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ValueApplication.class);
        ctx.getBean(ValueBean.class).print();
    }

    @Bean
    public SomeBean someBean() {
        return new SomeBean(10);
    }




}
