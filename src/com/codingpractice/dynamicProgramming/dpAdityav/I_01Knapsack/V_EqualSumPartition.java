package com.codingpractice.dynamicProgramming.dpAdityav.I_01Knapsack;

import java.util.Arrays;
import java.util.Collections;

/**
 * Find if in an array, their is a way to split it into two partitions sunch that the sum of both partitions is equals
 * Th partitions would be subsets of the parent array.
 *
 */
public class V_EqualSumPartition {
    public static void main(String[] args) {

        int arr[] = {1,5,11,5};

        System.out.println(isEqualPartitionable(arr));

        arr = new int[]{1,5,11,5,2};

        System.out.println(isEqualPartitionable(arr));

        arr = new int[]{1,5,11,5,6};

        System.out.println(isEqualPartitionable(arr));
    }

    private static boolean isEqualPartitionable(int[] arr) {

        //check if sum is even
        int sum =Arrays.stream(arr).reduce(0,Integer::sum);
        System.out.println("sum = "+sum);
        //if sum is odd, no way to  split into equal partition
        if(sum %2 !=0)return false;

        //Now we just need to find one partition with  totalsum = sum/2;
        return isSubsetSum(arr,sum/2);
    }

    private static boolean isSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean dp[][] = new boolean[n+1][sum+1];

        dp[0][0] = true;  // zero sum , with no elements

        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum ;j++){
                if(i==0){ //no items
                    dp[i][j] = false;
                }
                if(j==0){ //sum =0 , take empty set
                    dp[i][j] = true;
                }
            }
        }

        for(int i=1;i<=n;i++) {
            for (int j = 1; j <= sum; j++) {
                if(arr[i-1] <=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];

    }


}
