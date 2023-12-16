package com.prep2023.GOOGLE;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Author: Bhupendra Shekhawat
 * Date: 20/11/23
 * Topic: com.prep2023.GOOGLE
 * Question : <a href="https://leetcode.com/problems/find-leaves-of-binary-tree/"></a>
 * YouTube : <a href="">Link to YouTube</a>
 */
public class _3_FindLeavesOfBinaryTree {
    List<List<Integer>> result;
    Map<Integer, List<Integer>> map;
    public List<List<Integer>> findLeaves(TreeNode root) {
        result = new ArrayList<>();
        if(root == null)return result;
        map = new TreeMap<>();

        getHeight(root);

        for(int key : map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }

    private int getHeight(TreeNode node){
        if(node == null)return 0;

        int lHeight = getHeight(node.left);
        int rHeight = getHeight(node.right);

        int res = 1+ Math.max(lHeight, rHeight);
        if(!map.containsKey(res)){
            map.put(res, new ArrayList<>());
        }
        map.get(res).add(node.val);
        return res;

    }
}
