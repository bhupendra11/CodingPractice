package com.codingpractice.codingBlocks.Section6Theory;

public class BubbleSort {
	public static void main(String args[]) {
		int arr[] = {50,40,30,20,10};
		bubbleSort(arr, 0, arr.length-1);
		
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
	
	private static void bubbleSort(int arr[] , int start, int last) {
		if(last==0) {
			return;
		}
		
		if(start==last) {
			bubbleSort(arr, 0, last-1);
			return;
		}
		
		if(arr[start]> arr[start+1]) {
			int temp = arr[start];
			arr[start ]= arr[start+1];
			arr[start+1]=temp;
			
		}
		bubbleSort(arr, start+1, last);
		
	}
}
