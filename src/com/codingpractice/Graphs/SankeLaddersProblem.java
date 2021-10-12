package com.codingpractice.Graphs;

import java.security.SignatureException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SankeLaddersProblem {
	
	public static void main(String args[]) {
		Graph g = new Graph(false);
		
		int board[] = new int[42];
		board[2]=13;
		board[5]=2;
		board[9]=18;
		board[18]=11;
		board[17]=-13;
		board[20]=-14;
		board[24]=-8;
		board[25]=-10;
		board[32]=-2;
		board[34]=-22;
		
		//insert edges
		for(int u=0; u<36;u++) {
			
			for(int dice=1 ;dice <= 6;dice++) {
				int v = u +dice + board[u+dice];
				g.addEdge(u, v);
				
			}
		}
		
		g.bfs(0, 36);
	}
	
	

	
	public static class Graph {

		HashMap<Integer, ArrayList<Integer>> map;
		boolean isBiDirectional;

		Graph(boolean isBiDirectional) {
			map = new HashMap<>();
			this.isBiDirectional = isBiDirectional;
		}
		
		public void addEdge(int u, int  v) {
			if(map.get(u) == null) 	map.put(u, new ArrayList<>());
			if(map.get(v) == null) 	map.put(v, new ArrayList<>());
			
			map.get(u).add(v);
			
			if(isBiDirectional) {
				map.get(v).add(u);
			}
			
		}
		
		public void printGraph() {
			
			for(int i : map.keySet()) {
				System.out.print(i+"-->");
				
				for(int node : map.get(i)) {
					System.out.print(node+",");
				}
				System.out.println();
			}
		}
		
		public void bfs(int start, int dest) {
			Queue<Integer> q = new LinkedList<>();
			int n = map.size();
			boolean visited[] = new boolean[n];
			
			//to calculate distance from start node
			int dist[] = new int[n];
			
			//To be used to print the path from start node
			int parent[] = new int[n];
			
			q.add(start);
			visited[start] = true;
			dist[start]=0;
			parent[0]=-1;
			
			while(!q.isEmpty()) {
				int node = q.poll();
				
				for(int i : map.get(node)) {
					if(!visited[i]) {
						q.add(i);
						visited[i] =true;
						dist[i] = dist[node]+1;
						parent[i] = node;
					}
				}
			}
			
			
			
			
			//Print distances from start
			/*System.out.println("Start Node = "+start);
			for(int i=0; i<n;i++) {
				System.out.println("Node "+i+" --> distance = "+dist[i]);
			}*/
			
			//shortest distance to destination 
			System.out.println("Shortest distance = "+dist[dest]);
			
			//Print the shortest path from start node to dest node
			int temp = dest;
			
			while(temp != -1) {
				System.out.print(temp+"<---");
				temp =parent[temp];
			}
			
			
		}
	}
}
