package com.ripjava.Aware;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeanFactoryAwareTest {

    @Test
    public void test_BeanFactoryAware(){
        ApplicationContext context
                = new AnnotationConfigApplicationContext(Config.class);
        MyBeanFactory myBeanFactory = context.getBean(MyBeanFactory.class);
        assertEquals("customBeanName", myBeanFactory.getMyBeanName());
    }
}
