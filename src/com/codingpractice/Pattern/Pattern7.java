package com.codingpractice.Pattern;

import java.util.Scanner;

public class Pattern7 {
	
	/*
	 
	7
	*** ***
	**   **
	*     *
	       
	*     *
	**   **
	*** ***
	 
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int row =1;
		
		int nst = n/2;
		int nsp=1;
		while(row<=n) {
			//work
			//print stars
			int cst =1;
			while(cst<=nst) {
				System.out.print("*");
				cst++;
			}
			
			//print space
			int csp =1;
			while(csp<=nsp) {
				System.out.print(" ");
				csp++;
			}
			//print stars
			cst =1;
			while(cst<=nst) {
				System.out.print("*");
				cst++;
			}
			
			//prep
			System.out.println();
			if(row<=n/2) {
				nst--;
				nsp+=2;
			}
			else {
				nst++;
				nsp-=2;
			}
			row++;
		}

	}

}
