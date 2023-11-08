package com.prep2023.arrays.searching.binarySearch_II;

/**
 * Author: Bhupendra Shekhawat
 * Date: 08/11/23
 * Topic: com.prep2023.arrays.searching.binarySearch_II
 * Question : <a href="https://leetcode.com/problems/find-peak-element/description/">162. Find Peak Element</a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _1_FindPeak {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n==0)return -1;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) { //if left of mid is bigger, search left side
                high = mid - 1;
            } else if (mid + 1 <= high && nums[mid] < nums[mid + 1]) { //if right side is bigger search right side
                low = mid + 1;
            } else { //found the peak
                return mid;
            }
        }
        return -1;
    }
}
