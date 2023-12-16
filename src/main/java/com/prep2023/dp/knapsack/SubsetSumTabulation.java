package com.prep2023.dp.knapsack;

import java.util.Arrays;

public class SubsetSumTabulation {
    public static void main(String[] args) {
        int[] set = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
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
    private static boolean subsetSum(int[] wt, int sum, int n) {
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++){
            for(int j=0; j<=sum;j++){
                if(i==0 || j==0){
                    if(i==0){
                        dp[i][j] = false;
                    }
                    if(j==0){
                        dp[i][j] = true;
                    }
                }
                else if(wt[i-1] <= j){
                    dp[i][j] = dp[i-1][j-wt[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }


        return dp[n][sum];
    }

}
