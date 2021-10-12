package com.codingpractice.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PartitionTreeIntoTworPartsWithMinDifference {
	
	
	private static int res;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {0,1,2,3,4,5,6};
		int weight[] = {4,2,1,6,3,5,2};
		
		int total=0;
		
		for(int i=0;i<weight.length;i++) {
			total+= weight[i];
		}
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Tree tree = new Tree();
		
		for(int i=0; i<n ;i++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			
			tree.addEdge(p, q);
		}
		
		res = Integer.MAX_VALUE;
		
		minDiff(tree, total, 0, -1, weight);
		
		System.out.println(res);
		sc.close();
	}
	
	
	public static void minDiff(Tree tree , int total , int v , int parent, int [] subtreeSum) {
		
		int curSum =subtreeSum[v];
		
		for(int u : tree.adj.get(v)) {
			if(u !=parent) {
				minDiff(tree,total,u, v, subtreeSum );
				curSum+= subtreeSum[u];
			}
		}
		
		subtreeSum[v]= curSum;
		
		if( Math.abs(total-2*curSum) < res) {
			res = Math.abs(total-2*curSum);
		}
		
		
		
	}
	
	
	static class Tree{
		
		HashMap<Integer, List<Integer>> adj;
		
		public Tree() {
			adj = new HashMap<>();
		}
		
		public void addEdge(int u, int v) {
			if(adj.get(u)==null) {
				adj.put(u, new ArrayList<>());
			}
			adj.get(u).add(v);
			
			if(adj.get(v)==null) {
				adj.put(v, new ArrayList<>());
			}
			adj.get(v).add(u);
			
		}
		
		
		
	}

}
