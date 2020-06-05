package com.ripjava.Aware;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeanNameAwareTest {
    @Test
    public void test_BeanNameAware(){
        ApplicationContext context
                = new AnnotationConfigApplicationContext(Config.class);

        BeanName beanName = context.getBean(BeanName.class);

        assertEquals("customBeanName", beanName.getBeanName());
    }
}
