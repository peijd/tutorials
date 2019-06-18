package com.ripjava.java.core.function;
@FunctionalInterface
public interface FooExtended extends Baz, Bar {

    default void defaultCommon() {
        Baz.super.defaultCommon();
    }
}
