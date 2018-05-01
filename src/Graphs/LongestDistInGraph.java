package Graphs;

import java.util.Arrays;

public class LongestDistInGraph {
	
	private static int dp[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { -1, 0, 0, 0, 3 };

		Graph g = new Graph(5, true);
		int root;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				root = i;
				continue;
			}
			g.addEdge(i, arr[i]);
		}
		
		dp = new int[g.v];
		Arrays.fill(dp, -1);
		System.out.println(maxDist(g, 0));
		
	}
	
	private static int maxDist(Graph g, int s) {
		
		int best =0;
		
		maxDistUtil(g, s);
		for(int i :dp) {
			if(best < i) {
				best =i;
			}
		}
		return best;
	}
	
	private static int maxDistUtil(Graph g, int v) {
		if(dp[v] != -1) {
			return dp[v];
		}
		dp[v] =1;
		
		for(int u : g.adj(v)) {
			if(dp[v] < maxDistUtil(g, u) +1) {
				dp[v] = dp[u] +1;
			}
		}
		
		return dp[v];
	}

}
