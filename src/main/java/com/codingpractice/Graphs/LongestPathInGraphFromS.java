package com.codingpractice.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LongestPathInGraphFromS {

    private static boolean visited[];
    private static Stack<Integer> stack;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int arr[] = {-1, 0, 0, 0, 3};

        Graph g = new Graph(5, true);
        int root;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                root = i;
                continue;
            }
            g.addEdge(i, arr[i]);
        }


        LongestPathInGraphFromS lpg = new LongestPathInGraphFromS();
        lpg.largestDistance(g, 1);
    }

    private static ArrayList<Integer> topoLogicalSort(Graph g) {
        ArrayList<Integer> list = new ArrayList<>();
        stack = new Stack<>();
        visited = new boolean[g.v];

        for (int i = 0; i < g.v; i++) {
            if (!visited[i])
                topoUtil(g, i);
        }

        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

        return list;
    }

    private static void topoUtil(Graph g, int v) {

        visited[v] = true;
        for (int w : g.adj(v)) {
            if (!visited[w]) {
                topoUtil(g, w);
            }
        }
        stack.push(v);
    }

    private static void largestDistance(Graph g, int s) {

        ArrayList<Integer> order = topoLogicalSort(g);
        int dist[] = new int[g.v + 1];
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[s] = 0;
        for (int v : order) {

            if (dist[v] != Integer.MIN_VALUE) {
                for (int u : g.adj(v)) {
                    if (dist[u] < dist[v] + 1) {
                        dist[u] = dist[v] + 1;
                    }
                }
            }
        }


        for (int i : dist) {
            System.out.print(i + " ");
        }

    }
}
