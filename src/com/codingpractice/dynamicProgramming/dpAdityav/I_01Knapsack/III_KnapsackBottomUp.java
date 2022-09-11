package com.codingpractice.dynamicProgramming.dpAdityav.I_01Knapsack;

import java.util.WeakHashMap;

public class III_KnapsackBottomUp {
    public static void main(String[] args) {
        int N = 3;
        int W = 4;
        int values[] = {1,2,3};
        int weight[] = {4,5,1};

        System.out.println(knapsackRec(values,weight,N,W));

        N = 3;
        W = 3;
        values = new int[]{1,2,3};
        weight = new int[]{4,5,6};

        System.out.println(knapsackRec(values,weight,N,W));
    }

    private static int knapsackRec(int[] values, int[] weight, int n, int w) {

        int dp[][] =new int[n+1][w+1];

        //base is dp[i][0] && d[0][j] =0
        for(int i=1;i<=n;i++){  //numbers
            for(int j=1;j<=w;j++){ //weight
                if(weight[i-1]<=j){   //current weight can be accomadoated in the bag, so 2 choices, take it or leave it
                    dp[i][j] = Math.max(values[i-1] + dp[i-1][j-weight[i-1]],
                            dp[i-1][j]);
                }
                else{ //current weight cant be accomodated, so only one choice, leave it

                    dp[i][j] = dp[i-1][j];
                }

            }
        }

        return dp[n][w];
    }
}
