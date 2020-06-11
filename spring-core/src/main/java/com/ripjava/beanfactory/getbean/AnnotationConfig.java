package com.ripjava.beanfactory.getbean;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AnnotationConfig {
    @Bean(name = {"bull", "cattle"})
    @Scope(value = "prototype")
    public Bull getBull(String name) {
        return new Bull(name);
    }

    @Bean(name = "dog")
    public Dog getDog() {
        return new Dog("dog");
    }
}
