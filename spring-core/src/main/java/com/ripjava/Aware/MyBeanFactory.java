package com.ripjava.Aware;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class MyBeanFactory implements BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public String getMyBeanName() {
        BeanName beanName = beanFactory.getBean(BeanName.class);
        System.out.println(beanFactory.isSingleton("customBeanName"));
        return beanName.getBeanName();
    }

}
