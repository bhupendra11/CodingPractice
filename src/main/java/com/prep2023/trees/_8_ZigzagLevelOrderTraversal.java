package com.prep2023.trees;
import java.util.*;

/**
 * Author: Bhupendra Shekhawat
 * Date: 07/11/23
 * Topic: com.prep2023.trees
 * Question : <a href="https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/">103. Binary Tree Zigzag Level Order Traversal</a>
 * YouTube : <a href="">Link to YouTube</a>
 */

/**
 *   Its basically level order traversal with queue.
 * The only change is, for every alternate level, instead of storing node values in a list,
 * I first store them in a stack, which I later reverse into the list, so that every alternate level is shown as reverse;
 */
public class _8_ZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root== null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        List<Integer> cur = new ArrayList<>();
        boolean oddLevel = true;

        while(!q.isEmpty()){
            int length = q.size();
            cur = new ArrayList<>();
            Stack<Integer> reverseStack = new Stack<>(); //for storage in alternate levels, even levels

            for(int i=0;i<length;i++){
                TreeNode node = q.remove();
                if(oddLevel){
                    cur.add(node.val);
                }
                else{
                    reverseStack.push(node.val);
                }
                if(node.left != null) q.add(node.left);
                if(node.right != null)q.add(node.right);
            }

            if(!oddLevel){
                while(!reverseStack.isEmpty()){
                    cur.add(reverseStack.pop());
                }
            }
            //chnage level flag
            oddLevel = !oddLevel;
            result.add(cur);
        }
        return result;
    }
}
