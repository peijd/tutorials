package com.ripjava.qualifier;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class QualifierApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(Config.class);
        FooService bean = context.getBean(FooService.class);
        bean.format();
    }
}
