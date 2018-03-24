package dynamicProgramming;

import java.util.Scanner;

public class MaximumSqRectangle {

	
	/**
	Sample input
	
	3
	5 6
	0 1 0 1 0 1 1 0 1 0 1 0 0 1 1 1 1 0 0 0 1 1 1 0 1 1 1 1 1 1
	2 2
	1 1 1 1
	2 2
	0 0 0 0
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T ;  i++) { //for each test case
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int j=0; j<n ;j++) {
				for(int k=0; k<m ;k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			
			int res = findMaxMatrix(arr, n ,  m);
			System.out.println(res);
		}
	}

	private static int findMaxMatrix(int[][] arr, int n , int m) {
		
		/*for(int j=0; j<n ;j++) {
			for(int k=0; k<m ;k++) {
				System.out.print(arr[j][k]+" ");
			}
			System.out.println();
		}*/
		int max =0;
				
		int[][] dp = new int[n][m];
		
		//copy first row
		for(int i=0; i<m ;i++ ) {
			dp[0][i] = arr[0][i];
			if(max < dp[0][i]) {
				max = dp[0][i];
			}
		}
		
		//copy first column
		for(int i=0; i<n ;i++ ) {
			dp[i][0] = arr[i][0];
			if(max < dp[i][0]) {
				max = dp[i][0];
			}
		}
		
		//fill rest of the matrix
		
		
		for(int i=1 ;i<n ;i++) {
			for(int j=1; j<m ;j++) {
				
				if(arr[i][j]==1) {					
					dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) +1;		
					
					
				}
				else {
					dp[i][j] =0;
				}
				
				if(max < dp[i][j]) {
					max = dp[i][j];
				}
			}
		}
		
		/*System.out.println("dp arr");
		
		for(int j=0; j<n ;j++) {
			for(int k=0; k<m ;k++) {
				System.out.print(dp[j][k]+" ");
			}
			System.out.println();
		}
		*/
		return max;
	}

}
