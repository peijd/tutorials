package com.ripjava.injectstaticvalue;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class InjectPropertyToStaticFieldTest {

    @Test
    public  void  test_InjectPropertyToStaticField(){
        ApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        InjectPropertyToStaticField iptsf = context.getBean(InjectPropertyToStaticField.class);

        assertEquals("ripjava.com", iptsf.name);
        assertNull(InjectPropertyToStaticField.NAME_NULL);
        assertEquals("ripjava.com", InjectPropertyToStaticField.NAME_STATIC);
    }
}
