package com.prep2023.dp.knapsack;

import java.util.Arrays;
import java.util.Random;

public class Knapsack_Memo {

    static int[][] dp;
    // Skeleton method to implement

    private static int knapsack(int[] weights, int[] values, int w, int n){
        dp = new int[w+1][n+1];
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
            //first col 0
            arr[0] = 0;
        }

        //filll first row with 0
        Arrays.fill(dp[0],0);

        return knapsackHelper(weights,values,w,n);
    }
    private static int knapsackHelper(int[] weights, int[] values, int w, int n) {
            if(w==0 || n==0)return 0;
            if(dp[w][n] != -1)return dp[w][n];

            if(weights[n-1] <= w){
                dp[w][n] = Math.max(values[n-1] + knapsackHelper(weights,values,w - weights[n-1], n-1),
                        knapsackHelper(weights,values,w, n-1)
                );
            }
            else dp[w][n] = knapsackHelper(weights,values,w, n-1);
            return dp[w][n];
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] weights1 = {2, 3, 4, 5};
        int[] values1 = {3, 4, 5, 6};
        int capacity1 = 5;
        int n1 = weights1.length;
        // Expected output: 7
        int result1 = knapsack(weights1, values1, capacity1, n1);
        System.out.println("Test Case 1 - Knapsack value: " + result1);

        // Test Case 2
        int[] weights2 = {1, 2, 3, 4, 5};
        int[] values2 = {10, 20, 30, 40, 50};
        int capacity2 = 8;
        int n2 = weights2.length;
        // Expected output: 80
        int result2 = knapsack(weights2, values2, capacity2, n2);
        System.out.println("Test Case 2 - Knapsack value: " + result2);

        // Test Case 3
        int[] weights3 = {3, 2, 2, 1};
        int[] values3 = {5, 3, 4, 2};
        int capacity3 = 5;
        int n3 = weights3.length;
        // Expected output: 9
        int result3 = knapsack(weights3, values3, capacity3, n3);
        System.out.println("Test Case 3 - Knapsack value: " + result3);

        // Generate a very large test case
        int numberOfItems = 1000;
        int[] weightsLarge = new int[numberOfItems];
        int[] valuesLarge = new int[numberOfItems];
        int capacityLarge = 5000;

        Random random = new Random();
        for (int i = 0; i < numberOfItems; i++) {
            weightsLarge[i] = random.nextInt(100) + 1; // Random weight between 1 and 100
            valuesLarge[i] = random.nextInt(100) + 1; // Random value between 1 and 100
        }

        // Expected output: ??? (depends on the actual implementation)
        int resultLarge = knapsack(weightsLarge, valuesLarge, capacityLarge, weightsLarge.length);
        System.out.println("Very Large Test Case - Knapsack value: " + resultLarge);
    }
}
