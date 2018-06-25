package Pattern;

import java.util.Scanner;

public class Pattern3 {

	/*
	 6
	 ******
	 *****
	 ****
	 ***
	 **
	 *
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int row =1;
		
		int nst=n;
		while(row<=n) {
			
			//work
			int cst=1;
			while(cst<=nst) {
				System.out.print("*");
				cst++;
			}
			
			//prep
			System.out.println();
			nst--;
			row++;
		}
		
		
	}
}
