package dynamicProgramming;

import java.util.Scanner;

/**
 * 
 * @author Bhupendra Shekhawat
 *
 */

/* Problem
 * Given a N X N  matrix Matrix[N][N] of positive integers.  There are only three possible moves from a cell Matrix[r][c].

1. Matrix[r+1][c]

2. Matrix[r+1][c-1]

3. Matrix[r+1][c+1]

Starting from any column in row 0, return the largest sum of any of the paths up to row N-1.
 */


public class MaximumSumMatrixPath {

	
	/*
	 
	 1
	 2
	 348 391 618 193
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=0; t<T ;t++) {
			int n = sc.nextInt();
			int arr[][] = new int[n][n];
			for(int i=0; i<n ;i++) {
				for(int j=0; j<n ;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(maxPathSum(arr));
			
		}
		
		
	}
	
	private static int maxPathSum(int arr[][]) {
		int sum =0;
		int n = arr.length;
		int dp[][] = new int[n][n];
		dp[0][0] = arr[0][0];
		
		//fill first row
		for(int i=1; i<n ;i++) {
			dp[0][i] = arr[0][i];
		}
		
		//fill first col
		/*for(int i=1; i<n ;i++) {
			dp[i][0] = dp[i-1][0] +arr[i][0];
		}*/
		int max =0;
		for(int i=1; i<n ;i++) {
			for(int j=0; j<n ;j++) {
				
				if(j==0) {
					dp[i][j] = arr[i][j] + Math.max(dp[i-1][j], dp[i-1][j+1]);
				}
				else if(j==n-1) {
					dp[i][j] = arr[i][j] + Math.max(dp[i-1][j], dp[i-1][j-1]);
				}
				else
				
				dp[i][j] = arr[i][j] + Math.max(Math.max(dp[i-1][j], dp[i-1][j-1]), dp[i-1][j+1]);
				
				if(dp[i][j] > max) {
					max = dp[i][j];
				}
			}
		}
		
		
		return max;
	}
}
