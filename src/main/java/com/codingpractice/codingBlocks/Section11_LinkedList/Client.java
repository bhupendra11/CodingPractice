package com.codingpractice.codingBlocks.Section11_LinkedList;

public class Client {

	public static void main(String[] args)  throws Exception{
		
		LinkedList linkedList = new LinkedList();
		
		//System.out.println(linkedList.getLast());
		
		linkedList.addFirst(10);
		linkedList.addFirst(20);
		linkedList.addFirst(30);
		linkedList.addFirst(40);
		
		linkedList.display();
		System.out.println(linkedList.getFirst());
		System.out.println(linkedList.getLast());
		System.out.println(linkedList.getAt(1));
		System.out.println(linkedList.removeFirst());
		linkedList.display();
		System.out.println(linkedList.removeLast());
		linkedList.display();
		
		linkedList.addLast(200);
		linkedList.addLast(300);
		
		System.out.println(linkedList.removeAt(3));
		linkedList.display();
		
		linkedList.reverseData();
		linkedList.display();
		
		linkedList.addLast(400);
		
		linkedList.reverseData();
		linkedList.display();
		
		linkedList.reverseData();
		linkedList.display();
		
		System.out.println(linkedList.getMidNode());
		linkedList.addLast(100);
		linkedList.display();
		System.out.println(linkedList.getMidNode());
		
	}

}
