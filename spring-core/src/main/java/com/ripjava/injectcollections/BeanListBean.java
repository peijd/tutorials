package com.ripjava.injectcollections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BeanListBean {

    @Autowired(required = false)
    @Qualifier("CollectionsBean")
    private List<RipjavaBean> beanList;

    public void printBeanList() {
        System.out.println(beanList);
    }

    @Value("${names.list:}#{T(java.util.Collections).emptyList()}")
    private List<String> nameListWithDefaultValue;

    public void printNameListWithDefaults() {
        System.out.println(nameListWithDefaultValue);
    }
}
