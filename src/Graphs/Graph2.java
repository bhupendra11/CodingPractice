package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph2 {

	HashMap<Integer, ArrayList<Integer>> map;
	boolean isBiDirectional;

	Graph2(boolean isBiDirectional) {
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
			//System.out.print(node+" ");
			
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
		System.out.println("Start Node = "+start);
		for(int i=0; i<n;i++) {
			System.out.println("Node "+i+" --> distance = "+dist[i]);
		}
		
		
		//Print the shortest path from start node to dest node
		int temp = dest;
		
		while(temp != -1) {
			System.out.print(temp+"<---");
			temp =parent[temp];
		}
		
	}
	
	/**
	 *    0------- 1
	 *    |      / |   
	 *    |    /   |     
	 *    |  /     |       
	 *    4--------2
	 *    \       /
	 *     \     /
	 *      \  / 
	 *       3-------5 
	 * @param args
	 */
	public static void main(String args[]) {
		Graph2 g = new Graph2(true);
		
		g.addEdge(0, 1);
		g.addEdge(0, 4);
		g.addEdge(1, 2);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		
		//g.printGraph();
		g.bfs(0,5);
		
		System.out.println();
		
		
	}

}
