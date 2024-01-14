package com.bhupendra.prep2023.trees;

/**
 * Author: Bhupendra Shekhawat
 * Date: 24/10/23
 * Topic: com.prep2023.trees
 * Question Link:
 * YouTube Link:
 * Problem: https://leetcode.com/problems/invert-binary-tree/description/
 */

public class _5InveryBinaryTree {
    public TreeNode invertTree(TreeNode root) {

        if(root == null)return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }
}
