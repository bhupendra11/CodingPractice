package com.prep2023.trees;

/**
 * Author: Bhupendra Shekhawat
 * Date: 28/10/23
 * Topic: com.prep2023.trees
 * Question : <a href="https://leetcode.com/problems/validate-binary-search-tree/">98. Validate Binary Search Tree</a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        if(root == null)return true;

        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root , Integer min, Integer max){
        if(root == null)return true;
        if((min != null && root.val <= min) || (max != null && root.val >= max))return false;

        return isValidBST(root.left, min, root.val) &&
                isValidBST(root.right, root.val, max);
    }
}
