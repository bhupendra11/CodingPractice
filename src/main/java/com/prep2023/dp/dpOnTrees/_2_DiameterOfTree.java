package com.prep2023.dp.dpOnTrees;

public class _2_DiameterOfTree {

    int diameter =0;
    private int diameter(TreeNode root){
        height(root);
        return diameter;
    }

    private int height(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int height = 1 + Math.max(leftHeight,rightHeight);

        diameter = Math.max(diameter, 1+ leftHeight+rightHeight);
        return height;
    }
}
