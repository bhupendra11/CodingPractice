package com.prep2023.arrays.searching.binarySearchI;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class _3_SearchInRotatedSortedArrayTest {

    @Test
    public void testSearchInRotatedSortedArray() {
        _3_SearchInRotatedSortedArray solution = new _3_SearchInRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int expected = 4; // The target value 0 is at index 4
        int result = solution.search(nums, target);
        assertEquals(expected, result);
    }

    @Test
    public void testSearchInRotatedSortedArrayTargetNotFound() {
        _3_SearchInRotatedSortedArray solution = new _3_SearchInRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        int expected = -1; // The target value 3 is not found in the array
        int result = solution.search(nums, target);
        assertEquals(expected, result);
    }

    @Test
    public void testSearchInRotatedSortedArraySingleElement() {
        _3_SearchInRotatedSortedArray solution = new _3_SearchInRotatedSortedArray();
        int[] nums = {1};
        int target = 1;
        int expected = 0; // The single element in the array is the target
        int result = solution.search(nums, target);
        assertEquals(expected, result);
    }

    @Test
    public void testSearchInRotatedSortedArrayEmptyArray() {
        _3_SearchInRotatedSortedArray solution = new _3_SearchInRotatedSortedArray();
        int[] nums = {};
        int target = 5;
        int expected = -1; // The array is empty, so the target is not found
        int result = solution.search(nums, target);
        assertEquals(expected, result);
    }

    @Test
    public void testSearchInRotatedSortedArrayNotFound() {
        _3_SearchInRotatedSortedArray solution = new _3_SearchInRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 8;
        int expected = -1; // The target value 8 is not found in the array
        int result = solution.search(nums, target);
        assertEquals(expected, result);
    }
}
