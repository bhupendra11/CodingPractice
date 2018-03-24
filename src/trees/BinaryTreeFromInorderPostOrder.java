package trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeFromInorderPostOrder {

	public static void main(String[] args) {
		
		int arrIn[] = {4,2,5,1,6,3};
		int arrPost[] = {4,5, 2, 6, 3, 1};
		ArrayList<Integer> inOrder = new ArrayList<>();
		ArrayList<Integer> postOrder = new ArrayList<>();
		for(int i :arrIn)inOrder.add(new Integer(i));
		for(int i :arrPost)postOrder.add(new Integer(i));
		TreeNode res = binTreefromInPostOrder(inOrder, postOrder);
		
		System.out.println("Resulting tree");
		
		inOrder(res);
	}
	
	private static TreeNode binTreefromInPostOrder(List<Integer> inOrder, List<Integer> postOrder) {
		
		if(inOrder.size()!= postOrder.size())return null;
		if(inOrder.size()==0)return null;
		
		int nodeval = postOrder.get(postOrder.size()-1);
		TreeNode node = new TreeNode(nodeval);
		
		int indexInOrder = inOrder.indexOf(nodeval);
		
		List<Integer> inOrderLeft=  inOrder.subList(0, indexInOrder); 
		List<Integer> inOrderRight=  inOrder.subList(indexInOrder+1, inOrder.size()); 
		
		List<Integer> postOrderLeft=  postOrder.subList(0, indexInOrder); 
		List<Integer> postOrderRight=  postOrder.subList(indexInOrder, postOrder.size()-1); 
		
		node.left = binTreefromInPostOrder(inOrderLeft, postOrderLeft);
		node.right = binTreefromInPostOrder(inOrderRight, postOrderRight);
		
		return node;
		
	}
	
	private static void inOrder(TreeNode root) {
		if(root==null)return;
		
		
		inOrder(root.left);
		System.out.print(root.val+" ");
		inOrder(root.right);
		
	}
	
	

}
