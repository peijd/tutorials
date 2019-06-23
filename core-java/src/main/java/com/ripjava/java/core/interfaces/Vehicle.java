package com.ripjava.java.core.interfaces;

public interface Vehicle {
    String getBrand();

    String speedUp();

    String slowDown();

    default String turnAlarmOn() {
        return "打开车辆警报.";
    }

    default String turnAlarmOff() {
        return "关闭车辆警报.";
    }

    static int getHorsePower(int rpm, int torque) {
        return (rpm * torque) / 5252;
    }
}
