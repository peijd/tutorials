package com.ripjava.java.core.reflections;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReflectionMethodTest {

    @Test
    public void test_MethodObjectInvokePublicMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method sumInstanceMethod
                = Operations.class.getMethod("publicSum", int.class, double.class);

        Operations operationsInstance = new Operations();
        Double result
                = (Double) sumInstanceMethod.invoke(operationsInstance, 1, 3);

        assertThat(result, equalTo(4.0));
    }

    @Test
    public void test_MethodObjectInvokeStaticMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method multiplyStaticMethod
                = Operations.class.getDeclaredMethod(
                "publicStaticMultiply", float.class, long.class);

        Double result
                = (Double) multiplyStaticMethod.invoke(null, 3.5f, 2);

        assertThat(result, equalTo(7.0));
    }

    @Test
    public void test_MethodObjectInvokePrivateMethod() throws NoSuchMethodException {
        Method andPrivateMethod
                = Operations.class.getDeclaredMethod(
                "privateAnd", boolean.class, boolean.class);

        Operations operationsInstance = new Operations();
        assertThrows(IllegalAccessException.class, () -> andPrivateMethod.invoke(operationsInstance, true, false));

    }

    @Test
    public void test_MethodObjectInvokePrivateMethodWithSetAccessible() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method andPrivateMethod
                = Operations.class.getDeclaredMethod(
                "privateAnd", boolean.class, boolean.class);

        Operations operationsInstance = new Operations();
        andPrivateMethod.setAccessible(true);
        Boolean result
                = (Boolean) andPrivateMethod.invoke(operationsInstance, true, false);

        assertFalse(result);
    }

}
