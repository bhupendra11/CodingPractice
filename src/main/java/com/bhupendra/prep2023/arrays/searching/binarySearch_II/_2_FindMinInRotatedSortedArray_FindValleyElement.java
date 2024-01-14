package com.bhupendra.prep2023.arrays.searching.binarySearch_II;

/**
 * Author: Bhupendra Shekhawat
 * Date: 08/11/23
 * Topic: com.prep2023.arrays.searching.binarySearch_II
 * Question : <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/">153. Find Minimum in Rotated Sorted Array</a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _2_FindMinInRotatedSortedArray_FindValleyElement {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n==0)return -1;
        int low = 0;
        int high = n - 1;

        if (nums[low] < nums[high]) return nums[low];  //is sorted after rotation
        while (low < high) {
            int mid = low + (high - low) / 2;

            // we need to find the valley element, i.e. both sides of this element should be > element

            if (nums[mid] > nums[high]) { //go to left side
                low = mid + 1;
            } else if (nums[mid] < nums[high]) { //right side is smaller
                high = mid;
            }
        }
        return nums[low];
    }
}