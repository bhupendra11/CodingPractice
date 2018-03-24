package trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeFromInorderPreOrder {

	public static void main(String args[]) {
		int arrIn[] = {1,2};
		int arrPre[] = {2,1};
		ArrayList<Integer> inOrder = new ArrayList<>();
		ArrayList<Integer> postOrder = new ArrayList<>();
		for(int i :arrIn)inOrder.add(new Integer(i));
		for(int i :arrPre)postOrder.add(new Integer(i));
		TreeNode res = binTreefromInPreOrder(inOrder, postOrder);
		
		System.out.println("Resulting tree");
		
		TreeTraversalsRecursive.inOrder(res);
	}
	
	private static TreeNode binTreefromInPreOrder(List<Integer> inOrder, List<Integer> preOrder) {
		// TODO Auto-generated method stub
		if(inOrder.size()==0)return null;
		
		int rootVal = preOrder.get(0);
		int rootIndex = inOrder.indexOf(rootVal);
		
		TreeNode rootNode = new TreeNode(rootVal);
		List<Integer> leftInorder = inOrder.subList(0, rootIndex);
		List<Integer> rightInoder = inOrder.subList(rootIndex+1, inOrder.size());
		
		List<Integer> leftPreorder = preOrder.subList(1, rootIndex+1);
		List<Integer> rightPreorder = preOrder.subList(rootIndex+1, preOrder.size());
		
		rootNode.left = binTreefromInPreOrder(leftInorder, leftPreorder);
		rootNode.right = binTreefromInPreOrder(rightInoder, rightPreorder);
		
		
		return rootNode;
	}

	
}
