package Pattern;

import java.util.Scanner;

public class Pattern4 {
	
	/*
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
		int row=1;
		int nsp=n-1;
		int nst=1;
		while(row<=n) {
			
			//work
			int csp=1;
			while(csp<=nsp) {
				System.out.print(" ");
				csp++;
			}
			
			int cst=1;
			while(cst<=nst) {
				System.out.print("*");
				cst++;
			}
			
			//prep
			System.out.println();
			row++;
			nsp--;
			nst++;
			
		}
		
	}

}
