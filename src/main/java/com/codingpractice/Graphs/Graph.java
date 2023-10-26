package com.codingpractice.Graphs;

import java.util.ArrayList;

public class Graph {

	public int v;
	private ArrayList<Integer> listArray[];
	boolean isBiDirectional =false;
	
	Graph(int v, boolean isBiDirectional){
		this.v =v;
		this.isBiDirectional = isBiDirectional;
		listArray = new ArrayList[v];
		for(int i=0;i<v;i++) {
			listArray[i] = new ArrayList<>();
		}
	}
	
	public void addEdge(int u, int v ) {
		listArray[u].add(v);		
		if(isBiDirectional) {
			listArray[v].add(u);
		}
	}
	
	
	
	public void printGraph() {
		
		for(int i=0; i<v;i++) {
			System.out.print(i+"--> ");
			for(int node : this.listArray[i]) {
				System.out.print(node+",");
			}
			System.out.println();
		}
	}
	
	public ArrayList<Integer> adj(int v){
		return this.listArray[v];
	}
	
	/**
	 *    0--------s1
	 *    |      /   \
	 *    |    /        \
	 *    |  /            \
	 *    2--------3-------4
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		Graph g = new Graph(5,true);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		
		g.printGraph();
		
		
	}
}
