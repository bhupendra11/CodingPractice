package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WaysOfGettingChange {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0; t<T ;t++) {
			int M = sc.nextInt();
			int arr[] = new int[M];
			for(int i=0; i<M ;i++) {
				arr[i] = sc.nextInt();
			}
			int N = sc.nextInt();
			Arrays.sort(arr);

			/*for(int i :arr) {
				System.out.print(i+" ");
			}*/
			
			
			int dp[][] = new int[N+1][arr.length+1];
			
			int res = getChangeWays(arr, N, 0, dp);
			System.out.println(res);
			
			}
	}
	
	private static int getChangeWays(int arr[] , int sum, int start, int[][] dp) {
		
		if(sum ==0) {
			return 1;
		}
		if(sum <0)return 0;
		if(start >= arr.length && sum >=1)return 0;
		
		if(dp[sum][start]!=0)return dp[sum][start];
		
		return dp[sum][start] = getChangeWays(arr, sum, start+1, dp) +getChangeWays(arr, sum-arr[start], start, dp);
	}
}
