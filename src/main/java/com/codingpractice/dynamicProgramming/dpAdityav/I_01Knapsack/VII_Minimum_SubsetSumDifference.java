package com.codingpractice.dynamicProgramming.dpAdityav.I_01Knapsack;

import java.util.Arrays;

public class VII_Minimum_SubsetSumDifference {
    public static void main(String[] args) {
        int arr[] = {76,8,45,20,74,84,28,1};
        //{-36,36};//{3,9,7,3}; //{1,2,3,4,5,6};
        int range =  Arrays.stream(arr).sum();
        boolean[] subsetSumArr = subsetSUm(arr, range);

        int min = Integer.MAX_VALUE;
        for(int i=0;i<=range/2;i++){
            if(subsetSumArr[i]){
                min = Math.min(min, range -2*i);
            }
        }
        System.out.println(min);
    }

    private static boolean[] subsetSUm(int arr[], int range){
        int n = arr.length;

        boolean dp[][] = new boolean[n+1][range+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=range;j++){
                if(i==0){   //no element
                    dp[i][j] = false;
                }
                if(j==0){ //sum =0;
                    dp[i][j] = true;  //choose empty set
                }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=range;j++) {
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j]  = dp[i-1][j];
                }
            }
        }

        boolean useful[] = new boolean[range+1];
        for(int i=0;i<=range;i++){
            useful[i]  = dp[n][i];
        }
        return useful;
    }
}
