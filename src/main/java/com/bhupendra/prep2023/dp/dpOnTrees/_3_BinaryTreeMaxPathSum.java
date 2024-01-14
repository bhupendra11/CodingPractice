package com.bhupendra.prep2023.dp.dpOnTrees;

/**
 * Author: Bhupendra Shekhawat
 * Date: 16/12/23
 * Topic: com.prep2023.dp.dpOnTrees
 * Question : <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/"></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _3_BinaryTreeMaxPathSum {
    //path does not need to pass through the root.
    // node can be negative

    int maxPathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        calcPathSum(root);
        return maxPathSum;
    }

    private int calcPathSum(TreeNode root){
        if(root == null)return 0;

        int leftPathSum = calcPathSum(root.left);
        int rightPathSum = calcPathSum(root.right);


        int maxChildPath = Math.max(leftPathSum, rightPathSum) > 0 ? Math.max(leftPathSum, rightPathSum)  :0;
        int temp = root.val + maxChildPath ;

        int curMaxPathSum = root.val;
        if(leftPathSum > 0){
            curMaxPathSum += leftPathSum;
        }
        if(rightPathSum > 0){
            curMaxPathSum += rightPathSum;
        }

        maxPathSum = Math.max(maxPathSum, curMaxPathSum);
        return temp;
    }
}
