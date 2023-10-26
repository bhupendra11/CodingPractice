package com.codingpractice.Stack;

import java.util.Arrays;
import java.util.Stack;

public class StackSpan {

	public static void main(String args[]) {

		int arr[] = { 100, 80, 60, 70, 60, 75, 85 };
		int[] resultSpan = stockSpanUsingStack(arr);//bruteForceSpan(arr);
		System.out.println(Arrays.toString(resultSpan));

	}

	/*public static int[] bruteForceSpan(int arr[]) {
		int n = arr.length;
		int[] span = new int[n];
		span[0] = 1;
		for (int i = 1; i < n; i++) {
			int curSpan = 1;
			for (int j = i ; j >= 1; j--) {

				if (arr[i] > arr[j - 1]) {
					curSpan++;
				}
				else break;
			}
			span[i] = curSpan;

		}

		return span;
	}*/
	
	
	public static int[] stockSpanUsingStack(int arr[]) {
		int n = arr.length;
		int[] span = new int[n];
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		span[0]=1;
		
		for(int i=1; i<n ;i++) {
			
			while(!stack.empty() && arr[stack.peek()] <= arr[i]) {
				stack.pop();
			}
			
			span[i] =(stack.isEmpty()) ?  i : (i-stack.peek()); 
			
			stack.push(i);
		}
		
		
		
		return span;
	}
}
