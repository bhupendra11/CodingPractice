package com.bhupendra.prep2023.dp.knapsack;

import java.util.Arrays;

public class SubsetSumMemo {
    public static void main(String[] args) {
        // Test Case 1
        int[] set1 = {3, 34, 4, 12, 5, 2};
        int sum1 = 9;
        int n1 = set1.length;
        // Expected output: true
        boolean result1 = subsetSum(set1, sum1, n1);
        System.out.println("Test Case 1 - Subset with sum 9 exists: " + result1);

        // Test Case 2
        int[] set2 = {1, 2, 3, 7};
        int sum2 = 6;
        int n2 = set2.length;
        // Expected output: true
        boolean result2 = subsetSum(set2, sum2, n2);
        System.out.println("Test Case 2 - Subset with sum 6 exists: " + result2);

        // Test Case 3
        int[] set3 = {1, 2, 3, 4, 5};
        int sum3 = 10;
        int n3 = set3.length;
        // Expected output: true
        boolean result3 = subsetSum(set3, sum3, n3);
        System.out.println("Test Case 3 - Subset with sum 10 exists: " + result3);

        // Test Case 4
        int[] set4 = {1, 2, 3, 4, 5};
        int sum4 = 11;
        int n4 = set4.length;
        // Expected output: true
        boolean result4 = subsetSum(set4, sum4, n4);
        System.out.println("Test Case 4 - Subset with sum 11 exists: " + result4);

        int[] set = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // False Test Case 5
        int sum5 = 22;
        int n5 = 4; // considering the subset {1, 2, 3, 4}
        // Expected output: false
        boolean result5 = subsetSum(set, sum5, n5);
        System.out.println("Test Case 5 - Subset with sum 22 exists: " + result5);

        // False Test Case 6
        int sum6 = 35;
        int n6 = 6; // considering the subset {1, 2, 3, 4, 5, 6}
        // Expected output: false
        boolean result6 = subsetSum(set, sum6, n6);
        System.out.println("Test Case 6 - Subset with sum 35 exists: " + result6);

        // False Test Case 7
        int sum7 = 12;
        int n7 = 2; // considering the subset {1, 2}
        // Expected output: false
        boolean result7 = subsetSum(set, sum7, n7);
        System.out.println("Test Case 7 - Subset with sum 12 exists: " + result7);

        // False Test Case 8
        int sum8 = 30;
        int n8 = 3; // considering the subset {1, 2, 3}
        // Expected output: false
        boolean result8 = subsetSum(set, sum8, n8);
        System.out.println("Test Case 8 - Subset with sum 30 exists: " + result8);

    }
    private static boolean subsetSum(int[] arr, int sum, int n) {
        int dp[][] = new int[n+1][sum+1];
        int res = subsetSumMemo(arr,sum, n, dp);


        return res ==2;
    }

    /*
    0- unvisited
    1- false
    2- true
     */
    private static int subsetSumMemo(int[] arr, int sum, int n, int[][] dp) {
        if(sum == 0)return 2;
        if(n==0)return 1;

        if(dp[n][sum] != 0)return dp[n][sum] ;

        if(arr[n-1] <= sum){
            int chosen = subsetSumMemo(arr, sum- arr[n-1], n-1 ,dp);
            int notChosen =  subsetSumMemo(arr, sum,n-1,dp);
            dp[n][sum] = (chosen ==2 || notChosen ==2) ? 2: 1;
        }
        else
            dp[n][sum] =  subsetSumMemo(arr,sum,n-1,dp);
        return dp[n][sum];
    }

}
