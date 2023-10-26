package com.codingpractice.Graphs;

import java.util.LinkedList;
import java.util.Queue;

class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class SortedListToBST{
    public TreeNode sortedListToBST(ListNode head) {
        
        if(head==null)return null;
        ListNode cur = head;
        
        if(head.next==null) {
        	TreeNode node = new TreeNode(head.val);
        	return node;
        }
        
        ListNode mid = util(head);        
        
        if(mid==null)return null;
        
        System.out.println("Mid = "+mid.val);
        
        TreeNode node = new TreeNode(mid.val);
        
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);
        
        return node;
        
    }
    
    
	private static ListNode util(ListNode node){
	        
	        if(node == null)return null;
	        if(node.next==null)return node;
	        ListNode prev = null;
	        ListNode firstPtr = node;
	        ListNode secPtr = node;
	        
	        while(secPtr!= null && secPtr.next!= null){
	            prev = firstPtr;
	            firstPtr = firstPtr.next;
	            secPtr = secPtr.next.next;
	        }

	        if(prev ==null)return firstPtr;
	        prev.next = null;
	        return firstPtr;
	    }
    
    public static void main(String args[]) {
    	ListNode head = new ListNode(-10);
    	
    	ListNode cur = head;
    	cur.next= new ListNode(-3);
    	cur = cur.next;
    	
    	cur.next = new ListNode(0);
    	cur = cur.next;
    	
    	cur.next = new ListNode(5);
    	cur = cur.next;
    	
    	cur.next = new ListNode(9);
    	
    	
    	SortedListToBST sortedToBST = new SortedListToBST();
    	TreeNode res = sortedToBST.sortedListToBST(head);
    	printLevelOrder(res);
    	
    	
    	
    }
    
    private static  void printLevelOrder(TreeNode root) 
    {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) 
        {
 
            /* poll() removes the present head.
            For more information on poll() visit 
            http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
        	TreeNode tempNode = queue.poll();
            System.out.print(tempNode.val + " ");
 
            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
 
            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
}