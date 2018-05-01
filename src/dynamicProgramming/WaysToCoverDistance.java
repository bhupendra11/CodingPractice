package dynamicProgramming;

import java.util.Arrays;

public class WaysToCoverDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n =5;
		int arr[] = new int[n+1];
		Arrays.fill(arr,  -1);
		System.out.println(ways(1, arr));
		System.out.println(ways(5, arr));
	}

	
	public static int ways(int n, int[] arr) {
		if(n ==0)return 1;
		
		if(n<0)return 0;
		
		if(arr[n]!=-1)return arr[n];
		
		arr[n]=  ways(n-1,arr) + ways(n-2,arr)+ways(n-3,arr);
		return arr[n];
	}
}


/*

11111    1211   122 1121 1112
2111     221   212
311     32
*/