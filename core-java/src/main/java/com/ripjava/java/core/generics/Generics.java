package com.ripjava.java.core.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Generics {

    public static <T> List<T> fromArrayToList(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }

    public static <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapperFunction) {
        return Arrays.stream(a)
                .map(mapperFunction)
                .collect(Collectors.toList());
    }

    public static <T extends Number> List<T> fromArrayToListWithUpperBound(T[] a) {
        return Arrays.stream(a).collect(Collectors.toList());
    }

    public static <T> List<T> genericMethod(List<T> list) {
        return list.stream().collect(Collectors.toList());
    }

    public static void paintAllBuildings(List<? extends Building> buildings) {
        buildings.forEach(Building::paint);
    }

    public static List<Integer> createList(int a) {
        List<Integer> list = new ArrayList<>();
        list.add(a);
        return list;
    }
}
