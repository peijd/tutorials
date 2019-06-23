package com.ripjava.java.core.interfaces;

public class Car implements Vehicle, Alarm {

    private String brand;

    public Car(String brand) {
        this.brand = brand;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String speedUp() {
        return "汽车正在加速.";
    }

    @Override
    public String slowDown() {
        return "汽车正在减速.";
    }

//    @Override
//    public String turnAlarmOn() {
//        return Vehicle.super.turnAlarmOn();
//    }
//
//    @Override
//    public String turnAlarmOff() {
//        return Vehicle.super.turnAlarmOff();
//    }

    @Override
    public String turnAlarmOn() {
        return Vehicle.super.turnAlarmOn() + " " + Alarm.super.turnAlarmOn();
    }

    @Override
    public String turnAlarmOff() {
        return Vehicle.super.turnAlarmOff() + " " + Alarm.super.turnAlarmOff();
    }

    public static void main(String[] args) {
        Vehicle car = new Car("BMW");
        System.out.println(car.getBrand());
        System.out.println(car.speedUp());
        System.out.println(car.slowDown());
        System.out.println(car.turnAlarmOn());
        System.out.println(car.turnAlarmOff());
    }
}
