package com.bhupendra.prep2023.trees;

/**
 * Author: Bhupendra Shekhawat
 * Date: 10/11/23
 * Topic: com.prep2023.trees
 * Question : <a href="https://leetcode.com/problems/count-good-nodes-in-binary-tree/">1448. Count Good Nodes in Binary Tree</a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _9_GoodNodes {
    public int goodNodes(TreeNode root) {
        if(root == null)return 0;
        return goodNodes(root,root.val);
    }

    private int goodNodes(TreeNode root, int max){
        if(root == null)return 0;
        int leftCount = 0, rightCount =0;
        if(root.left != null){
            leftCount = goodNodes(root.left, Math.max(max, root.left.val));
        }
        if(root.right != null){
            rightCount = goodNodes(root.right, Math.max(max, root.right.val));
        }
        int result = leftCount + rightCount;

        if(root.val >= max){
            result += 1;
        }
        return result;
    }
}
