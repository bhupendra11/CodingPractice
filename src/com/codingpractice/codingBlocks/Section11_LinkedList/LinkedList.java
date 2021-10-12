package com.codingpractice.codingBlocks.Section11_LinkedList;

public class LinkedList {

	private class Node{
		int data;
		Node next;
	}
	
	private Node head;
	private Node tail;
	private int size;

	//O(N)
	public void display() {
		
		Node temp = this.head;
		System.out.println("----------------------");
		while(temp!=null) {
			System.out.print(temp.data+", ");
			temp = temp.next;
		}
		System.out.println(".");
		System.out.println("----------------------");
	}
	
	//O(N)
	public void addLast(int item) {
		Node node = new Node();
		node.data=item;
		node.next=null;
		
		//attach
		if(this.size>=1) {
			this.tail.next= node;
		}
		
		//update summary object
		if(this.size==0) {
			this.head = node;
			this.tail=node;
			size++;
		}
		else {
			this.tail =this.tail.next;
			size++;
		}
	}
	
	//O(N)
	public void addFirst(int item ) {
		Node node = new Node();
		node.data = item;
		node.next= null;
		
		if(size>=1) {
			node.next =head;
		}
		
		//update
		if(this.size==0) {
			this.head=node;
			this.tail =node;
			size++;
		}
		else {
			this.head=node;
			size++;
		}
	}
	
	//O(1)
	public int getFirst() throws Exception {
		if(this.size==0) {
			throw new Exception("LinkedList is Empty");
		}
		
		return head.data;
	}
	
	//O(1)
	public int getLast() throws  Exception {
		if(this.size==0) {
			throw new Exception("LinkedList is Empty");
		}
		
		return tail.data;
	}
	
	//O(N)
	public int getAt(int index) throws Exception {
		if(this.size==0) {
			throw new Exception("LinkedList is Empty");
		}
		
		if(index <0 || index >=this.size) {
			throw new Exception("Invalid index");
		}
		
		Node temp = head;
		
		for(int i=1; i<=index ;i++) {
			temp = temp.next;
		}
		return temp.data;
		
	}
	
	//O(N)
	private Node getNodeAt(int index) throws Exception {
		if(this.size==0) {
			throw new Exception("LinkedList is Empty");
		}
		
		if(index <0 || index >=this.size) {
			throw new Exception("Invalid index");
		}
		
		Node temp = head;
		
		for(int i=1; i<=index ;i++) {
			temp = temp.next;
		}
		return temp;
		
	} 
	
	
	//O(N)
	public void addAt( int item, int index) throws Exception {
		if(index <0 || index >size) {
			throw new Exception("Invalid index");
		}
		
		if(index ==0) {
			addFirst(item);
		}
		else if(index ==this.size) {
			addLast(item);
		}
		else { //in between
			Node node = new Node();
			node.data=item;
			node.next=null;
			   
			Node prevNode = getNodeAt(index-1);
			Node nextNode = prevNode.next;
			
			prevNode.next = node;
			node.next =nextNode;
			this.size++;
		}
		
	}
	
	//O(1)
	public  int removeFirst()  throws Exception{
		if(this.size==0) {
			throw new Exception("LinkedList is empty");
		}
		
		int returnValue = this.head.data;
		
		if(this.size==1) {
			this.head=null;
			this.tail=null;
			this.size--;
		}
		else {
			head = head.next;
			size--;
		}
		return returnValue;
	}
	
	
	//O(N)
	public  int removeLast()  throws Exception{
		if(this.size==0) {
			throw new Exception("LinkedList is empty");
		}
		
		int returnValue = this.tail.data;
		
		if(this.size==1) {
			this.head=null;
			this.tail=null;
			this.size--;
		}
		else {
			//return the second last node
			this.tail = getNodeAt(this.size-2);
			this.tail.next=null;
			size--;
		}
		return returnValue;
	}
	
	
	//O(N)
	public int removeAt(int index) throws Exception {
		
		if(this.size==0) {
			throw new Exception("LinkedList is empty");
		}
		
		if(index <0 || index >=size) {
			throw new Exception("Invalid index");
		}
		
		if(index==0) {
			return removeFirst();
		}
		else if(index == this.size-1) {
			return removeLast();
		}
		else {
			Node prevNode = getNodeAt(index-1);
			Node curNode = prevNode.next;
			Node nextNode = curNode.next;
			prevNode.next = nextNode;
			size--;
			return curNode.data;
		}
		
	}

	public void reverseData() throws Exception {
		int left =0;
		int right = this.size-1;
		
		while(left <right) {
			Node leftNode = getNodeAt(left);
			Node rightNode = getNodeAt(right);
			
			int temp = leftNode.data;
			leftNode.data = rightNode.data;
			rightNode.data =temp;
			left++;
			right--;
		}
		return;
	}
	
	
	public void reversePointers() {
		Node prev = this.head;
		Node curr = prev.next;		
		
		while(curr!=null) {
			Node ahead = curr.next;
			curr.next = prev;
			
			prev = curr;
			curr = ahead;
		}
		
		//swap 
		Node t = this.head;
		this.tail = this.head;
		this.head =t;
		
		this.tail.next= null;
	}
	
	
	
	
	public int getMidNode() {
		
		
		
		Node slowPtr = this.head;
		Node fastPtr = this.head;
		
		while(fastPtr.next != null && fastPtr.next.next!=null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		
		
		int midNode = slowPtr.data;
		return midNode;
		
	}
}

