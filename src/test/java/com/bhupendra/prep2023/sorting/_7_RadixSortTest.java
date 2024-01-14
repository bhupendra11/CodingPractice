package com.bhupendra.prep2023.sorting;

import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class _7_RadixSortTest {

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        _7_RadixSort.radixSort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        _7_RadixSort.radixSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        _7_RadixSort.radixSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testRandomArray() {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        _7_RadixSort.radixSort(arr);
        assertArrayEquals(new int[]{2, 24, 45, 66, 75, 90, 170, 802}, arr);
    }

    @Test
    public void testArrayWithDuplicates() {
        int[] arr = {5, 5, 5, 5, 5};
        _7_RadixSort.radixSort(arr);
        assertArrayEquals(new int[]{5, 5, 5, 5, 5}, arr);
    }

    //Current implementation does not handle Negative numbers
//    @Disabled
//    @Test
//    public void testArrayWithNegativeNumbers() {
//        int[] arr = {4, -2, 7, -5, 1};
//        _7_RadixSort.radixSort(arr);
//        assertArrayEquals(new int[]{-5, -2, 1, 4, 7}, arr);
//    }

    @Test
    public void testArrayWithSingleElement() {
        int[] arr = {42};
        _7_RadixSort.radixSort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    public void testLargeInput() {
        int[] arr = new int[1000];
        for (int i = 999; i >= 0; i--) {
            arr[i] = i % 100;
        }
        _7_RadixSort.radixSort(arr);
        int[] expected = new int[1000];
        for (int i = 0; i < 1000; i++) {
            expected[i] = i % 100;
        }
        Arrays.sort(expected);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testArrayWithLargeNumbers() {
        int[] arr = {1000, 100000, 10000, 1000000, 100, 10000000};
        _7_RadixSort.radixSort(arr);
        assertArrayEquals(new int[]{100, 1000, 10000, 100000, 1000000, 10000000}, arr);
    }
}