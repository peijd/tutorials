package com.ripjava.bean.di;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpringBeanTest {

    @Test
    public void test_SpringBean(){
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Company company = context.getBean("company", Company.class);
        assertEquals("ripjava.com", company.getAddress().getStreet());
        assertEquals(1000, company.getAddress().getNumber());
    }
}
