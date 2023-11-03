package com.prep2023.trees;

import java.util.*;

/**
 * Author: Bhupendra Shekhawat
 * Date: 01/11/23
 * Topic: com.prep2023.trees
 * Question : <a href="https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/">863. All Nodes Distance K in Binary Tree</a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _7All_Nodes_Dist_K_from_Target_BinaryTree {

    private Map<Integer, List<Integer>> graph;
    List<Integer> result;
    Set<Integer> visited;
    int k;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        result = new ArrayList<>();
        graph = new HashMap<>();
        this.k = k;

        visited = new HashSet<>();
        buildGraph(root, root);
        dfs(target.val, 0);
        return result;
    }

    private void dfs(int node, int dist) {
        if (dist == k) {
            result.add(node);
            return;
        }

        visited.add(node);

        for (int next : graph.get(node)) {
            if (!visited.contains(next)) {
                dfs(next, dist + 1);
            }
        }
    }

    private void buildGraph(TreeNode cur, TreeNode parent) {

        if (cur != null && parent != null) {
            graph.computeIfAbsent(cur.val, x -> new ArrayList<>()).add(parent.val);
            graph.computeIfAbsent(parent.val, x -> new ArrayList<>()).add(cur.val);
        }

        if (cur.left != null) {
            buildGraph(cur.left, cur);
        }
        if (cur.right != null) {
            buildGraph(cur.right, cur);
        }

    }
}
