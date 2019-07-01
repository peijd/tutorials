package com.ripjava.java.core.enums;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestEnums {

    @Test
    public void test_PizaOrder() {
        Pizza2 testPz = new Pizza2();
        testPz.setStatus(Pizza2.PizzaStatus.READY);
        assertTrue(testPz.isDeliverable());
    }

    @Test
    public void test_RetrievingUnDeliveredPzs() {
        List<Pizza3> pzList = new ArrayList<>();
        Pizza3 pz1 = new Pizza3();
        pz1.setStatus(Pizza3.PizzaStatusEnum.DELIVERED);

        Pizza3 pz2 = new Pizza3();
        pz2.setStatus(Pizza3.PizzaStatusEnum.ORDERED);

        Pizza3 pz3 = new Pizza3();
        pz3.setStatus(Pizza3.PizzaStatusEnum.ORDERED);

        Pizza3 pz4 = new Pizza3();
        pz4.setStatus(Pizza3.PizzaStatusEnum.READY);

        pzList.add(pz1);
        pzList.add(pz2);
        pzList.add(pz3);
        pzList.add(pz4);

        List<Pizza3> undeliveredPzs = Pizza3.getAllUndeliveredPizzas(pzList);
        assertTrue(undeliveredPzs.size() == 3);
    }

    @Test
    public void test_GroupByStatusCalled() {
        List<Pizza3> pzList = new ArrayList<>();
        Pizza3 pz1 = new Pizza3();
        pz1.setStatus(Pizza3.PizzaStatusEnum.DELIVERED);

        Pizza3 pz2 = new Pizza3();
        pz2.setStatus(Pizza3.PizzaStatusEnum.ORDERED);

        Pizza3 pz3 = new Pizza3();
        pz3.setStatus(Pizza3.PizzaStatusEnum.ORDERED);

        Pizza3 pz4 = new Pizza3();
        pz4.setStatus(Pizza3.PizzaStatusEnum.READY);

        pzList.add(pz1);
        pzList.add(pz2);
        pzList.add(pz3);
        pzList.add(pz4);

        EnumMap<Pizza3.PizzaStatusEnum,List<Pizza3>> map = Pizza3.groupPizzaByStatus(pzList);
        assertTrue(map.get(Pizza3.PizzaStatusEnum.DELIVERED).size() == 1);
        assertTrue(map.get(Pizza3.PizzaStatusEnum.ORDERED).size() == 2);
        assertTrue(map.get(Pizza3.PizzaStatusEnum.READY).size() == 1);
    }

    @Test
    public void test_Delivered() {
        Pizza3 pz = new Pizza3();
        pz.setStatus(Pizza3.PizzaStatusEnum.READY);
        pz.deliver();
        assertTrue(pz.getStatus() == Pizza3.PizzaStatusEnum.DELIVERED);
    }



}
