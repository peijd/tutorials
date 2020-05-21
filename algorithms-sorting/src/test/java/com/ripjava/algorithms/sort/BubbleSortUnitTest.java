package com.ripjava.algorithms.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BubbleSortUnitTest {

    @Test
    public void test_BubbleSort() {
        Integer[] array = { 2, 1, 4, 6, 3, 5 };
        Integer[] sortedArray = { 1, 2, 3, 4, 5, 6 };
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(array);
        assertArrayEquals(array, sortedArray);
    }

    @Test
    public void test_OptimizedBubbleSort() {
        Integer[] array = { 2, 1, 4, 6, 3, 5 };
        Integer[] sortedArray = { 1, 2, 3, 4, 5, 6 };
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.optimizedBubbleSort(array);
        assertArrayEquals(array, sortedArray);
    }
}
