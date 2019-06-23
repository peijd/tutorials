package com.ripjava.java.core.interfaces;

public interface Alarm {
    default String turnAlarmOn() {
        return "打开车辆警报.";
    }

    default String turnAlarmOff() {
        return "关闭车辆警报.";
    }
}
