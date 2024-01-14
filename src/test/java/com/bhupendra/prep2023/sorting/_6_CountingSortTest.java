package com.bhupendra.prep2023.sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class _6_CountingSortTest {
    @Test
    public void testInput0to9arr() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        _6_CountingSort.countingSort(arr);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, arr);
    }

    @Test
    public void testInput0to9Reversearr() {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        _6_CountingSort.countingSort(arr);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, arr);
    }

    @Test
    public void testInput0to9RandomOrder() {
        int[] arr = {5, 2, 9, 4, 1, 7, 0, 3, 6, 8};
        _6_CountingSort.countingSort(arr);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, arr);
    }

    @Test
    public void testInput0to9AllDuplicates() {
        int[] arr = {4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
        _6_CountingSort.countingSort(arr);
        assertArrayEquals(new int[]{4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, arr);
    }


    @Test
    public void testInput0to9WithZeroes() {
        int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        _6_CountingSort.countingSort(arr);
        assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, arr);
    }

    @Test
    public void testInput0to9LargeInput() {
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = i % 10;
        }
        _6_CountingSort.countingSort(arr);
        int[] expected = new int[1000];
        for (int i = 0; i < 1000; i++) {
            expected[i] = i % 10;
        }
        Arrays.sort(expected);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testInput0to9WithSingleElement() {
        int[] arr = {7};
        _6_CountingSort.countingSort(arr);
        assertArrayEquals(new int[]{7}, arr);
    }

    @Test
    public void testInput0to9WithDuplicates() {
        int[] arr = {2, 2, 5, 1, 8, 5, 3, 9, 9, 1, 0, 7, 0, 4, 4};
        _6_CountingSort.countingSort(arr);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4, 5, 5, 7, 8, 9, 9}, arr);
    }


    @Test
    public void testEmptyArray() {
        int[] arr = {};
        _6_CountingSort.countingSort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void testarrArray() {
        int[] arr = {1, 2, 3, 4, 5};
        _6_CountingSort.countingSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testReversearrArray() {
        int[] arr = {5, 4, 3, 2, 1};
        _6_CountingSort.countingSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testRandomArray() {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        _6_CountingSort.countingSort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9}, arr);
    }

    @Test
    public void testArrayWithDuplicates() {
        int[] arr = {5, 5, 5, 5, 5};
        _6_CountingSort.countingSort(arr);
        assertArrayEquals(new int[]{5, 5, 5, 5, 5}, arr);
    }

    @Test
    public void testArrayWithNegativeNumbers() {
        int[] arr = {4, -2, 7, -5, 1};
        _6_CountingSort.countingSort(arr);
        assertArrayEquals(new int[]{-5, -2, 1, 4, 7}, arr);
    }

    @Test
    public void testArrayWithSingleElement() {
        int[] arr = {42};
        _6_CountingSort.countingSort(arr);
        assertArrayEquals(new int[]{42}, arr);
    }

    @Test
    public void testArrayWithLargeRange() {
        int[] arr = {1000, 2000, 3000, 4000, 5000};
        _6_CountingSort.countingSort(arr);
        assertArrayEquals(new int[]{1000, 2000, 3000, 4000, 5000}, arr);
    }
}