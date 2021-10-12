package com.codingpractice.codingBlocks.Section13_BinarySearchTree;

public class BST {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BST(int arr[]) {
		this.root = construct(arr, 0, arr.length - 1);
	}

	private Node construct(int arr[], int lo, int hi) {

		if (lo > hi)
			return null;

		int mid = lo + (hi - lo) / 2;

		Node node = new Node();
		node.data = arr[mid];

		node.left = construct(arr, lo, mid - 1);
		node.right = construct(arr, mid + 1, hi);
		return node;
	}

	public void display() {
		display(this.root);
	}

	private void display(Node node) {

		if (node == null)
			return;

		String str = "";

		if (node.left != null) {
			str += node.left.data;
		} else {
			str += ".";
		}

		str += " => " + node.data + " <= ";

		if (node.right != null) {
			str += node.right.data;
		} else {
			str += ".";
		}
		System.out.println(str);
		display(node.left);
		display(node.right);
	}

	public boolean find(int item) {
		return find(this.root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null)
			return false;

		if (node.data == item)
			return true;

		if (item < node.data) {
			return find(node.left, item);
		} else {
			return find(node.right, item);
		}

	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {
		// TODO Auto-generated method stub
		if (node == null)
			return -1;

		if (node.right != null) {
			return max(node.right);
		} else {
			return node.data;
		}
	}

	public void add(int item) {
		add(this.root, item);
	}

	private void add(Node node, int item) {
		// TODO Auto-generated method stub

		if (item > node.data) {
			if (node.right == null) {
				Node nn = new Node();
				nn.data = item;
				node.right = nn;
			} else {
				add(node.right, item);
			}

		} else {
			if (node.left == null) {
				Node nn = new Node();
				nn.data = item;
				node.left = nn;
			} else {
				add(node.left, item);
			}
		}
	}
	
	public void delete(int item) {
		
	}
}
