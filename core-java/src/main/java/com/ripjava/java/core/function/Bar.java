package com.ripjava.java.core.function;

@FunctionalInterface
public interface Bar {
    String method();
    default void defaultBar() {}
    default void defaultCommon() {}
}
