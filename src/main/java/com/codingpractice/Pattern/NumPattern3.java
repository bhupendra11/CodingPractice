package com.codingpractice.Pattern;

import java.util.Scanner;

public class NumPattern3 {
	
	/*
	  
	  5
				1	
			2	3	4	
		5	6	7	8	9	
	10	11	12	13	14	15	16	
17	18	19	20	21	22	23	24	25	

	  
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int row =1;
		int nst =1;
		int nsp=n-1;
		int val =1;
		
		while(row<=n) {
			
			//work
			int csp =1;
			while(csp<=nsp) {
				System.out.print("\t");
				csp++;
			}
			
			int cst =1;
			while(cst<=nst) {
				System.out.print(val+"\t");
				val++;
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
