package com.prep2023.dp.lcs;

import java.util.Arrays;

public class _1_LongestCommonSubsequenceTopDown {
    int dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        dp = new int[m+1][n+1];
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }
        return lcs(text1, m -1, text2, n -1);
    }

    private int lcs(String text1, int i, String text2, int j){
        if(i< 0 || j<0){
            return 0;
        }

        if(dp[i][j] != -1)return dp[i][j];

        if(text1.charAt(i) == text2.charAt(j)){
            dp[i][j] = 1 + lcs(text1, i-1, text2, j-1);
        }
        else{
            dp[i][j] = Math.max(lcs(text1, i-1, text2, j) , lcs(text1,i,text2,j-1));
        }
        return dp[i][j];
    }

    private int lcsRecursive(String text1, int i, String text2, int j){
        if(i< 0 || j<0){
            return 0;
        }

        if(text1.charAt(i) == text2.charAt(j)){
            return 1 + lcs(text1, i-1, text2, j-1);
        }
        return Math.max(lcs(text1, i-1, text2, j) , lcs(text1,i,text2,j-1));
    }
}
