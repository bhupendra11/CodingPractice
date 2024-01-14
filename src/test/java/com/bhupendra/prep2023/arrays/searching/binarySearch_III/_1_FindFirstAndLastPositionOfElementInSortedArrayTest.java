package com.bhupendra.prep2023.arrays.searching.binarySearch_III;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class _1_FindFirstAndLastPositionOfElementInSortedArrayTest {

    @Test
    public void testSearchRange_Example1() {
        _1_FindFirstAndLastPositionOfElementInSortedArray finder = new _1_FindFirstAndLastPositionOfElementInSortedArray();
        int[] nums = {5, 7, 7, 8, 8, 8, 10};
        int target = 8;
        int[] result = finder.searchRange(nums, target);
        int[] expected = {3, 5};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSearchRange_Example2() {
        _1_FindFirstAndLastPositionOfElementInSortedArray finder = new _1_FindFirstAndLastPositionOfElementInSortedArray();
        int[] nums = {5, 7, 7, 8, 8, 8, 10};
        int target = 6;
        int[] result = finder.searchRange(nums, target);
        int[] expected = {-1, -1};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSearchRange_EmptyArray() {
        _1_FindFirstAndLastPositionOfElementInSortedArray finder = new _1_FindFirstAndLastPositionOfElementInSortedArray();
        int[] nums = {};
        int target = 8;
        int[] result = finder.searchRange(nums, target);
        int[] expected = {-1, -1};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSearchRange_TargetNotInArray() {
        _1_FindFirstAndLastPositionOfElementInSortedArray finder = new _1_FindFirstAndLastPositionOfElementInSortedArray();
        int[] nums = {1, 2, 3, 4, 5};
        int target = 6;
        int[] result = finder.searchRange(nums, target);
        int[] expected = {-1, -1};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSearchRange_SingleElementArray() {
        _1_FindFirstAndLastPositionOfElementInSortedArray finder = new _1_FindFirstAndLastPositionOfElementInSortedArray();
        int[] nums = {7};
        int target = 7;
        int[] result = finder.searchRange(nums, target);
        int[] expected = {0, 0};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSearchRange_TargetInArrayButNotConsecutive() {
        _1_FindFirstAndLastPositionOfElementInSortedArray finder = new _1_FindFirstAndLastPositionOfElementInSortedArray();
        int[] nums = {1, 2, 3, 3, 4, 5};
        int target = 3;
        int[] result = finder.searchRange(nums, target);
        int[] expected = {2, 3};
        assertArrayEquals(expected, result);
    }
}
