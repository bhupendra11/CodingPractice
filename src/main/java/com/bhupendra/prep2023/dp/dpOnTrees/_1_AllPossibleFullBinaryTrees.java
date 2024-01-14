package com.bhupendra.prep2023.dp.dpOnTrees;

import java.util.ArrayList;
import java.util.List;

public class _1_AllPossibleFullBinaryTrees {
    public List<TreeNode> allPossibleFBT(int n) {

        //full binary trees
        //A full binary tree is a binary tree where each node has exactly 0 or 2 children.

        //each node should have Node.val == 0

        List<TreeNode> list = new ArrayList<>();
        if(n%2 ==0)return list;
        if(n<=0)return list;
        if(n==1){
            list.add(new TreeNode(0));
            return list;
        }

        //each tree should have n total nodes

        //get permutations/arrangements of  all full binary trees possible with n nodes

        //TreeNode node = new TreeNode(0);
        n--;

        //n should be odd
        for(int i=1;i<=n;i+=2){
            List<TreeNode> allLeftSubTrees = allPossibleFBT(i);
            List<TreeNode> allRightSubTrees = allPossibleFBT(n-i);

            for(TreeNode lNode : allLeftSubTrees){
                for(TreeNode rNode: allRightSubTrees){
                    TreeNode node = new TreeNode(0);
                    node.left = lNode;
                    node.right = rNode;

                    list.add(node);
                }
            }

        }

        return list;


    }
}
