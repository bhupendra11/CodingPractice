package Pattern;

import java.util.Scanner;

public class Pattern6 {
	/*
	6
	*
	**
	***
	****
	*****
	******
	*****
	****
	***
	**
	*
	 
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int row =1;
		int nr = 2*n-1;
		int nst=1;
		while(row<=nr) {
			
			//work
			int cst=1;
			while(cst<=nst) {
				System.out.print("*");
				cst++;
			}
			
			//prep
			System.out.println();
			if(row<n) {
				nst++;
			}
			else {
				nst--;
			}
			row++;
		}

	}

}
