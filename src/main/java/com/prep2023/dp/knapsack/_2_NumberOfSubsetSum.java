package com.prep2023.dp.knapsack;

public class _2_NumberOfSubsetSum {

    public static void main(String[] args) {
        _2_NumberOfSubsetSum numberOfSubsetSum = new _2_NumberOfSubsetSum();

        // Test Case 1
        int[] nums1 = {1, 2, 3, 3};
        int target1 = 6;
        int expected1 = 3; // (1, 2, 3), (3, 3)
        int result1 = numberOfSubsetSum.numberOfSubsetSum(nums1, target1);
        System.out.println("Test Case 1 - Expected: " + expected1 + ", Actual: " + result1);

        // Test Case 2
        int[] nums2 = {1, 1, 1, 1, 1};
        int target2 = 3;
        int expected2 = 10;
        int result2 = numberOfSubsetSum.numberOfSubsetSum(nums2, target2);
        System.out.println("Test Case 2 - Expected: " + expected2 + ", Actual: " + result2);

        // Test Case 3
        int[] nums3 = {1, 2, 7, 1, 5};
        int target3 = 9;
        int expected3 = 3; // (2, 7), (1, 2, 1, 5), (1, 2, 1, 5)
        int result3 = numberOfSubsetSum.numberOfSubsetSum(nums3, target3);
        System.out.println("Test Case 3 - Expected: " + expected3 + ", Actual: " + result3);

        // Test Case 4
        int[] nums4 = {1, 2, 3, 4, 5};
        int target4 = 10;
        int expected4 = 3; // (1, 2, 3, 4), (1, 4, 5) , {2,3,5}
        int result4 = numberOfSubsetSum.numberOfSubsetSum(nums4, target4);
        System.out.println("Test Case 4 - Expected: " + expected4 + ", Actual: " + result4);

        // Test Case 5
        int[] nums5 = {3, 1, 2, 4};
        int target5 = 5;
        int expected5 = 2; // (3, 2), (1, 4)
        int result5 = numberOfSubsetSum.numberOfSubsetSum(nums5, target5);
        System.out.println("Test Case 5 - Expected: " + expected5 + ", Actual: " + result5);
    }

    /*
    private int numberOfSubsetSum(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n+1][target+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<= target;j++){
                if(i ==0){
                    dp[i][j] = (j==0)? 1: 0;
                }
                else if(j==0){
                    dp[i][j] = 1;
                }
                else if(nums[i-1] <=j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    } */

    private int numberOfSubsetSum(int[] nums, int target) {
        int n = nums.length;
        int dp[] = new int[target+1];
        dp[0] =1;
        for(int cur : nums){
            for(int j = target ; j>= cur ;j--){
                dp[j] += dp[j-cur];
            }
        }
        return dp[target];
    }
}
