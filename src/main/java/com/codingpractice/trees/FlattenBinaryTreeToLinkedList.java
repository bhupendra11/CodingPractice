package com.codingpractice.trees;

import java.util.Stack;

/**
 * 
 * @author Bhupendra Shekhawat
 */
// Question : https://www.interviewbit.com/problems/flatten-binary-tree-to-linked-list/
/*
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 *  	 1                          
        / \
       2   5
      / \   \
     3   4   6
     
     to
     
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 */
public class FlattenBinaryTreeToLinkedList {

	public static void main(String args[]) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		
		root.right.right = new TreeNode(6);		
		
		TreeNode flattenedRoot =  flatten(root);
		
		//Print flattened tree
		TreeTraversalsRecursive.inOrder(flattenedRoot);
	}
	
	private static TreeNode flatten(TreeNode a) {
	    
	    Stack<TreeNode> stack = new Stack();
	    TreeNode p = a;   //used as a pointer to the current node
	    
	    while(p!= null || !stack.isEmpty()){
	        
	        //store p.right if present
	        
	        if(p.right!= null){
	            stack.push(p.right);
	        }
	        
	        //Add p.left as the next node if present
	        if(p.left != null){
	            p.right = p.left;
	            p.left = null;
	        }
	        //or get a node from stack as the next node if not empty
	        else if(!stack.isEmpty()){
	            TreeNode temp = stack.pop();
	            p.right = temp;
	        }
	        p = p.right;
	    }
	    
	    return a;
	}
	
}
