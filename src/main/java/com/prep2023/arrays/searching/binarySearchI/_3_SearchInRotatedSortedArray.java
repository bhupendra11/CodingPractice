package com.prep2023.arrays.searching.binarySearchI;

/**
 * Author: Bhupendra Shekhawat
 * Date: 07/11/23
 * Topic: com.prep2023.arrays.searching.binarySearchI
 * Question : <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/description/">33. Search in Rotated Sorted Array</a>
 * YouTube : <a href="">Link to YouTube</a>
 * Solution : https://leetcode.com/problems/search-in-rotated-sorted-array/solutions/4260547/single-binary-search
 * -without-finding-pivot-earlier/
 */
public class _3_SearchInRotatedSortedArray {
        public int search(int[] nums, int target) {
            if(nums.length ==0)return -1;
            //rotation k >=1
            if (nums.length == 1) {
                if (target == nums[0]) {
                    return 0;
                } else {
                    return -1;
                }
            }

            int low = 0;
            int high = nums.length - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                //every time we find the mid, we could be sure that out of the two subarrays,
                // at least one of them is sorted and make our decision based in that

                if (nums[mid] == target) {
                    return mid;
                }
                else if(nums[low] <= nums[mid]){
                    // left subarray to mid is sorted
                    if(target >= nums[low] && target < nums[mid]){
                        high = mid-1;
                    }
                    else{
                        low = mid+1;
                    }
                }
                else{
                    //right subarray to mid is sorted
                    if(target > nums[mid] && target <= nums[high]){
                        low = mid+1;
                    }
                    else{
                        high = mid-1;
                    }
                }
            }
            return -1;
        }
    }


