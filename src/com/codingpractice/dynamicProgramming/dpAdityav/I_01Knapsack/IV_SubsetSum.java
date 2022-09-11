package com.codingpractice.dynamicProgramming.dpAdityav.I_01Knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IV_SubsetSum {

    public static void main(String[] args) {
        /**
         * Input 1:
         *
         *  A = [3, 34, 4, 12, 5, 2]
         *  B = 9
         * Input 2:
         *
         *  A = [3, 34, 4, 12, 5, 2]
         *  B = 30
         */

        List<Integer> list1 = Arrays.asList(3, 34, 4, 12, 5, 2);
        System.out.println(solve(list1,9));
         list1 = Arrays.asList(3, 34, 4, 12, 5, 2);
        System.out.println(solve(list1,30));
    }

    public static int solve(List<Integer> A, int B) {

        int n = A.size();

        return solve(A,B,n) ? 1:0;
    }

    private static boolean solve(List<Integer> A, int B, int n){
        boolean dp[][] = new boolean[n+1][B+1];

        dp[0][0] = true;  //empty array with 0 sum

        for(int i=0;i<=n;i++){
            for(int j=0;j<=B;j++){
                if(i==0){ //empty array
                    dp[i][j] = false;
                }
                if(j==0){ // sum =0
                    dp[i][j] = true;    //choose empty set
                }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=B;j++){
                if(A.get(i-1) <=j){
                    dp[i][j] = dp[i-1][j-A.get(i-1)] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][B];

    }
}
