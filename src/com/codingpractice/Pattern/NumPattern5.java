package com.codingpractice.Pattern;

import java.util.Scanner;

public class NumPattern5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int row = 1;
			
			int nst =1;
			int val=1;
			while(row<=n) {
				//work
				
				int cst=1;
				while(cst<=nst) {
					if(cst%2==0) {
						System.out.print("*");
					}
					else {
						System.out.print(val);
					}
					
					cst++;
				}
				
				//prep;
				System.out.println();
				if(row<=n/2) {
					nst+=2;
					val++;
				}
				else {
					nst-=2;
					val--;
				}
				
				row++;
			}
			
	}

}
