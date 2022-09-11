package com.codingpractice.dynamicProgramming.dpAdityav.I_01Knapsack;

import java.util.Arrays;

public class II_KnapsackTopDown {

    private static int[][] dp;
    public static void main(String[] args) {
        int N = 3;
        int W = 4;
        int values[] = {1,2,3};
        int weight[] = {4,5,1};

        dp = new int[N][W];
        for(int arr[]: dp){
            Arrays.fill(arr,-1);
        }

        System.out.println(knapsackTopDown(values,weight,N,W));

        N = 3;
        W = 3;
        values = new int[]{1,2,3};
        weight = new int[]{4,5,6};
        dp = new int[N][W];
        for(int arr[]: dp){
            Arrays.fill(arr,-1);
        }
        System.out.println(knapsackTopDown(values,weight,N,W));
    }

    private static int knapsackTopDown(int[] values, int[] weight, int n, int w) {
        if(n==0 || w==0)return 0;

        if(dp[n-1][w-1]!=-1)return dp[n-1][w-1];

        if(weight[n-1] <= w){
            dp[n-1][w-1] = Math.max(values[n-1] + knapsackTopDown(values,weight,n-1,w - weight[n-1]) ,
                    knapsackTopDown(values,weight,n-1,w));
        }
        else {
            dp[n - 1][w - 1] = knapsackTopDown(values, weight, n - 1, w);
        }
        return dp[n-1][w-1];
    }
}
