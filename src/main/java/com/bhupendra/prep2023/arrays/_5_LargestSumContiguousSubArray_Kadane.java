package com.bhupendra.prep2023.arrays;

/**
 * Author: Bhupendra Shekhawat
 * Date: 07/11/23
 * Topic: com.prep2023.arrays
 * Question : <a href="https://leetcode.com/problems/maximum-subarray/description/"></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _5_LargestSumContiguousSubArray_Kadane {
    public int maxSubArray(int[] nums) {
        //Can be done using Kadane's algorithms in O(n)

        //Kadane's algorithm just simply says
        // I will keep including the next element till the overall profit(sum) that I am making is positive
        // When the overall profit becomes, negative, I will leave the current subarray and start calculating from zero again

        int maxSum = Integer.MIN_VALUE;
        int curSum =0;

        for(int i : nums){
            curSum += i;      //keep including the sum till overall sum till now becomes negative
            maxSum = Math.max(maxSum, curSum);
            if(curSum <0){ //if the cur subarray sum becomes negative, this subarray is of no use, so reset sum to zero
                curSum =0;
            }
        }
        return maxSum;
    }
}
