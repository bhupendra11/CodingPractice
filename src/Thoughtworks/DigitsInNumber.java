package Thoughtworks;

import java.util.Scanner;

public class DigitsInNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T ;t++) {
			long n = sc.nextInt();
			
			long res = countDigits(n);
			System.out.println(res);
		}
	}

	private static long countDigits(long n) {
		// TODO Auto-generated method stub
		 long i = 0, rem=n;
	     
		 	if(n==0)return 0;
	        /*if (n == 1) {
	            return 1;
	        }*/
	     
	        while (n > 0 &&rem!=0) {
	             
	            rem = n%3;
	            n /= 3;
	            i++;
	        }
	     
	        return i;
	}

}
