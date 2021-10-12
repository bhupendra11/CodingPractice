package com.codingpractice.codingBlocks.Section6Theory;

public class Pattern1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		pattern1(5, 1, 1);
	}
	
	public static void pattern1(int n , int row, int col) {
		if(row >n)return;
		if(col > row) {
			System.out.println();
			pattern1(n, row+1, 1);
			return;
		}
		System.out.print("*");
		pattern1(n, row, col+1);
	}

}
