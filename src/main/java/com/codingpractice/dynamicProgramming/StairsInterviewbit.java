package com.codingpractice.dynamicProgramming;

import java.util.Arrays;

/**
 * 
 * @author Bhupendra Shekhawat
 *
 */
//Problem : https://www.interviewbit.com/problems/stairs/
public class StairsInterviewbit {

	public static void main(String args[]) {
		int n =30;
		
		int dp[] = new int[n+1];
		Arrays.fill(dp, -1);
		int res = distinctWaysClimb(n, dp);
		
		System.out.println(res);
	}

	private static int distinctWaysClimb(int n , int dp[]) {
		
		if(n==0)return 1;
		if(n <0)return 0;
		
		if(dp[n]!=-1)return dp[n];
		
		dp[n] =  distinctWaysClimb(n-1,dp) + distinctWaysClimb(n-2,dp);
		return dp[n];
		
	}
	
}
