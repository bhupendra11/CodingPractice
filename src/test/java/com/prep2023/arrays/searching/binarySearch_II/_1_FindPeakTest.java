package com.prep2023.arrays.searching.binarySearch_II;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class _1_FindPeakTest {

    @Test
    public void testFindPeak_MidPeak() {
        _1_FindPeak finder = new _1_FindPeak();
        int[] nums = {1, 3, 5, 2, 7};
        int result = finder.findPeakElement(nums);
        assertEquals(2, result);
    }

    @Test
    public void testFindPeak_BeginningPeak() {
        _1_FindPeak finder = new _1_FindPeak();
        int[] nums = {7, 5, 3, 2, 1};
        int result = finder.findPeakElement(nums);
        assertEquals(0, result);
    }

    @Test
    public void testFindPeak_EndPeak() {
        _1_FindPeak finder = new _1_FindPeak();
        int[] nums = {1, 2, 3, 5, 7};
        int result = finder.findPeakElement(nums);
        assertEquals(4, result);
    }

    @Test
    public void testFindPeak_SingleElement() {
        _1_FindPeak finder = new _1_FindPeak();
        int[] nums = {42};
        int result = finder.findPeakElement(nums);
        assertEquals(0, result);
    }

    @Test
    public void testFindPeak_Descending() {
        _1_FindPeak finder = new _1_FindPeak();
        int[] nums = {7, 5, 3, 2, 0};
        int result = finder.findPeakElement(nums);
        assertEquals(0, result);
    }

    @Test
    public void testFindPeak_Ascending() {
        _1_FindPeak finder = new _1_FindPeak();
        int[] nums = {1, 2, 3, 4, 5};
        int result = finder.findPeakElement(nums);
        assertEquals(4, result);
    }

    @Test
    public void testFindPeak_EmptyArray() {
        _1_FindPeak finder = new _1_FindPeak();
        int[] nums = {};
        int result = finder.findPeakElement(nums);
        assertEquals(-1, result); // Adjust this based on your expected behavior for an empty array
    }
}
