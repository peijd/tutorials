package com.ripjava.xmlbase;

public class StaticServiceFactory {
    public static IService getService(int number) {
        switch (number) {
            case 1:
                return new IndexService();
            default:
                throw new IllegalArgumentException("Unknown parameter " + number);
        }
    }
}
