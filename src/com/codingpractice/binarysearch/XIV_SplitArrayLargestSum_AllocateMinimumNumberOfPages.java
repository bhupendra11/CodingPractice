package com.codingpractice.binarysearch;

/**
 * Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
 *
 * Write an algorithm to minimize the largest sum among these m subarrays.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [7,2,5,10,8], m = 2
 * Output: 18
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 * Example 2:
 *
 * Input: nums = [1,2,3,4,5], m = 2
 * Output: 9
 * Example 3:
 *
 * Input: nums = [1,4,4], m = 3
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 106
 * 1 <= m <= min(50, nums.length)
 */

/**
 * Leetcode 410. Split Array Largest Sum
 * https://leetcode.com/problems/split-array-largest-sum/
 * https://www.youtube.com/watch?v=2JSQIhPcHQg&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=21
 */
public class XIV_SplitArrayLargestSum_AllocateMinimumNumberOfPages {

    public static void main(String[] args) {

        int arr[] = {7,2,5,10,8};
        System.out.println(splitArray(arr,2));
        int arr2[] = {1,2,3,4,5};
        System.out.println(splitArray(arr2,2));
        int arr3[] = {1,4,4};
        System.out.println(splitArray(arr3,3));

    }

    private static int splitArray(int[] nums, int m) {
        int sum =0;
        int max =0;
        for(int i: nums){
            sum+=i;
            max =Math.max(max,i);
        }

        int low = max;
        int high = sum;
        int res=0;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(isValid(nums,m,mid)){
                res=mid;
                high =mid-1;
            }
            else{
                low =mid+1;
            }
        }

        return res;

    }

    private static boolean isValid(int[] nums, int m, int max){
        int arrayCount=1;

        int sum =0;
        int i=0;

        while(i<nums.length){
            sum += nums[i];
            i++;
            if(sum> max){
                arrayCount++;
                i--;
                sum=0;
            }
        }

        return arrayCount<=m;
    }

}
