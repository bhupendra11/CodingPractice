package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class DepthFirstSearch {

	private static boolean visited[];
	private static int parent[];
	private static int s;
	public static void main(String args[]) {
		
       Graph g = new Graph(6,true);
		
		g.addEdge(0, 1);
		g.addEdge(0, 4);
		g.addEdge(1, 2);
		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		
		//g.printGraph();
		
		System.out.println();
		
		DepthFirstSearch dfs = new DepthFirstSearch(g, 0);
		System.out.println(dfs.pathTo(5));
	}
	
	
	public DepthFirstSearch(Graph G, int v) {
		
		this.visited = new boolean[G.v];
		this.parent= new int[G.v];
		this.s=v;
		
		dfs(G,s);
		
	}
	
	private static void dfs(Graph G , int v) {
		visited[v] = true;
		
		for(int w : G.adj(v)) {
			if(!visited[w]) {
				visited[w]=true;
				parent[w] =v;
				dfs(G,w);
			}
				
		}
	}
	private static boolean hasPathTo(int v) {
		return visited[v];
	}
	private static ArrayList<Integer> pathTo(int v){
		ArrayList<Integer> path = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		
		if(!hasPathTo(v))return null;
		path.add(s);
		for(int i =v ; i!=s ; i = parent[i]) {
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			path.add(stack.pop());
		}
		
		
		return path;
	}
}
