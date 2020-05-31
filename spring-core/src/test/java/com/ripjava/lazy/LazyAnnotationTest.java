package com.ripjava.lazy;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LazyAnnotationTest {

    @Test
    public void test_LazyConfiguration() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        ctx.getBean(Region.class);
        ctx.getBean(Country.class);
    }

    @Test
    public void givenLazyAnnotation_whenAutowire_thenLazyBean() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        Region region = ctx.getBean(Region.class);
        region.getCityInstance();
    }

    @Test
    public void givenLazyAnnotation_whenBeanConfig_thenLazyBean() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        ctx.getBean(Region.class);
    }
}