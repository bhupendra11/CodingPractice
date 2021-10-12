package com.codingpractice.array;

public class SpiralOrder {

	public static void main(String args[]) {
		
		int arr[][] = {{1,2,3,4},
						{5,6,7,8},
						{9,10,11,12},
						{13,14,15,16}};
		printSpriral(arr);
		
	}
	
	public static void printSpriral(int[][] arr) {
		
		int left =0 , right = arr[0].length-1 , up=0, down = arr.length-1;
		int dir =0;
		while(left<=right && up<=down) {
			
			if(dir ==0) {				
				for(int i=left ; i<=right ;i++) {
					System.out.print(arr[up][i]+" ");
				}
				dir++;
				up++;
			}
			else if(dir ==1) {
				for(int i=up ; i<=down ;i++) {
					System.out.print(arr[i][right]+" ");
				}
				dir++;
				right--;
			}
			else if(dir==2) {
				for(int i=right ; i>=left ;i--) {
					System.out.print(arr[down][i]+" ");
				}
				dir++;
				down--;
			}
			else if(dir==3) {
				for(int i=down ; i>=up ;i--) {
					System.out.print(arr[i][left]+" ");
				}
				dir=0;
				left++;
			}
			
		}
		
	}
}
