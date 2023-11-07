package com.prep2023.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountInversionsTest {

    @Test
    public void testEmptyList() {
        List<Integer> arr = Arrays.asList();
        long expected = 0;
        assertEquals(expected, new _3_CountInversions().countInversions(arr));
    }

    @Test
    public void testNoInversions() {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        long expected = 0;
        assertEquals(expected, new _3_CountInversions().countInversions(arr));
    }

    @Test
    public void testAllInversions() {
        List<Integer> arr = Arrays.asList(5, 4, 3, 2, 1);
        long expected = 10; // 5 inversions for each element
        assertEquals(expected, new _3_CountInversions().countInversions(arr));
    }

    @Test
    public void testOverflowInversions() {
        List<Integer> arr = Arrays.asList(Integer.MAX_VALUE, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 2);
        long expected = 3; // 3 inversions
        assertEquals(expected, new _3_CountInversions().countInversions(arr));
    }

    @Test
    public void testRandomInversions() {
        List<Integer> arr = Arrays.asList(4, 3, 7, 1, 5, 2, 6);
        long expected = 10;
        assertEquals(expected, new _3_CountInversions().countInversions(arr));
    }

    @Test
    public void testDuplicateElements() {
        List<Integer> arr = Arrays.asList(2, 2, 2, 2, 2);
        long expected = 0; // No inversions
        assertEquals(expected, new _3_CountInversions().countInversions(arr));
    }

    @Test
    public void testLargeArray() {
        List<Integer> arr = new ArrayList<>();
        for (int i = 10000; i >= 1; i--) {
            arr.add(i);
        }
        long expected = 49995000; // Number of inversions in a descending order array
        assertEquals(expected, new _3_CountInversions().countInversions(arr));
    }

    @Test
    public void testSingleElement() {
        List<Integer> arr = Arrays.asList(42);
        long expected = 0; // Single element has no inversions
        assertEquals(expected, new _3_CountInversions().countInversions(arr));
    }

    @Test
    public void testNegativeNumbers() {
        List<Integer> arr = Arrays.asList(-3, -1, -2, -5, -4);
        long expected = 7; // Number of inversions
        assertEquals(expected, new _3_CountInversions().countInversions(arr));
    }
}
