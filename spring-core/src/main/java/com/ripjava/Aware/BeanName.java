package com.ripjava.Aware;

import org.springframework.beans.factory.BeanNameAware;

public class BeanName implements BeanNameAware {

    private String beanName;

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
        System.out.println(beanName);
    }

    public String getBeanName() {
        return beanName;
    }
}
