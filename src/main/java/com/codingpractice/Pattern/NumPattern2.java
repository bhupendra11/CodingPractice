package com.codingpractice.Pattern;

import java.util.Scanner;

public class NumPattern2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int row = 1;
		int nsp =n-1;
		int nst =1;
		int val =1;
		
		while(row<=n) {
			val=row;
			//work
			int csp =1;
			while(csp <=nsp) {
				System.out.print(" ");
				csp++;
			}
			
			int cst=1;
			while(cst<= nst) {
				System.out.print(val);
				cst++;
			}
			
			//prep
			System.out.println();
			nsp--;
			nst+=2;
			row++;
			
			
		}
	}

}
