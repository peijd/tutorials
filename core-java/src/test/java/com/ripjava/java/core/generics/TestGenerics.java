package com.ripjava.java.core.generics;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.jupiter.api.Assertions.fail;
import static org.hamcrest.CoreMatchers.is;

public class TestGenerics {

    @Test
    public void Test_fromArrayToList() {
        Integer[] intArray = {1, 2, 3, 4, 5};
        List<String> stringList
                = Generics.fromArrayToList(intArray, Object::toString);

        assertThat(stringList, hasItems("1", "2", "3", "4", "5"));
    }

    @Test
    public void test_ArrayOfIntegers() {
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        List<String> stringList = Generics.fromArrayToList(intArray, Object::toString);
        assertThat(stringList, hasItems("1", "2", "3", "4", "5"));
    }
    @Test
    public void test_ArrayOfStrings() {
        String[] stringArray = { "hello1", "hello2", "hello3", "hello4", "hello5" };
        List<String> list = Generics.fromArrayToList(stringArray);

        assertThat(list, hasItems(stringArray));
    }


    @Test
    public void test_ArrayOfIntegersAndNumberUpperBound() {
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        List<Integer> list = Generics.fromArrayToListWithUpperBound(intArray);

        assertThat(list, hasItems(intArray));
    }
    @Test
    public void test_SubTypeOfWildCardBoundedGenericType() {
        try {
            List<Building> subBuildingsList = new ArrayList<>();
            subBuildingsList.add(new Building());
            subBuildingsList.add(new House());

            Generics.paintAllBuildings(subBuildingsList);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void test_AnInt() {
        int number = 7;
        List<Integer> list = Generics.createList(number);
        int otherNumber = list.get(0);
        assertThat(otherNumber, is(number));
    }


}
