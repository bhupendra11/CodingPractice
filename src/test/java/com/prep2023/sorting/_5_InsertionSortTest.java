package com.prep2023.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class _5_InsertionSortTest {

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        _5_InsertionSort.insertionSort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        _5_InsertionSort.insertionSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        _5_InsertionSort.insertionSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testRandomArray() {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        _5_InsertionSort.insertionSort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9}, arr);
    }

    @Test
    public void testArrayWithDuplicates() {
        int[] arr = {5, 5, 5, 5, 5};
        _5_InsertionSort.insertionSort(arr);
        assertArrayEquals(new int[]{5, 5, 5, 5, 5}, arr);
    }

    @Test
    public void testLargeArray() {
        int[] arr = {5, 3, 2, 1, 4, 8, 6, 7, 9, 10, 11, 14, 13, 12, 15};
        _5_InsertionSort.insertionSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, arr);
    }

    @Test
    public void testArrayWithNegativeNumbers() {
        int[] arr = {4, -2, 7, -5, 1};
        _5_InsertionSort.insertionSort(arr);
        assertArrayEquals(new int[]{-5, -2, 1, 4, 7}, arr);
    }

    @Test
    public void testArrayWithSingleElement() {
        int[] arr = {42};
        _5_InsertionSort.insertionSort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    public void testRandomLargeArray() {
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = (int) (Math.random() * 100000);
        }
        _5_InsertionSort.insertionSort(arr);
        int[] expected = arr.clone();
        Arrays.sort(expected);
        assertArrayEquals(expected, arr);
    }
}
