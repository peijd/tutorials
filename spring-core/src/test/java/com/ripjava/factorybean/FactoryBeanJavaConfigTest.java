package com.ripjava.factorybean;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = FactoryBeanAppConfig.class)
public class FactoryBeanJavaConfigTest {

    @Resource
    private  MyBean myBean;

    @Resource(name = "&MyBean")
    private MyFactoryBean myFactoryBean;

    @Test
    public void test_FactoryBean() {
        assertThat(myBean.getId(), equalTo(2));
        assertThat(myFactoryBean.getFactoryId(), equalTo(8888));
    }
}
