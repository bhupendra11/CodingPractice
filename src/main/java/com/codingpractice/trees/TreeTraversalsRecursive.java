package com.codingpractice.trees;

import java.util.ArrayList;

/**
 * 
 * @author Bhupendra Shekhawat
 * Utility methods for tree traversal recursively
 */
public class TreeTraversalsRecursive {

		public static void inOrder(TreeNode root) {
			if(root==null)return;
			
			
			inOrder(root.left);
			System.out.print(root.val+" ");
			inOrder(root.right);
			
		}
		
		public static void preOrder(TreeNode root) {
			if(root==null)return;
			
			System.out.print(root.val+" ");
			preOrder(root.left);			
			preOrder(root.right);
			
		}
		
		public static void postOrder(TreeNode root) {
			if(root==null)return;
			
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.val+" ");
			
		}
}
