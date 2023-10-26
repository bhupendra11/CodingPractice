package com.codingpractice.dynamicProgramming.I_01knapsack;

public class II_01Knapsack_BottomUp {
    public static void main(String[] args) {
        int N = 3;
        int W = 4;
        int values[] = {1,2,3};
        int weight[] = {4,5,1};

        System.out.println(knapSack(W,weight,values,N));

        N = 3;
        W = 3;
        values = new int[]{1,2,3};
        weight = new int[]{4,5,6};

        System.out.println(knapSack(W,weight,values,N));
    }

    private static int knapSack(int w, int[] weight, int[] values, int n) {

        int dp[][] = new int[w+1][n+1];
        //dp[i][j] stores the max  value for weight i and j items

        for(int i=0;i<=w;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=n;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<=w;i++){
            for(int j=1;j<=n;j++){
                if(weight[j-1] <= i){
                    dp[i][j] = Math.max(values[j-1]+ dp[i-weight[j-1]][j-1], dp[i][j-1]);
                }
                else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[w][n];
    }
}
