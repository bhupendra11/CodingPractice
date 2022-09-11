package com.codingpractice.dynamicProgramming.dpAdityav.I_01Knapsack;

/**
 * Give count of subsets with given sum
 */
public class VI_CountOfSubsetsSumWithGivenSum {
    public static void main(String[] args) {

        int arr[] = {2,3,5,6,8,10};

        System.out.println(countOfSubsetsWithSum(arr,10));

        arr = new int[]{3,5,6,7};

        System.out.println(countOfSubsetsWithSum(arr,9));

        arr = new int[]{1,2,3,3};

        System.out.println(countOfSubsetsWithSum(arr,6));

        arr = new int[]{1,1,1,1};

        System.out.println(countOfSubsetsWithSum(arr,1));
    }

    private static int countOfSubsetsWithSum(int[] arr, int sum) {
        int n = arr.length;
        int dp[][] = new int[n+1][sum+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                if(i==0){ //no elements
                    dp[i][j] =0;
                }
                if(j==0){ // sum =0 possible with empty set
                    dp[i][j] =1;
                }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++) {
                if(arr[i-1] <=j){
                    //sum both including the cur element + excluding the cur element
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }
}
