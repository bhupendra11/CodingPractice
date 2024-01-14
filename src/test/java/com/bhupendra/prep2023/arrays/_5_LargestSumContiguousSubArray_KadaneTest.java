package com.bhupendra.prep2023.arrays;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class _5_LargestSumContiguousSubArray_KadaneTest {

    @Test
    public void testEmptyArray() {
        int[] nums = {};
        int expected = Integer.MIN_VALUE; // Empty array, so the result should be the minimum possible value
        assertEquals(expected, new _5_LargestSumContiguousSubArray_Kadane().maxSubArray(nums));
    }

    @Test
    public void testSinglePositiveElement() {
        int[] nums = {5};
        int expected = 5; // The largest sum is the element itself
        assertEquals(expected, new _5_LargestSumContiguousSubArray_Kadane().maxSubArray(nums));
    }

    @Test
    public void testSingleNegativeElement() {
        int[] nums = {-3};
        int expected = -3; // The largest sum is the element itself
        assertEquals(expected, new _5_LargestSumContiguousSubArray_Kadane().maxSubArray(nums));
    }

    @Test
    public void testAllPositiveElements() {
        int[] nums = {1, 2, 3, 4, 5};
        int expected = 15; // The largest sum is the sum of all elements
        assertEquals(expected, new _5_LargestSumContiguousSubArray_Kadane().maxSubArray(nums));
    }

    @Test
    public void testAllNegativeElements() {
        int[] nums = {-1, -2, -3, -4, -5};
        int expected = -1; // The largest sum is the largest negative element
        assertEquals(expected, new _5_LargestSumContiguousSubArray_Kadane().maxSubArray(nums));
    }

    @Test
    public void testMixedPositiveAndNegativeElements() {
        int[] nums = {1, -2, 3, -4, 5};
        int expected = 5; // The largest sum is the subarray [5]
        assertEquals(expected, new _5_LargestSumContiguousSubArray_Kadane().maxSubArray(nums));
    }

    @Test
    public void testAllZeroElements() {
        int[] nums = {0, 0, 0, 0, 0};
        int expected = 0; // The largest sum is 0
        assertEquals(expected, new _5_LargestSumContiguousSubArray_Kadane().maxSubArray(nums));
    }

    @Test
    public void testLargestSumAtStart() {
        int[] nums = {5, -3, 2, 1, -4, 7};
        int expected = 8; // The whole array
        assertEquals(expected, new _5_LargestSumContiguousSubArray_Kadane().maxSubArray(nums));
    }

    @Test
    public void testLargestSumAtEnd() {
        int[] nums = {4, -2, 1, -5, 6, 7};
        int expected = 13; // The largest sum is the subarray [6, 7]
        assertEquals(expected, new _5_LargestSumContiguousSubArray_Kadane().maxSubArray(nums));
    }

    @Test
    public void testLargestSumInTheMiddle() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int expected = 6; // The largest sum is the subarray [4, -1, 2, 1]
        assertEquals(expected, new _5_LargestSumContiguousSubArray_Kadane().maxSubArray(nums));
    }
}
