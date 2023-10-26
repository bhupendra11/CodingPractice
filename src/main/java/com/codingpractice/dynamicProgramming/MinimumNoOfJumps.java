package com.codingpractice.dynamicProgramming;

public class MinimumNoOfJumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {1,3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		int arr2[] = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
		int arr3[]= {2,1,0,3};
		int dp[] = new int[arr.length];
		
		for(int i=0; i<arr.length;i++) {
			dp[i] = Integer.MIN_VALUE;
		}	
		/*System.out.println(min(arr2,0, dp));
		System.out.println(min(arr2,0));
		System.out.println(min(arr,0));
*/
		System.out.println(min(arr3,0,dp));
	}
	
	private static int min(int arr[], int start, int[] dp) {
		if(start >=arr.length)return -1;
		if(start ==arr.length-1)return 0;
		if(arr[start]==0)return -1;
		
		if(dp[start]!=Integer.MIN_VALUE) {
			return dp[start];
		}
		
		int cur = arr[start];
		int min = Integer.MAX_VALUE;
		
		for(int j=1; j <arr.length && j<= cur ;j++) {
			int nextInd = start+j;
			
			
			int temp = min(arr, nextInd,dp);
			
			
			if(temp !=-1) {
				int curMin =1+ temp;
				if(curMin< min) {
					min = curMin;
				}
			}
			
			
		}
		
		if(min==Integer.MAX_VALUE)return -1;
		dp[start] =min;
		return min;
	}
	
	private static int min(int arr[], int start) {
		if(start >=arr.length)return -1;
		if(start ==arr.length-1)return 0;
		if(arr[start]==0)return -1;
		
		int cur = arr[start];
		int min = Integer.MAX_VALUE;
		
		for(int j=1; j <arr.length && j<= cur ;j++) {
			int nextInd = start+j;
			
			
			int temp = min(arr, nextInd);
			if(temp !=-1) {
				int curMin =1+ temp;
				if(curMin< min) {
					min = curMin;
				}
			}
			
			
		}
		return min;
	}
	
}
