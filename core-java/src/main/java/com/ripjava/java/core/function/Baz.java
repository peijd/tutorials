package com.ripjava.java.core.function;

@FunctionalInterface
public interface Baz {
    String method();
    default void defaultBaz() {}
    default void defaultCommon() {}
}
