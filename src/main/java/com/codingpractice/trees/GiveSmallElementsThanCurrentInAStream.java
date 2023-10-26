package com.codingpractice.trees;

public class GiveSmallElementsThanCurrentInAStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST bst = new BST();
		
		bst.add(1);
		//System.out.println(bst.sizeOfSubtree(1));
		
		bst.add(5);
		//System.out.println(bst.sizeOfSubtree(5));
		bst.add(3);
	//	System.out.println(bst.sizeOfSubtree(3));
		bst.add(6);
	//	System.out.println(bst.sizeOfSubtree(6));
		bst.add(4);
	//	System.out.println(bst.sizeOfSubtree(4));
		bst.add(16);
		System.out.println(bst.sizeOfSubtree(16));
		
		//bst.display();
		
		
		

	}

	
	static class BST{
		
		private class Node{
			int data;
			Node left;
			Node right;
		}
		
		
		private Node root;
		
		public void add(int item) {
			
			if(this.root==null) {
				Node node = new Node();
				node.data =item;
				this.root=node;
			}
			else {
				add(this.root,  item);
			}
		}
		
		private Node add(Node node, int item) {
			if(node==null) {
				Node nn = new Node();
				nn.data =item;
				return nn;
			}
			
			if(item <node.data) {
				node.left = add(node.left, item);
				
			}
			else {
				node.right = add(node.right, item);
			}
			return node;
			
		}
		
		
		public int sizeOfSubtree(int item) {
			
			Node node = getNode(item, this.root);
			
			return sizeOfSubtree(node);
			
		}
		
		private Node getNode(int item, Node node) {
			if(node==null)return null;
			
			if(item ==node.data)return node;
			else if(item<node.data) {
				return getNode(item, node.left);
			}
			else {
				return getNode(item, node.right);
			}
			
		}
		
		private int sizeOfSubtree(Node node) {
			if(node==null)return 0;
			
			return 1+ sizeOfSubtree(node.left)+sizeOfSubtree(node.right);
		}
		
		
		public void display() {
			display(this.root);
		}

		private void display(Node node) {
			// TODO Auto-generated method stub
			if(node ==null)return;
			
			display(node.left);
			System.out.print(" "+node.data+" ");
			display(node.right);
		}
	}
}
