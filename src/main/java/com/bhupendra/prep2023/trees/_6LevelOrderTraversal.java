package com.bhupendra.prep2023.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _6LevelOrderTraversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    //Approach 2: BFS with using queue.length to determine levels
    // Performs much better, bets 87%
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        List<Integer> cur = new ArrayList<>();
        while(!q.isEmpty()){
            int length = q.size();
            cur = new ArrayList<>();
            for(int i=0 ;i<length;i++){
                TreeNode node = q.remove();
                cur.add(node.val);
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            result.add(cur);
        }
        return result;
    }


    //APPROACH 1 : Level order bfs using null as delimiter for levels ., bets only 2%
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        List<Integer> cur = new ArrayList<>();

        while (!q.isEmpty()) {
            TreeNode node = q.remove();
            if (node == null && q.isEmpty()) {
                result.add(new ArrayList<>(cur));
                cur.clear();
                break;
            }
            if (node == null) {
                result.add(new ArrayList<>(cur));
                cur.clear();
                q.add(null);
                continue;
            }

            cur.add(node.val);
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        return result;
    }
}
