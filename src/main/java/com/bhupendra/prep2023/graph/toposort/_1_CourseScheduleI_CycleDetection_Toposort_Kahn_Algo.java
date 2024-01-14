package com.bhupendra.prep2023.graph.toposort;


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

public class _1_CourseScheduleI_CycleDetection_Toposort_Kahn_Algo {

        //Approach 2: This kahn toposort implementation is much better,
        // traverse like level order, just levels are determined by indegree
        // Topo sort using kahn's

        // TC: O(V+E)
        //SC O(V+E)
        public boolean canFinish2(int numCourses, int[][] prerequisites) {
            if(prerequisites.length ==0)return true;
            List<List<Integer>> adjList = new ArrayList<>();
            for(int i=0;i<numCourses ;i++){
                adjList.add(new ArrayList<>());
            }

            //create adjList, get indegree
            int indegree[] = new int[numCourses];
            for(int edge[] : prerequisites){
                int ai = edge[0];
                int bi = edge[1];

                adjList.get(bi).add(ai);
                // bi -> ai
                indegree[ai]++;
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i=0;i<numCourses;i++){
                if(indegree[i] == 0){
                    q.add(i);
                }
            }

            int nodesVisited = 0;
            while (!q.isEmpty()){
                int node = q.remove();
                nodesVisited ++;

                //process, i.e remove this node i.e edges from this node
                for(int neighbor : adjList.get(node)){
                    indegree[neighbor]--;
                    if(indegree[neighbor] == 0){
                        q.add(neighbor);
                    }
                }
            }

            return nodesVisited == numCourses;
        }

         //Approach 1: This kahn toposort implementation is quite slow
        //Lets use Topo sort using kahn's
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if(prerequisites.length ==0)return true;
            // 1 . sort the vertices in terms of their indegree

            int indegree[] = new int[numCourses]; //all zero initially
            int nextNode =0; // node with zero indegree
            // prerequisites[i] = [ai, bi] , then edge bi -> ai
            for(int[] edge : prerequisites ){
                int ai = edge[0];
                int bi = edge[1];
                // bi -> ai
                indegree[ai]++;
            }

            for(int i=0;i<numCourses ;i++){
                if(indegree[i]==0){
                    nextNode = i;
                }
            }

            Set<Integer> visited = new HashSet<>();

            while(visited.size() < numCourses ){
                int indeg = indegree[nextNode];
                if(visited.contains(nextNode) || indeg != 0) {
                    // no next node with indegree 0, there is a cycle
                    return false;
                }

                //can process this node, so remove it from graph
                visited.add(nextNode);
                for(int[] edge : prerequisites ){
                    int ai = edge[0];
                    int bi = edge[1];
                    // bi -> ai
                    if(nextNode == bi){
                        indegree[ai]--;
                    }
                }
                for(int i=0;i<numCourses ;i++){
                    if(!visited.contains(i) && indegree[i]==0){
                        nextNode = i;
                    }
                }
                if(indegree[nextNode] !=0)return false;
            }
            return true;

        }

    public static void main(String[] args) {
        _1_CourseScheduleI_CycleDetection_Toposort_Kahn_Algo courseSchedule = new _1_CourseScheduleI_CycleDetection_Toposort_Kahn_Algo();

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