package com.codingpractice.Pattern;

import java.util.Scanner;

public class NumPattern4 {
	
	/*
	  
	 5
				1	
			1	2	1	
		1	2	3	2	1	
	1	2	3	4	3	2	1	
1	2	3	4	5	4	3	2	1	 
	 
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int row =1;
		int nst =1;
		int nsp=n-1;
		int val =1;
		
		while(row<=n) {
			val =1;
			//work
			int csp =1;
			while(csp<=nsp) {
				System.out.print("\t");
				csp++;
			}
			
			int cst =1;
			boolean increase =true;
			while(cst<=nst) {
				System.out.print(val+"\t");
				if(cst<=nst/2) {
					val++;
				}
				else {
					val--;
				}
				cst++;
			}
			
			//prep
			System.out.println();
			row++;
			nst+=2;
			nsp--;
			
		}

	}


}
