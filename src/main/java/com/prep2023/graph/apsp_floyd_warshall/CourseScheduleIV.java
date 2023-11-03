package com.prep2023.graph.apsp_floyd_warshall;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Bhupendra Shekhawat
 * Date: 03/11/23
 * Topic: com.prep2023.graph.apsp_floyd_warshall
 * Question : <a href="https://leetcode.com/problems/course-schedule-iv/">1462. Course Schedule IV</a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class CourseScheduleIV {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Use floyd wharshall to find
        // all pairs shortest path (APSP)
        // and then answer the queries

        // in this case we will just check reachability instead of shortest distance
        int n = numCourses;  // from 0 to n-1
        boolean reachable[][] = new boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    reachable[i][j] = true;
                }
                else{
                    reachable[i][j] = false;
                }
            }
        }

        // fill edges
        //  prerequisites[i] = [ai, bi]
        // ai -> bi

        for(int edge[] : prerequisites){
            int ai = edge[0];
            int bi = edge[1];
            // ai-> bi
            reachable[ai][bi] = true;
        }

        //do floyd warshall relaxation
        // do for N iterations
        for(int k =0; k<n ; k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){

                    reachable[i][j] = reachable[i][j] || (reachable[i][k] && reachable[k][j]);
                }
            }
        }

        List<Boolean> answer = new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            int u = queries[i][0];
            int v = queries[i][1];
            answer.add(reachable[u][v]);
        }

        return answer;
    }
}