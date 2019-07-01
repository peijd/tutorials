package com.ripjava.java.core.enums;

public enum PizzaDeliveryStrategy {
    EXPRESS {
        @Override
        public void deliver(Pizza3 pz) {
            System.out.println("快速到达");
        }
    },
    NORMAL {
        @Override
        public void deliver(Pizza3 pz) {
            System.out.println("普通到达");
        }
    };

    public abstract void deliver(Pizza3 pz);
}