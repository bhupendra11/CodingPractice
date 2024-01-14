package com.bhupendra.prep2023.trees;

import java.util.*;

public class _c1_DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new ArrayList<>();
        if(root==null)return list;

        Set<Integer> deleteSet = new HashSet<>();
        for(int node : to_delete){
            deleteSet.add(node);
        }

        if(!deleteSet.contains(root.val))list.add(root);
        deleteRecursive(root,root, deleteSet, list);

        return list;

    }

    private void deleteRecursive(TreeNode parent,TreeNode node, Set<Integer> deleteSet,List<TreeNode> list ){
        if(node == null){
            return;
        }

        if(deleteSet.contains(node.val)){

            if(node.left != null && !deleteSet.contains(node.left.val)){
                list.add(node.left);
            }
            if(node.right != null && !deleteSet.contains(node.right.val) ){
                list.add(node.right);
            }

            //delete node
            if(parent.left == node){
                parent.left = null;
            }
            else if(parent.right == node){
                parent.right = null;
            }
        }

        deleteRecursive(node, node.left, deleteSet, list );
        deleteRecursive(node, node.right, deleteSet, list );

    }
}
