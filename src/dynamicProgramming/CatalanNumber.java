package dynamicProgramming;

import java.util.Arrays;

public class CatalanNumber {

	public static void main(String args[]) {
		int n=19;
		
		
		
		int arr[] = new int[n+1];
		Arrays.fill(arr, 1);
		System.out.println(catalanDP(n,arr));
		
		System.out.println(catalanRecursive(n));
	}

	private static int catalanDP(int n, int arr[]) {
		// TODO Auto-generated method stub
		//if(n==1)return 1;
		if(arr[n]!= 1)return arr[n];
		
		arr[n]=0;
		for(int i=1; i<=n;i++) {
			arr[n] += catalanRecursive(i-1)*catalanRecursive(n-i);;
		}
		return arr[n];
	}

	private static int catalanRecursive(int n ) {
		if(n==0)return 1;
		int count=0;
		for(int i=1; i<=n ;i++) {
			count += catalanRecursive(i-1)*catalanRecursive(n-i);
		}
		return count;
	}
}
