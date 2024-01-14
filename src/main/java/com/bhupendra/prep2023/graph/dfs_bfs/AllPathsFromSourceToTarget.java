package com.bhupendra.prep2023.graph.dfs_bfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Bhupendra Shekhawat
 * Date: 30/10/23
 * Topic: com.prep2023.graph.dfs_bfs
 * Question : <a href="https://leetcode.com/problems/all-paths-from-source-to-target/">797. All Paths From Source to Target</a>
 * YouTube : <a href="">Link to YouTube</a>
 *
 * MEDIUM
 */
public class AllPathsFromSourceToTarget {
    int dest;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        int n = graph.length;
        dest = n-1;
        boolean visited[] = new boolean[n];

        path.add(0);
        dfs(graph, 0, path, result);
        return result;
    }

    private void dfs(int[][] graph, int curNode, List<Integer> path, List<List<Integer>> result){
        if(curNode == dest){
            result.add(new ArrayList<>(path));
            return;
        }

        int[] next = graph[curNode];
        for(int nextNode : next){
            path.add(nextNode);
            dfs(graph, nextNode, path, result);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        AllPathsFromSourceToTarget solution = new AllPathsFromSourceToTarget();

        int[][] graph1 = {{1, 2}, {3}, {3}, {}};
        List<List<Integer>> result1 = solution.allPathsSourceTarget(graph1);
        System.out.println("Test Case 1:");
        printPaths(result1);

        int[][] graph2 = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        List<List<Integer>> result2 = solution.allPathsSourceTarget(graph2);
        System.out.println("Test Case 2:");
        printPaths(result2);
    }

    private static void printPaths(List<List<Integer>> paths) {
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}
