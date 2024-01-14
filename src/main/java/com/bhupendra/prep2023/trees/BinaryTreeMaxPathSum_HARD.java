package com.bhupendra.prep2023.trees;

/**
 * Author: Bhupendra Shekhawat
 * Date: 21/10/23
 * Topic: com.prep2023.trees
 * Question Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 * YouTube Link: 
 * Problem:
 *
 * 124. Binary Tree Maximum Path Sum
 * Hard
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 * Example 2:
 *
 *
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 */

public class BinaryTreeMaxPathSum_HARD {
    int maxPathSum =0;
    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;

        pathSum(root);
        return maxPathSum;

    }

    private int pathSum(TreeNode node){
        if(node ==null)return 0;

        int leftSum =  Math.max(0,pathSum(node.left));
        int rightSum =  Math.max(0,pathSum(node.right));

        maxPathSum = Math.max(maxPathSum, leftSum+rightSum+node.val);

        return Math.max(node.val+leftSum, node.val+rightSum);

    }


    public static void main(String[] args) {
        BinaryTreeMaxPathSum_HARD test = new BinaryTreeMaxPathSum_HARD();

        // Create a binary tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(-25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        // Find and print the maximum path sum
        int maxPathSum = test.maxPathSum(root);
        System.out.println("Maximum Path Sum: " + maxPathSum);
    }
}
