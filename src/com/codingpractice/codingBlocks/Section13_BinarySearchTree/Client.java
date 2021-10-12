package com.codingpractice.codingBlocks.Section13_BinarySearchTree;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {10,20,30,40,50,60,70};
		BST bst = new BST(arr);
		bst.display();
		
		/*System.out.println(bst.find(30));
		System.out.println(bst.find(100));
		System.out.println(bst.max());*/
		
		bst.add(100);
		bst.add(35);
		System.out.println();
		bst.display();
	}

}
