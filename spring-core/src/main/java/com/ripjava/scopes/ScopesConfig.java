package com.ripjava.scopes;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan("com.ripjava.scopes")
public class ScopesConfig {
    @Bean
    @Scope("prototype")
    public Person personPrototype() {
        return new Person();
    }

    @Bean
    @Scope("singleton")
    public Person personSingleton() {
        return new Person();
    }
}

