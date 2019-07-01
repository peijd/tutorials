package com.ripjava.java.core.enums;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class Pizza3 {

    private static EnumSet<PizzaStatusEnum> deliveredPizzaStatuses = EnumSet.of(PizzaStatusEnum.DELIVERED);

    private PizzaStatusEnum status;

    public enum PizzaStatusEnum {
        ORDERED(5) {
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY(2) {
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED(0) {
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        private int timeToDelivery;

        public boolean isOrdered() {
            return false;
        }

        public boolean isReady() {
            return false;
        }

        public boolean isDelivered() {
            return false;
        }

        public int getTimeToDelivery() {
            return timeToDelivery;
        }

        PizzaStatusEnum(int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }
    }

    public PizzaStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PizzaStatusEnum status) {
        this.status = status;
    }

    public boolean isDeliverable() {
        return this.status.isReady();
    }

    public void printTimeToDeliver() {
        System.out.println("Time to delivery is " + this.getStatus().getTimeToDelivery() + " days");
    }

    public static List<Pizza3> getAllUndeliveredPizzas(List<Pizza3> input) {
        return input.stream().filter((s) -> !deliveredPizzaStatuses.contains(s.getStatus())).collect(Collectors.toList());
    }

    public static EnumMap<PizzaStatusEnum, List<Pizza3>> groupPizzaByStatus(List<Pizza3> pzList) {
        return pzList.stream().collect(Collectors.groupingBy(Pizza3::getStatus, () -> new EnumMap<>(PizzaStatusEnum.class), Collectors.toList()));
    }

    public void deliver() {
        if (isDeliverable()) {
            PizzaDeliverySystemConfiguration.getInstance().getDeliveryStrategy().deliver(this);
            this.setStatus(PizzaStatusEnum.DELIVERED);
        }
    }





}