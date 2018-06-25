package Pattern;

import java.util.Scanner;

public class Pattern9 {

	/*
	 
	7
	*           *
	**         **
	***       ***
	****     ****
	*****   *****
	****** ******
	*************

	 
	 */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int row =1;
		int nst=1;
		int nsp= 2*n-3;
		while(row<=n) {
			
			//work
			int cst=1;
			while(cst<= nst) {
				System.out.print("*");
				cst++;
			}
			
			int csp=1;
			while(csp<=nsp) {
				System.out.print(" ");
				csp++;
			}
			
			cst =1;
			//for last row edge condition
			if(row==n)cst=2;
			while(cst<= nst) {
				System.out.print("*");
				cst++;
			}
			
			//prep
			System.out.println();
			nst++;
			nsp-=2;
			row++;
			
		}

	}

}
