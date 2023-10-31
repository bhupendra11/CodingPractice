package com.prep2023.graph.dfs_bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Bhupendra Shekhawat
 * Date: 31/10/23
 * Topic: com.prep2023.graph.dfs_bfs
 * Question : <a href="https://leetcode.com/problems/clone-graph/">133. Clone Graph</a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _2CloneGraph_DFS {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    //Node.val is unique for each node.
    Map<Integer, Node> map = map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        if (map.containsKey(node.val))
            return map.get(node.val);

        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(newNode.val, newNode);

        for (Node nbr : node.neighbors) {
            newNode.neighbors.add(cloneGraph(nbr));
        }
        return newNode;
    }
}
