package com.ripjava.aop.intro;

public class AdderAfterReturnAspect {

    public void afterReturn(Object returnValue) throws Throwable {
        System.out.println(String.format("返回值为 %s", returnValue.toString()));
    }
}
