package com.ripjava.factorybean;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "classpath:factorybean-spring-ctx.xml" })
public class FactoryBeanXmlTest {


    @Resource(name = "MyBean")
    private  MyBean myBean;

    @Resource(name = "&MyBean")
    private MyFactoryBean myFactoryBean;

    @Test
    public void test_MyBean() {
        assertThat(myBean.getId(), equalTo(1));
    }

    @Test
    public void test_MyFactoryBean() {
        assertThat(myFactoryBean.getFactoryId(), equalTo(9999));
    }
}
