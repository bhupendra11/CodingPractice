package com.codingpractice.trees;


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * @author Bhupendra Shekhawat
 *
 */
public class TreeTraversalsIterative {

    /**
     *        1
     *      /   \
     *     2     3
     *   /  \   / \
     *  4    5 6   7
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        preOrder(root);
    }

    private static void preOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print(node.val+" ");
            if(node.right !=null){
                stack.push(node.right);
            }
            if(node.left !=null) {
                stack.push(node.left);
            }
        }
    }

    private static void postOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){


        }
    }
}
