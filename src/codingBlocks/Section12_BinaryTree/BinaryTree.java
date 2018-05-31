package codingBlocks.Section12_BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {

	private class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data, Node left, Node right){
			this.data = data;
			this.left=left;
			this.right = right;
		}
	}

	
	Node root=null;
	int size=0;
	
	BinaryTree(){
		Scanner sc = new Scanner(System.in);
		this.root = takeInput(sc, null, false);
		sc.close();
	}
	
	Node takeInput(Scanner s, Node parent, boolean isLeftOrRight) {
		if(parent==null) {
			System.out.println("Enter the data for root node");
		}
		else {
			if(isLeftOrRight) {
				System.out.println("Enter the data for left child of "+parent.data);
			}
			else {
				System.out.println("Enter the data for right child of "+parent.data);
			}
		}
		
		int nodeData = s.nextInt();
		Node node = new Node(nodeData, null, null);
		this.size++;
		
		boolean choice =false;
		System.out.println("Do you have left child of "+ node.data);
		choice = s.nextBoolean();
		if(choice) {
			node.left = takeInput(s, node, true);
		}
		
		choice =false;
		System.out.println("Do you have right child of "+ node.data);
		choice = s.nextBoolean();
		if(choice) {
			node.right = takeInput(s, node, false);
		}
		
		return node;
	}
	
	
	public void display() {
		display(this.root);
	}
	
	private void display(Node node) {
		String str="";
		if(node.left != null) {
			str += node.left.data +"=>";
		}
		else {
			str+= "END"+"=>";
		}
		
		str+= node.data;
		
		if(node.right != null) {
			str +="<=" + node.right.data ;
			
		}
		else {
			str+="<=" +"END";
		}
		
		System.out.println(str);
		if(node.left!=null)
			display(node.left);
		if(node.right != null)
			display(node.right);
	}
	
	public int height()
	{
		return height(this.root);
	}
	
	private int height(Node node) {
		if(node==null)return -1;
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		
		return Math.max(leftHeight, rightHeight)+1;
	}
	
	public void preOrder() {
		preOrder(this.root);
		System.out.println(" END");
	}
	
	private void preOrder(Node node) {
		if(node == null)return;
		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void postOrder() {
		postOrder(this.root);
		System.out.println(" END");
	}
	
	private void postOrder(Node node) {
		if(node == null)return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data+" ");
	}
	
	public void inOrder() {
		inOrder(this.root);
		System.out.println(" END");
	}
	
	private void inOrder(Node node) {
		if(node == null)return;
		
		inOrder(node.left);
		System.out.print(node.data+" ");
		inOrder(node.right);
		
	}
	
	public void levelOrder() {
		levelOrder(this.root);
	}
	
	private void levelOrder(Node node) {
		if(node ==null)return;
		
		Queue<Node> queue = new LinkedList();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			Node cur = queue.remove();
			System.out.print(cur.data+" ");
			if(cur.left != null) {
				queue.add(cur.left);
			}
			if(cur.right != null) {
				queue.add(cur.right);
			}
		}
		System.out.println("END");
		
	}
	
	
	public void levelOrderLevelbyLevel() {
		levelOrderLevelbyLevel(this.root);
	}
	
	private void levelOrderLevelbyLevel(Node root) {
		if(root ==null)return;
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()) {
			Node node = queue.remove();
			/*
			if(node==null && !queue.isEmpty() && queue.peek()==null) {
				break;
			}*/
			
			if(node != null) {
				System.out.print(node.data+" ");
				if(node.left!=null)
					queue.add(node.left);
				if(node.right != null)
					queue.add(node.right);
			}
			else {
				if(queue.isEmpty())break;
				System.out.println();
				queue.add(null);
				
			}
		}
		
	}
	
	public ArrayList<ArrayList<Integer>> levelOrderArrayList(){
		return levelOrderArrayList(this.root);
	}
	
	
	private  ArrayList<ArrayList<Integer>> levelOrderArrayList(Node root) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root==null)return result;
		// write your code here
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		
		ArrayList<Integer> curList = new ArrayList<>();
		
		while(!queue.isEmpty()){
		    Node node = queue.remove();
		    
		    if(node != null){
		        curList.add(node.data);
		        if(node.left != null){
		            queue.add(node.left);
		        }
		        if(node.right != null){
		            queue.add(node.right);
		        }
		    }
		    else{
		         result.add(curList);
		        if(queue.isEmpty())break;
		       
		        curList = new ArrayList<>();
		        queue.add(null);
		    }
		}
		
		return result;
		
	}
}
