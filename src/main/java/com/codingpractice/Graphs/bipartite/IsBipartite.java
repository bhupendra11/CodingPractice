package com.codingpractice.Graphs.bipartite;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*** IB Question
 * Check whether the graph is bipartite or not
 * Problem Description
 *
 * Given a undirected graph having A nodes. A matrix B of size M x 2 is given which represents the edges such that there is an edge between B[i][0] and B[i][1].
 *
 * Find whether the given graph is bipartite or not.
 *
 * A graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B
 *
 * Note:
 *
 * There are no self-loops in the graph.
 *
 * No multiple edges between two pair of vertices.
 *
 * The graph may or may not be connected.
 *
 * Nodes are Numbered from 0 to A-1.
 *
 * Your solution will run on multiple testcases. If you are using global variables make sure to clear them.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 100000
 *
 * 1 <= M <= min(A*(A-1)/2,200000)
 *
 * 0 <= B[i][0],B[i][1] < A
 *
 *
 *
 * Input Format
 * The first argument given is an integer A.
 *
 * The second argument given is the matrix B.
 *
 *
 *
 * Output Format
 * Return 1 if the given graph is bipartide else return 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 * A = 2
 * B = [ [0, 1] ]
 * Input 2:
 *
 * A = 3
 * B = [ [0, 1], [0, 2], [1, 2] ]
 *
 *
 * Example Output
 * Output 1:
 *
 * 1
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * Put 0 and 1 into 2 different subsets.
 * Explanation 2:
 *
 *
 * It is impossible to break the graph down to make two different subsets for bipartite matching
 *
 */

public class IsBipartite {
    public int solve(int A, int[][] B) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int arr[] : B) {
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }

        Set<Integer> colorA = new HashSet<>();
        Set<Integer> colorB = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < A; i++) {
            if (visited.contains(i)) continue;

            q.add(i);
            colorA.add(i);
            while (!q.isEmpty()) {
                int node = q.remove();
                visited.add(node);
                int currColor = (colorA.contains(node)) ? 0 : 1;
                for (int nbr : adj.get(node)) {

                    if (!colorA.contains(nbr) && !colorB.contains(nbr)) {
                        if (currColor == 0) {
                            colorB.add(nbr);
                        } else {
                            colorA.add(nbr);
                        }
                        q.add(nbr);
                    }
                    //now check if current color set has this nbr
                    else if ((currColor == 0 && colorA.contains(nbr)) || (currColor == 1 && colorB.contains(nbr))) {
                        return 0;
                    }
                }

            }
        }
        return 1;
    }
}

