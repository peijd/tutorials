package com.ripjava.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(0)
public class InstantiationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("In postProcessBeforeInitialization method");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {

        System.out.println("In postProcessAfterInitialization method");
        if(bean instanceof IPayment){
            ((IPayment) bean).processInstance((IPayment)bean);
        }
        return bean;
    }
}