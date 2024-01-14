package com.bhupendra.prep2023.graph.toposort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author: Bhupendra Shekhawat
 * Date: 31/10/23
 * Topic: com.prep2023.graph.toposort
 * Question : <a href="https://leetcode.com/problems/course-schedule-ii/">210. Course Schedule II</a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _3_CourseSchedule_II_Toposort_Kahns {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Using Kahn's Topological sort
        List<Integer> result = new ArrayList<>();
        int[] toposort = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        Queue<Integer> q = new LinkedList<>();

        int indegree[] = new int[numCourses];
        for (int[] edge : prerequisites) {
            int ai = edge[0];
            int bi = edge[1];
            // bi -> ai
            indegree[ai]++;
            adjList.get(bi).add(ai);
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int nodesVisited = 0;
        while (!q.isEmpty()) {
            int node = q.remove();
            nodesVisited++;

            result.add(node);
            //remove this node i.e. remove all edges
            for (int neighbor : adjList.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        if (nodesVisited < numCourses) {
            //their is a cycle
            return new int[0];
        }
        for (int i = 0; i < result.size(); i++) {
            toposort[i] = result.get(i);
        }
        return toposort;
    }
}