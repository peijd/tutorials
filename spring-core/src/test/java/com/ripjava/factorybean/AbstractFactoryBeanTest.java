package com.ripjava.factorybean;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "classpath:factorybean-spring-ctx.xml" })
public class AbstractFactoryBeanTest {

    @Resource(name = "singleTool")
    private MyBean myBean1;

    @Resource(name = "singleTool")
    private MyBean myBean2;

    @Resource(name = "nonSingleTool")
    private MyBean myBean3;

    @Resource(name = "nonSingleTool")
    private MyBean myBean4;

    @Test
    public void testSingleToolFactory() {
        assertThat(myBean1.getId(), equalTo(3));
        assertTrue(myBean1 == myBean2);
    }

    @Test
    public void testNonSingleToolFactory() {
        assertThat(myBean3.getId(), equalTo(4));
        assertThat(myBean4.getId(), equalTo(4));
        assertTrue(myBean3 != myBean4);
    }
}
