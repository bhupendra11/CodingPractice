package dynamicProgramming;

import java.util.Arrays;

public class MaxSumIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,101,2,3,100,4,5};
		int arr2[] = {3,4,5,10};
		int arr3[] = {10,5,4,3};
		
		int dp[] = new int[arr.length];
		Arrays.fill(dp, -1);
		System.out.println(maxSumIncreasingSub(arr, 0, 0,dp));
		//System.out.println(maxSumIncreasingSub(arr2, 0, 0));
		//System.out.println(maxSumIncreasingSub(arr3, 0, 0));
		
	}
	
	private static int maxSumIncreasingSub(int arr[], int start, int last , int[] dp) {
		
		if(start==arr.length) {
			return 0;
		}
		
		if(dp[start]!=-1) {
			return dp[start];
		}
		
		int taking =0;
		if(last <arr[start]) {
			taking = arr[start] + maxSumIncreasingSub(arr, start+1, arr[start],dp);
		}
		
		int notTaking = maxSumIncreasingSub(arr, start+1, last,dp);
		
		dp[start] = Math.max(taking, notTaking);
		return dp[start];
	}
}
