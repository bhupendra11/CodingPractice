package com.codingpractice.dynamicProgramming;

public class WaysSteps {

	public static void main(String args[]) {

		int n = 4;
		int k = 3;
		int dp[] = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			dp[i] = -1;
		}

		System.out.println("No of ways recursive = " + noOfWaysRecursive(n, k));
		System.out.println("No of ways Top Down = " + noOfWaysTopDown(n, k, dp));
		System.out.println("No of ways Botom Up = " + noOfWayBottomUp(n, k));
		System.out.println("No of ways Botom Up Optimized= " + noOfWayBottomUpOptimized(n, k));

	}

	/*
	 * Calculates no. of ways to reach step n provided that a person can jump max k
	 * steps
	 */
	// Time (O(k^n))
	public static int noOfWaysRecursive(int n, int k) {

		if (n < 0) { // IMPORTANT
			return 0;
		}
		if (n == 0) {
			return 1;
		}

		int ans = 0;
		for (int j = 1; j <= k; j++) {
			ans += noOfWaysRecursive(n - j, k);
		}

		return ans;
	}

	/*
	 * Top down DP
	 */

	public static int noOfWaysTopDown(int n, int k, int dp[]) {

		if (n < 0) { // IMPORTANT
			return 0;
		}

		if (n == 0) {
			return 1;
		}

		if (dp[n] != -1) {
			return dp[n];
		} else {
			dp[n] = 0;
			for (int j = 1; j <= k; j++) {
				if (n - j >= 0) {
					dp[n] += noOfWaysTopDown(n - j, k, dp);
				}
			}
			// dp[n] =(int) (noOfWaysTopDown(n-1, dp) +noOfWaysTopDown(n-2, dp)+
			// noOfWaysTopDown(n-3, dp));
			return dp[n];
		}

	}

	/*
	 * Bottom up
	 */
	public static int noOfWayBottomUp(int n, int k) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}

		int dp[] = new int[n + 1];

		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			dp[i] = 0;
			for (int j = 1; j <= k; j++) {
				if (i - j >= 0)
					dp[i] += dp[i - j];
			}
			// System.out.println("dp["+i+"] = "+dp[i]);
		}

		return dp[n];
	}

	/*
	 * Bottom up optimized
	 * 
	 * dp[n+1] is nothing but (sum of prev k elements in dp arr(dp[n]) and current
	 * element (dp[n]) subtracting the (n-k)th element i.e for every elemnet you add
	 * the current element and subtract the (n-k)th element from the sum dp[n+1] =
	 * dp[n] +d[n] - dp[n-k]
	 */
	public static int noOfWayBottomUpOptimized(int n, int k) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}

		int dp[] = new int[n + 2];

		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = 0;

			dp[i] = 2 * (dp[i - 1]) - ((i - k - 1 < 0) ? 0 : dp[i - k - 1]);
			//System.out.println("dp[" + i + "] = " + dp[i]);
		}

		return dp[n];
	}
}
