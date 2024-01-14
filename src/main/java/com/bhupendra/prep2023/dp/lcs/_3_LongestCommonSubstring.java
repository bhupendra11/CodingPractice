package com.bhupendra.prep2023.dp.lcs;


/**
 * Author: Bhupendra Shekhawat
 * Date: 15/12/23
 * Topic: com.prep2023.dp.lcs
 * Question : <a href="https://www.geeksforgeeks.org/problems/longest-common-substring1452/1"></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _3_LongestCommonSubstring {
    int longestCommonSubstr(String S1, String S2, int n, int m){
        int dp[][] = new int[n+1][m+1];
        int max =0;
        for(int i=1;i<=n ;i++){
            for(int j=1;j<=m;j++){

                if(S1.charAt(i-1) == S2.charAt(j-1) ){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 0;
                }

                max = Math.max (dp[i][j], max);
            }
        }

        return max;
    }
}
