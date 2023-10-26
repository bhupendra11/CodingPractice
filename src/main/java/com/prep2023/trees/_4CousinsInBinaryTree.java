package com.prep2023.trees;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Bhupendra Shekhawat
 * Date: 24/10/23
 * Topic: com.prep2023.trees
 * Question Link: https://leetcode.com/problems/cousins-in-binary-tree/
 * YouTube Link:
 * Problem:
 * EASY
 */

public class _4CousinsInBinaryTree {
    Map<Integer, Integer> map;
    public boolean isCousins(TreeNode root, int x, int y) {
        map = new HashMap<>();
        TreeNode parentX = getParent(root, x,0);
        TreeNode parentY = getParent(root, y,0);

        //check 2 things
        // 1 parent not same
        // 2 equidistanct from root
        if(parentX == parentY)return false;
        return map.get(x) == map.get(y);
    }

    private TreeNode getParent(TreeNode root, int node, int dist){
        if(root == null)return null;
        //if(root.val == x)return root;

        if(root.left != null && root.left.val == node){
            map.put(node,dist+1 );
            return root;
        }
        if(root.right != null && root.right.val == node){
            map.put(node,dist+1 );
            return root;
        }

        TreeNode parentLeft = getParent(root.left, node, dist+1);
        if(parentLeft != null)return parentLeft;

        return getParent(root.right, node,dist+1);

    }
}
