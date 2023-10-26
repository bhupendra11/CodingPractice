package com.codingpractice.Pattern;

import java.util.Scanner;

public class Pattern5 {

	/*
	5
	*****
	 ****
	  ***
	   **
	    *
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int row =1;
		int nst=n;
		int nsp=0;
		
		while(row<=n) {
			
			//work for space
			int csp=1;
			while(csp<=nsp) {
				System.out.print(" ");
				csp++;
			}
			
			//work for stars
			int cst=1;
			while(cst<=nst) {
				System.out.print("*");
				cst++;
			}
			
			//prep
			System.out.println();
			row++;
			nst--;
			nsp++;
		}
	}
}
