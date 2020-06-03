package com.ripjava.lazy;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LazyAnnotationTest {

    @Test
    public void test_LazyConfiguration() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        System.out.println("before refresh");
        ctx.refresh();
        System.out.println("after refresh");
        ctx.getBean(Region.class);
        ctx.getBean(Country.class);
    }

    @Test
    public void test_LazyAutowired() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        System.out.println("before refresh");
        ctx.refresh();
        System.out.println("after refresh");
        Region region = ctx.getBean(Region.class);
        System.out.println("before getCityInstance");
        region.getCityInstance();
        System.out.println("after getCityInstance");
        region.getCityInstance().test();
    }
}