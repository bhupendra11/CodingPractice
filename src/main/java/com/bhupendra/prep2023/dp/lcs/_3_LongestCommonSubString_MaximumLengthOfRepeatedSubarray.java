package com.bhupendra.prep2023.dp.lcs;

/**
 * Author: Bhupendra Shekhawat
 * Date: 11/11/23
 * Topic: com.prep2023.dynamicProgramming.lcs
 * Question : <a href="https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/">718. Maximum Length of Repeated Subarray</a>
 * YouTube : <a href="">Link to YouTube</a>
 */

//This question asks for subarray, which is same as substring
public class _3_LongestCommonSubString_MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int dp[][] = new int[m+1][n+1];
        int max =0;
        for(int i=1;i<=m ;i++){
            for(int j=1; j<= n ;j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] =0;
                }

                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
