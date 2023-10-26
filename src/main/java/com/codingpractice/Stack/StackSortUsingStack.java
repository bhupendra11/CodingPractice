package com.codingpractice.Stack;

import java.util.Stack;
import java.util.concurrent.SynchronousQueue;

public class StackSortUsingStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {17,4,23,13,95,-1, 66,14,2};
		
		Stack<Integer> sorted = sort(arr);
		while(!sorted.isEmpty()) {
			System.out.print(sorted.pop()+" ");
		}
	}
	
	
	private static Stack<Integer> sort(int arr[]){
		
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		
		for(int i :arr) {
			s1.push(i);
		}
		
		while(!s1.isEmpty()) {
			int temp = s1.pop();
			
			while(!s2.isEmpty() && s2.peek() > temp ) {
				s1.push(s2.pop());
			}
			s2.push(temp);
		}
		
		
		return s2;
		
	}
	

}
