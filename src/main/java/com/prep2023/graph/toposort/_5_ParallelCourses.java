package com.prep2023.graph.toposort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author: Bhupendra Shekhawat
 * Date: 01/11/23
 * Topic: com.prep2023.graph.toposort
 * Question : <a href="https://leetcode.com/problems/parallel-courses/">1136. Paralel Courses</a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _5_ParallelCourses {
    public int minimumSemesters(int n, int[][] relations) {
        //Topological sort using kahn's algo
        int indegree[] = new int[n+1];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : relations){
            int u = edge[0];
            int v = edge[1];
            // u ->v
            adjList.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q= new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(indegree[i] ==0){
                q.add(i);
            }
        }

        //level identifier
        q.add(-1);

        int nodeVisited =0;
        int levels = 0;
        while(!q.isEmpty()){
            int curNode = q.remove();
            if(curNode == -1 && q.isEmpty()){
                levels++;
                break;
            }
            if(curNode == -1){
                levels++;
                q.add(-1);
                continue;
            }
            nodeVisited++;

            //remove this node
            for(int nbr : adjList.get(curNode)){
                indegree[nbr]--;
                if(indegree[nbr] ==0){
                    q.add(nbr);
                }
            }
        }

        if(nodeVisited < n)return -1;
        return levels;
    }
}
