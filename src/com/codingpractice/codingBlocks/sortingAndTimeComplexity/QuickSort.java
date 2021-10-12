package com.codingpractice.codingBlocks.sortingAndTimeComplexity;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 5, 15, 10, 20, 30, 40, 50, 30, 45, 60, 75, 87 };

		quickSort(arr, 0, arr.length - 1);

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	private static void quickSort(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		
		if(low>=high)return ;
		int mid = (low + high) / 2;

		int pivot = arr[mid];
		int left = low;
		int right = high;

		while (left <= right) {

			while (arr[left] < pivot) {
				left++;
			}

			while (arr[right] > pivot) {
				right--;
			}

			if (left <= right) {
				// swap
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}

		quickSort(arr, low, right);
		quickSort(arr, left, high);
	}

}
