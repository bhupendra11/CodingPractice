package com.prep2023.arrays;

/**
 * Author: Bhupendra Shekhawat
 * Date: 22/11/23
 * Topic: com.prep2023.arrays
 * Question : <a href="https://leetcode.com/problems/minimum-size-subarray-sum/?">209. Minimum Size Subarray Sum</a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _9_minSizeSubArraySum {
    public int minSubArrayLen(int target, int[] nums) {
        //array is only positive integers
        //check edge case, whole array
        int i=0;
        int j=0;
        int n = nums.length;
        int sum =0;
        int minLen = Integer.MAX_VALUE;

        while(i<=j && j<=n){
            if(sum >= target){
                minLen = Math.min(minLen, j-i);
                sum -= nums[i];
                i++;
                if(j<i){
                    j=i;
                }
            }
            else{
                if(j==n)break;
                sum += nums[j];
                j++;
            }
        }

        if(sum == target){
            minLen = Math.max(minLen, j-i);
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
