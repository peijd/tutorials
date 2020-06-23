package com.ripjava.beanpostprocessor;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanPostProcessorTest {

    @Test
    public void test_BeanPostProcessorTest() {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        IPayment cashBean = (IPayment) context.getBean(CashPayment.class);
        IPayment cardBean = (IPayment) context.getBean(CardPayment.class);
        context.close();
    }
}
