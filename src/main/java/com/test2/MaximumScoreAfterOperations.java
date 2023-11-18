package com.test2;

import java.util.ArrayList;
import java.util.List;

public class MaximumScoreAfterOperations {

    static class TreeNode {
        int node;
        int val;
        List<TreeNode> neighbors;

        TreeNode(int node, int val) {
            this.node = node;
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n = values.length;
        TreeNode[] nodes = new TreeNode[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new TreeNode(i, values[i]);
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            nodes[u].neighbors.add(nodes[v]);
            nodes[v].neighbors.add(nodes[u]);
        }

        int[] maxScoreSubtree = new int[n];
        int[] sumScoreSubtree = new int[n];
        int[] parentPathSum = new int[n];
        dfs(nodes[0], null, maxScoreSubtree, sumScoreSubtree,parentPathSum);


        return maxScoreSubtree[0];
    }

    void dfs(TreeNode node, TreeNode parent, int[] maxScore, int[] sumScore, int[] parentPathSum) {

        if (node == null) return;

        if (parent == null) {
            parentPathSum[node.node] = node.val;
        } else {
            parentPathSum[node.node] = parentPathSum[parent.node] + node.val;
        }
        System.out.println("Inside node"+node.node+" parentPathsum = "+parentPathSum[node.node]);
        int case1 = 0;
        int case2 = node.val;
        int case3 = 0;

        for (TreeNode child : node.neighbors) {
            if (child == parent) continue;

            dfs(child, node, maxScore, sumScore, parentPathSum);

            case1 = Math.max(case1, maxScore[child.node]);
        }

        if (parentPathSum[node.node] == 0) {
            case2 = 0;
        }

        maxScore[node.node] = Math.max(case1, Math.max(case2, case3));

    }
    public static void main(String[] args) {
        MaximumScoreAfterOperations solution = new MaximumScoreAfterOperations();

        // Example 1
        int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {2, 4}, {4, 5}};
        int[] values1 = {5, 2, 5, 2, 1, 1};
        System.out.println(solution.maximumScoreAfterOperations(edges1, values1));  // Output: 11

        // Example 2
        int[][] edges2 = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
        int[] values2 = {20, 10, 9, 7, 4, 3, 5};
        System.out.println(solution.maximumScoreAfterOperations(edges2, values2));  // Output: 40
    }
}
