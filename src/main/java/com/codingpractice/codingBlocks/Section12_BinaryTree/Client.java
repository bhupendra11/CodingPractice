package com.codingpractice.codingBlocks.Section12_BinaryTree;

import java.util.Scanner;

public class Client {

	//50 true 25 true 38 false false true 48 true 18 false false false true 45 true 85 false false true 60 false false
	
	public static void main(String args[]) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.display();
		
		
		System.out.println("Height of tree= "+binaryTree.height());
		System.out.println("preOrder : ");
		binaryTree.preOrder();
		
		System.out.println("postOrder : ");
		binaryTree.postOrder();
		
		System.out.println("inOrder : ");
		binaryTree.inOrder();
		
		System.out.println("levelOrder : ");
		binaryTree.levelOrder();
		
		System.out.println("levelOrder Level by level: ");
		binaryTree.levelOrderLevelbyLevel();
		
	}
}
