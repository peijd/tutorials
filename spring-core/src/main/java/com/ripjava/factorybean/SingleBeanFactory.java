package com.ripjava.factorybean;

import org.springframework.beans.factory.config.AbstractFactoryBean;

public class SingleBeanFactory extends AbstractFactoryBean<MyBean> {
    private int factoryId;
    private int beanId;

    @Override
    public Class<?> getObjectType() {
        return MyBean.class;
    }

    @Override
    protected MyBean createInstance() throws Exception {
        return new MyBean(beanId);
    }

    public int getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId;
    }

    public int getBeanId() {
        return beanId;
    }

    public void setBeanId(int beanId) {
        this.beanId = beanId;
    }
}
