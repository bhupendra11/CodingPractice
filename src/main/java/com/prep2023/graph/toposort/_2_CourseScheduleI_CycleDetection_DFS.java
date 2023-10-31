package com.prep2023.graph.toposort;


import java.util.*;

/**
 * Author: Bhupendra Shekhawat
 * Date: 31/10/23
 * Topic: com.prep2023.graph.toposort
 * Question : <a href="https://leetcode.com/problems/course-schedule/">207. Course Schedule</a>
 * YouTube : <a href="">Link to YouTube</a>
 */

//we can finish all courses only when their is no cycle

// Muktiple ways to find a cycle
// 1. Using DFS
// 2. Using Topological sort for directed graph (Using Kahn ALgorithm)
// 3. Using graph coloring with 3 colors

public class _2_CourseScheduleI_CycleDetection_DFS {

    // This is implementation 1. Using DFS
    // TC: O(V+E)
    //SC O(V+E)

    boolean visited[];
    boolean inStack[];

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int edge[] : prerequisites) {
            int ai = edge[0];
            int bi = edge[1];
            //bi -> ai
            adjList.get(bi).add(ai);
        }

        visited = new boolean[numCourses]; //to track visited nodes
        inStack = new boolean[numCourses]; // to tack nbodes currently in stack

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i, adjList)) return false;
            }
        }
        return true;
    }

    //return true if their is a cycle , else false
    private boolean dfs(int node, List<List<Integer>> adjList) {
        if (inStack[node]) return true; // node already in current traversing stack , so cycle
        if (visited[node]) return false; //already traversed , no cyelces found

        //Mark current node visited and add in current recursing stack
        visited[node] = true;
        inStack[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (dfs(neighbor, adjList)) {
                return true;
            }
        }
        //remove cur node from stack, backtrack
        inStack[node] = false;
        return false;
    }

    public static void main(String[] args) {
        _2_CourseScheduleI_CycleDetection_DFS courseSchedule = new _2_CourseScheduleI_CycleDetection_DFS();

        // Test Case 1: A simple case with no prerequisites, should return true
        int[][] prerequisites1 = {};
        boolean result1 = courseSchedule.canFinish(3, prerequisites1);
        System.out.println("Test Case 1: Can finish all courses: " + result1); // Should return true

        // Test Case 2: Courses form a linear dependency chain, should return true
        int[][] prerequisites2 = { { 1, 0 }, { 2, 1 }, { 3, 2 } };
        boolean result2 = courseSchedule.canFinish(4, prerequisites2);
        System.out.println("Test Case 2: Can finish all courses: " + result2); // Should return true

        // Test Case 3: Courses form a cyclic dependency, should return false
        int[][] prerequisites3 = { { 1, 0 }, { 2, 1 }, { 0, 2 } };
        boolean result3 = courseSchedule.canFinish(3, prerequisites3);
        System.out.println("Test Case 3: Can finish all courses: " + result3); // Should return false

        // Test Case 4: No courses, should return true
        int[][] prerequisites4 = {};
        boolean result4 = courseSchedule.canFinish(0, prerequisites4);
        System.out.println("Test Case 4: Can finish all courses: " + result4); // Should return true
    }

}