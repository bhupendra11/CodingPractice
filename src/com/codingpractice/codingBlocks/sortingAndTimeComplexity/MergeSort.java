package com.codingpractice.codingBlocks.sortingAndTimeComplexity;

public class MergeSort {
	
	
	public static void main(String args[]) {
		
		int arr[] ={5, 15, 10,20,30,40,50,30, 45, 60, 75, 87};
		
		int res[] = mergeSort(arr, 0, arr.length-1);
		
		for(int i: res) {
			System.out.print(i+" ");
		}
	}

	public static int[] mergeSort(int[] arr, int low, int high) {
		
		if(low==high) {
			int temp[] = new int[1];
			temp[0] = arr[low];
			return temp;
		}
		
		int mid = (low+high)/2;
		
		int[] first = mergeSort(arr, low, mid);
		int[] second= mergeSort(arr, mid+1, high);
		
		return mergeTwoSortedArrays(first, second);
		
	}
	
	public static int[] mergeTwoSortedArrays(int arr1[] , int arr2[]) {
		int[] merged = new int[arr1.length+arr2.length];
		int i=0, j=0, k=0;
		
		while(i < arr1.length && j <arr2.length) {
			if(arr1[i] <= arr2[j]) {
				merged[k] =arr1[i];
				i++;
			}
			else {
				merged[k] =arr2[j];
				j++;
			}
			k++;
		}
		
		if(i==arr1.length) {
			while(j<arr2.length) {
				merged[k] = arr2[j];
				j++;
				k++;
			}
		}
		
		if(j==arr2.length) {
			while(i<arr1.length) {
				merged[k] = arr1[i];
				i++;
				k++;
			}
		}
		
		return merged;
	}
	
}
