package com.codingpractice.codingBlocks.Section6Theory;

public class RecursionDemo {
		public static void main(String args[]) {
			//recursion while stack is building
			//PI(5);
			
			//Print while stack is decreasing
			//	PD(5);
			
			//PrintDecreasingIncreasing
			//PDI(5);
			
			//PrintDeacresing Increasing with skipping alternate element
			//PDISkip(7);
			
			//factorial
			//System.out.println(fact(4));
			
			//Calculate power
			//System.out.println(power(2,5));
			
			//nth fibonacci recursive
			//System.out.println(fib(6));
			
			//check if array is sorted
			int arr[] = {3,8,6,1,9,7, 8, 2};
			int arr2[] = {1,2,3,4,5,6};
			System.out.println(isSorted(arr2, 0));
			
			
			//Find firstIndex
			System.out.println(firstIndex(arr, 0, 8));
			
			//findLastIndex starting from first
			int arr3[] = {3,8,1,8,8,7};
			System.out.println(lastIndex(arr3, 0, 8));
			
		}
		
		public static void PD(int n) {
			if(n==0) {
				return;
			}
			System.out.println(n);
			PD(n-1);
		}
		
		public static void PI(int n ) {
			if(n==0) {
				return;
			}
			PI(n-1);
			System.out.println(n);
		}
		
		public static void PDI(int n) {
			if(n==0) {
				return;
			}
			
			System.out.println(n);
			PDI(n-1);
			System.out.println(n);
			
		}
		
		//Print Decreasing Increasing with skipping 1 element at a time
		public static void PDISkip(int n ) {
			if(n<=0) {
				return;
			}
			
			if(n%2==1) {
				System.out.println(n);
			}
			PDISkip(n-1);
			if(n%2==0) {
				System.out.println(n);
			}
			
		}
		
		//factorial
		public static int fact(int n ) {
			if(n==1) {
				return 1;
			}
			
			int fact1 = fact(n-1);
			return n*fact1;
		}
		
		//power
		public static int power(int x, int n) {
			if(n==1)return x;
			if(n==0)return 1;
			
			int power1 = power(x, n-1);
			int res = x * power1;
			
			return res;
		}
		
		//fibonacci recursive
		public static int fib(int n) {
			
			if(n==0 || n==1)return n;
			
			int fibnm1 = fib(n-1);
			int fibnm2 = fib(n-2);
			int res = fibnm1 +fibnm2;
			
			return res;
			
		}
		
		public static boolean isSorted(int arr[] , int start) {
			if(start ==arr.length-1) {
				return true;
			}
			
			if(arr[start]>arr[start+1]) {
				return false;
			}
			else {
				boolean fnm1 = isSorted(arr, start+1);
				return fnm1;
			}
			
		}
		
		/*
		 * First index at which an element occurs
		 */
		public static int firstIndex(int arr[] , int start, int data) {
			if(start == arr.length) {
				return -1;
			}
			
			if(arr[start]==data) {
				return start;
			}
			else {
				return firstIndex(arr, start+1, data);
			}
		}
		
		/*
		 * LastIndex of occurence of an element, Condition : start searching from first index
		 */
		public static int lastIndex(int arr[] , int start, int data) {
			if(start==arr.length) {
				return -1;
			}
			
			int fnm1 =lastIndex(arr, start+1, data);
			if(fnm1== -1) {
				if(arr[start]==data) {
					return start;
				}
				else return -1;
			}
			else {
				return fnm1;
			}
			
			
		}
		
}
