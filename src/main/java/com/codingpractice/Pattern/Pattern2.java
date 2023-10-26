package com.codingpractice.Pattern;

import java.util.Scanner;

public class Pattern2 {
	
	/**
	5
	*
	**
	***
	****
	*****
 	 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int nst=1;
		int row=1;
		while(row<=n) {
			//work
			int cst=1;
			while(cst<=nst) {
				System.out.print("*");
				cst++;
			}
			
			//prep
			System.out.println();
			nst++;
			row++;
		}
	}

}
