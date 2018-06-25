package Pattern;

import java.util.Scanner;

public class Pattern8 {

	/*
	 7
	   *
	  ***
	 *****
	*******
	 *****
	  ***
	   *
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int row =1;
		int nst=1;
		int nsp= n/2;
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
			if(row<=n/2) {
				nsp--;
				nst+=2;
			}
			else {
				nsp++;
				nst-=2;
			}
			row++;
			
		}

	}

}
