package com.ripjava.beanpostprocessor;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CardPayment  implements IPayment{
    public void executePayment() {
        System.out.println("Perform Card Payment ");
    }
    @PostConstruct
    public void initMethod(){
        System.out.println("Calling InitMethod for CardPayment");
    }
    @Override
    public void processInstance(IPayment bean) {
        System.out.println("processInstance method called with bean " + bean);
    }
}