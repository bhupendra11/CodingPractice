package com.codingpractice.Graphs;

import java.util.Stack;

public class TopologicalSort {

	private static boolean visited[];
	private static Stack<Integer> stack;
	private static int s;

	public static void main(String args[]) {

		Graph g = new Graph(6, false);

		g.addEdge(5,2);
		g.addEdge(5,0);
		g.addEdge(4,0);
		g.addEdge(4,1);
		g.addEdge(2, 3);
		g.addEdge(3,1);
		// g.printGraph();

		System.out.println();

		TopologicalSort topo = new TopologicalSort(g);
		
		while (!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}

	}

	public TopologicalSort(Graph g) {
		stack = new Stack<>();
		visited = new boolean[g.v];
		
		for (int i = 0; i < g.v; i++) 
			visited[i] = false;

		for (int i = 0; i < g.v; i++) {
			if (!visited[i]) {
				topologicalSort(g, i);
			}
		}

	}

	private static void topologicalSort(Graph g, int v) {

		visited[v] = true;

		for (int w : g.adj(v)) {
			if (!visited[w]) {
				topologicalSort(g, w);
			}
		}
		stack.push(v);
	}

}
