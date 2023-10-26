package com.codingpractice.dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author Bhupendra Shekhawat
 *
 */
/*
 Problem:
 Given an integer N denoting the Length of a line segment. you need to cut the line segment in such a way that the cut length 
 of a line segment each time is integer either x , y or z. and after performing all cutting operation the total number of 
 cutted segments must be maximum. 

Sample test case:
2
4
2 1 1
5
5 3 2

 */
public class RodCuttingMaxCount {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int t=0; t<T ;t++) {
			int N = sc.nextInt();
			int arr[] = new int[3];
			for(int i=0; i<3;i++) {
				arr[i] = sc.nextInt();
			}
			
			int res1 = cutRodMax2(N, arr);
			System.out.println(res1);
			
			int dp[] = new int[N+1];
			Arrays.fill(dp, -1);
			int res = cutRodMaxDp(N, arr, dp);
			System.out.println(res);
		}
	}

	
	private static int cutRodMax2(int n, int[] arr) {
	
		if(n==0) {
			return 0;
		}
		if(n<0) {
			return Integer.MIN_VALUE;
		}
		
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<arr.length;i++) {
				max = Math.max(max, 1+cutRodMax2(n-arr[i], arr));				
		}
		
		return max;
		
	}
	
	
	private static int cutRodMaxDp(int n, int[] arr, int[] dp) {
		// TODO Auto-generated method stub
		if(n==0) {
			return 0;
		}
		if(n<0) {
			return Integer.MIN_VALUE;
		}
		
		if(dp[n]!= -1)return dp[n];
		
		for(int i=0; i<arr.length;i++) {
				dp[n] = Math.max(dp[n], 1+cutRodMaxDp(n-arr[i], arr, dp));
					
			
		}
		if(dp[n]==-1)dp[n] =Integer.MIN_VALUE;
		return dp[n];
		
	}
}
