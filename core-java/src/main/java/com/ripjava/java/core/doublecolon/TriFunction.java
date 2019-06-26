package com.ripjava.java.core.doublecolon;

import java.util.Objects;
import java.util.function.Function;

public interface TriFunction<A, B, C, R> {

    R apply(A a, B b, C c);
}
