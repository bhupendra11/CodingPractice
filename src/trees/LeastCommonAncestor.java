package trees;

import java.util.ArrayList;

public class LeastCommonAncestor {

	public static void main(String args[]) {

		TreeNode  root = new TreeNode(3);
		TreeNode left  = new TreeNode(5);
		TreeNode right = new TreeNode(1);
		
		root.left = left;
		root.right =right;
		
		left.left = new TreeNode(6);
		left.right = new TreeNode(2);
		left.right.left = new TreeNode(7);
		left.right.right = new TreeNode(4);
		
		right.left=new TreeNode(0);
		right.right= new TreeNode(8);
		
		int A = 5;
		int B =45;
		
		int n = lcs(root, A, B);
		
		System.out.println("LCA= "+n);
		
		//find lcs recursively fast
		
		TreeNode lcaNode = lcsRecursive(root, A, B);
		int lca =-1;
		if(lcaNode!= null)lca = lcaNode.val;
		else lca = -1;
		System.out.println("LCA Recursive "+lca);
	}
	
	/**
	 Efficient approach for lcs , max O(n) 
	 */
	private static TreeNode lcsRecursive(TreeNode root, int a , int b) {
		
		if(root==null)return null;
		
		if(root.val == a && root.val == b )return root;		
		TreeNode left = lcsRecursive(root.left, a, b);
		TreeNode right = lcsRecursive(root.right, a, b);
		
		if(left!= null && right != null)return root;
		if(left== null && right == null)return null;
		
		return left !=null? left : right;
	}
	
	/**
	 * Method to find lcs using inorder and postorder traversal
	 * WORKS BUT NOT THAT EFFCIENT
	 * @param root
	 * @param a
	 * @param b
	 * @return
	 */

	private static int lcs(TreeNode root, int a, int b) {
		// TODO Auto-generated method stub
		
		//considering a <b
		
		if(b <a) {
			a = a^b;
			b = a^b;
			a=a^b;
		}
		ArrayList<Integer> postOrder = new ArrayList<>();
		postOrder(root, postOrder);
		ArrayList<Integer> inOrder = new ArrayList<>();
		inOrder(root, inOrder);
		
		if(a==b && postOrder.contains(a))return a;
		if(!postOrder.contains(a) || !postOrder.contains(b))return -1;
		
		ArrayList<Integer> interval = new ArrayList<>();
		
		boolean start =false, stop=false;
		for(int i : inOrder) {
			
			
			
			
			
			if((i==a || i==b) && !start) {
				start = true;
				interval.add(i);
				
			}
			
			else if((i==a || i==b) && start && !stop) {
				stop = true;
				interval.add(i);
				break;
			}
			else if(start && !stop) {
				interval.add(i);
			}
		}
		
		int lca = -1;
		
		for(int i : postOrder) {
			if(interval.contains(i)) {
				lca = i;
			}
		}
		
		return lca;
	}
	
	// Helper method for lcs
	private static void inOrder(TreeNode root, ArrayList<Integer> list) {
		if(root==null)return;
		
		
		inOrder(root.left, list);
		list.add(root.val);
		inOrder(root.right, list);
		
	}
	
	// Helper method for lcs
	private static void postOrder(TreeNode root, ArrayList<Integer> list) {
		if(root==null)return;
		
		postOrder(root.left, list);
		postOrder(root.right, list);
		list.add(root.val);
		
	}
	
	
	
	

	
}
