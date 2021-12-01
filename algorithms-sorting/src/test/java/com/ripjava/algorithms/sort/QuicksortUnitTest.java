package com.ripjava.algorithms.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuicksortUnitTest {
    @Test
    public void test_QuickSort() {
        int[] actual = { 5, 1, 6, 3, 2, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };
        Quicksort.quickSort(actual, 0, actual.length - 1);
        assertArrayEquals(expected, actual);
    }
}
