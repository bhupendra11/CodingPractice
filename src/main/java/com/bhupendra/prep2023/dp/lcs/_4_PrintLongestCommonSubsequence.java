package com.bhupendra.prep2023.dp.lcs;


import java.util.Arrays;

/**
 * Author: Bhupendra Shekhawat
 * Date: 15/12/23
 * Topic: com.prep2023.dp.lcs
 * Question : <a href="https://www.codingninjas.com/studio/problems/print-longest-common-subsequence_8416383"></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _4_PrintLongestCommonSubsequence {
    public static String findLCS(int n, int m, String s1, String s2) {
        String dp[][] = new String[n+1][m+1];
        for(String[] arr: dp){
            Arrays.fill(arr, "");
        }

        for(int i=1;i<=n ;i++){
            for(int j=1;j<=m ;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + s1.charAt(i-1);
                }
                else{
                    dp[i][j] = dp[i-1][j].length() >  dp[i][j-1].length() ? dp[i-1][j] : dp[i][j-1];
                }
            }
        }

        for(int i=1;i<=n ;i++){
            for(int j=1;j<=m ;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("LCS length = "+dp[n][m]);

        return "";
    }

    //Approach 2 : FInd LCS STring using LCS length
    public static String findLCSUsingLCSLength(int n, int m, String s1, String s2) {
        int dp[][] = new int[n+1][m+1];

        for(int i=1;i<=n ;i++){
            for(int j=1;j<=m ;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1] ;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println("LCS length = "+dp[n][m]);

        int i=n , j =m;

        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(dp[i-1][j] >= dp[i][j-1]){
                    i--;
                }
                else{
                    j--;
                }
            }
        }



        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(findLCSUsingLCSLength(5,6,"ababa","cbbcad"));
        System.out.println(findLCSUsingLCSLength(8,8,"bcacaaab","bbabaccc"));
    }
}
