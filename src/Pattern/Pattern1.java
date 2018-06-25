package Pattern;

import java.util.Scanner;

public class Pattern1 {

	/*
	 5
	 *****
	 *****
	 *****
	 *****
	 *****

	 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int row =1;
		
		while(row<=n) {
			//work
			int col=1;
			while(col<=n) {
				System.out.print("*");
				col++;
			}
		
			
			
			//prep
			System.out.println();
			row++;
		}
	}

}
