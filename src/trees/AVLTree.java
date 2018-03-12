package trees;

public class AVLTree {

	private class Node{
		int data;
		Node left;
		Node right;
		int height;
		
		Node(int data) {
			this.data = data;
			this.height =1;
		}
	}
	
	private Node root;
	
	public void insert(int item) {
		this.root = this.insert(root, item);
	}
	
	private Node insert( Node node, int data) {
		
		if(node == null) {
			Node newNode = new Node(data);
			return newNode;
		}
		
		if(data > node.data) {
			node.right = insert(node.right, data);
		}
		else if(data < node.data) {
			node.left= insert(node.left, data);
		}
		
		node.height = Math.max(height(node.left), height(node.right))+1;
		
		int bf = bf(node);
		
		//LL Case
		if(bf>1 && data < node.left.data) {
			return rightRotate(node);
		}
		//RR Case
		else if(bf <-1 && data > node.right.data ) {
			return leftRotate(node);
		}
		//LR Case
		else if( bf > 1 && data > node.left.data) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		else if(bf < -1 && data < node.right.data ) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		
		return node;
	}
	
	private int height(Node node) {
		if(node==null) {
			return 0;
		}
		return node.height;
	}
	
	/*
	 * Used to calculate the balancing factor of @Node node
	 */
	private int bf(Node node) {
		if(node ==null)return 0;
		
		return height(node.left)-height(node.right);
	}
	
	
	
	/*           c
	 *          / \
	 *         /   T4
	 *        b
	 *       / \
	 *      /  T3
	 *     a
	 *    / \
	 *   T1  T2  
	 *   
	 *    ****  LL Case ***
	 *    
	 *     c
	 *    / \
	 *   T1  \
	 *        b
	 *      /  \
	 *     T2   \
	 *           a
	 *          / \
	 *         T3  T4  
	 *         
	 *    ****  RR Case  ***
	 *    
	 *    
	 *    		 c
	 *          / \
	 *         /   T4
	 *        b
	 *       / \
	 *      T1  a
	 *         /  \
	 *     	  T2  T3  
	 *         
	 *    *****   LR Case   ***
	 *    
	 *     c
	 *    / \
	 *   T1  b
	 *      / \
	 *     a   T4
	 *    / \     
	 *   T2  T3  
	 *         
	 *   ******   RL Case   ***      
	 */
	private Node rightRotate(Node c) {
		Node b = c.left;
		Node T3 = b.right;
		
		//rotate
		b.right =c;
		c.left =T3;
		
		//height update
		c.height = Math.max(height(c.left), height(c.right))+1;
		b.height = Math.max(height(b.left), height(b.right))+1;
		
		return b;
	}
	
	/*
	 *     c
	 *    / \
	 *   T1  \
	 *        b
	 *      /  \
	 *     T2   \
	 *           a
	 *          / \
	 *         T3  T4  
	 */
	
	private Node leftRotate(Node c) {
		Node b = c.right;
		Node T2 = b.left;
		
		//rotate
		b.left =c;
		c.right =T2;
		
		//height update
		c.height = Math.max(height(c.left), height(c.right))+1;
		b.height = Math.max(height(b.left), height(b.right))+1;
		
		return b;
	}
	
	public void display() {
		display(this.root);
	}
	
	private void display(Node node) {
		
		if(node==null)return;
		
		String str="";
		if(node.left ==null) {
			str+= ".";
		}
		else {
			str+= node.left.data;
		}
		
		str+= " => "+node.data+" <= ";
		
		if(node.right ==null) {
			str+= ".";
		}
		else {
			str+= node.right.data;
		}
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
}
