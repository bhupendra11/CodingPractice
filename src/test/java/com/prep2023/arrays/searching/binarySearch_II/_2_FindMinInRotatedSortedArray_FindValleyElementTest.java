package com.prep2023.arrays.searching.binarySearch_II;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class _2_FindMinInRotatedSortedArray_FindValleyElementTest {

    @Test
    public void testFindMin_SortedArray() {
        _2_FindMinInRotatedSortedArray_FindValleyElement finder = new _2_FindMinInRotatedSortedArray_FindValleyElement();
        int[] nums = {1, 2, 3, 4, 5};
        int result = finder.findMin(nums);
        assertEquals(1, result);
    }

    @Test
    public void testFindMin_RotatedArray() {
        _2_FindMinInRotatedSortedArray_FindValleyElement finder = new _2_FindMinInRotatedSortedArray_FindValleyElement();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int result = finder.findMin(nums);
        assertEquals(0, result);
    }

    @Test
    public void testFindMin_SortedArrayWithDuplicates() {
        _2_FindMinInRotatedSortedArray_FindValleyElement finder = new _2_FindMinInRotatedSortedArray_FindValleyElement();
        int[] nums = {1, 1, 1, 2, 2, 2, 3, 3};
        int result = finder.findMin(nums);
        assertEquals(1, result);
    }

    @Test
    public void testFindMin_RotatedArrayWithDuplicates() {
        _2_FindMinInRotatedSortedArray_FindValleyElement finder = new _2_FindMinInRotatedSortedArray_FindValleyElement();
        int[] nums = {2, 2, 2, 0, 1, 2, 2, 2};
        int result = finder.findMin(nums);
        assertEquals(0, result);
    }

    @Test
    public void testFindMin_SingleElementArray() {
        _2_FindMinInRotatedSortedArray_FindValleyElement finder = new _2_FindMinInRotatedSortedArray_FindValleyElement();
        int[] nums = {7};
        int result = finder.findMin(nums);
        assertEquals(7, result);
    }

    @Test
    public void testFindMin_EmptyArray() {
        _2_FindMinInRotatedSortedArray_FindValleyElement finder = new _2_FindMinInRotatedSortedArray_FindValleyElement();
        int[] nums = {};
        int result = finder.findMin(nums);
        assertEquals(-1, result); // Adjust this based on your expected behavior for an empty array
    }

    @Test
    public void testFindMin_ReverseSortedArray() {
        _2_FindMinInRotatedSortedArray_FindValleyElement finder = new _2_FindMinInRotatedSortedArray_FindValleyElement();
        int[] nums = {6, 5, 4, 3, 2, 1};
        int result = finder.findMin(nums);
        assertEquals(1, result);
    }
}
