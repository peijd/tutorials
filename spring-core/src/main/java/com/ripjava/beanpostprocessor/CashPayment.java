package com.ripjava.beanpostprocessor;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CashPayment implements IPayment{
    public void executePayment() {
        System.out.println("Perform Cash Payment ");
    }
    @PostConstruct
    public void initMethod(){
        System.out.println("Calling InitMethod for CashPayment");
    }
    @Override
    public void processInstance(IPayment bean) {
        System.out.println("processInstance method called with bean " + bean);
    }
}