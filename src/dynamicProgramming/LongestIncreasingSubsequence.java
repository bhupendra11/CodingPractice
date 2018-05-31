package dynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,4,-1,0,6,2,3}; 
		        //  = {1,2, 1,2,3,3,4}
		int lis = findLis(arr);		
		System.out.println(lis);
	}

	private static int findLis(int[] arr) {
		// TODO Auto-generated method stub
		int dp[] = new int[arr.length];
		Arrays.fill(dp, 1);
		for(int i=1; i<arr.length;i++) {
			for(int j=0; j<i;j++) {
				
				if(arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
				else continue;
				
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i:dp) {
			if(i> max)max =i;
		}
		
		return max;
	}

}
