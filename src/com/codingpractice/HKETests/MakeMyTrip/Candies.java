package com.codingpractice.HKETests.MakeMyTrip;

import java.util.Scanner;

public class Candies {

	
	/**TestCase
	 babammm
	 2
	 2
	 5
	  
	 */
	public static void main(String args[]) {
	
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int T = sc.nextInt();
		for(int t=0 ;t<T ;t++) {
			int k = sc.nextInt();
			int n = minCost(s, k);
			System.out.println(n);
		}
	}
	
	private static int minCost(String s, int k) {
		
		int length =k;
		
		int i=0;
		while(length != s.length()) {
			i=0;
			while(i +length != s.length()) {
				String sub = s.substring(i, i+length);
				if(isPain(sub)) {
					return length;
				}
				i++;
			}
			length++;
		}
		
		return -1;
	}
	
	private static boolean isPain(String s) {
		int arr[] = new int[26];
		int l = s.length();
		
		for(int i=0; i<l;i++) {
			char c= s.charAt(i);
			arr[c-'a']++;
		}
		
		int odd =0;
		
		for(int i=0; i<26;i++) {
			if(arr[i] %2 !=0)odd++;
		}
		
		if((l%2==0 && odd==0)||(l%2!=0 && odd==1))return true;
		return false;
	}
	
}
