package com.codingpractice.dynamicProgramming;

import java.util.Scanner;

/**
 * 
 * @author Bhupendra Shekhawat
 *
 */

/*PROBLEM :
 * Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert "str1" into "str2".

Insert
Remove
Replace
All of the above operations are of cost=1.
Both the strings are of lowercase.
 */
public class EditDistance {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<T ;i++) {
			sc.nextLine();
			String arr[] = sc.nextLine().split(" ");
			String s1 = arr[0];
			String s2= arr[1];
			
			System.out.println("Params : "+s1+" "+s2+" "+s1.length()+" "+s2.length());
			System.out.println(editDistance(s1, s2));
			System.out.println(editDistanceRec2(s1, s2,s1.length()	,s2.length()));
			
			//System.out.println(editDistanceRec2(s1,s2,0,0));
		}
	}

	private static int editDistance(String s1, String s2) {
		
		int dp[][] = new int[s1.length()+1][s2.length()+1];
		
		//fill first row 
		for(int i=0; i<=s1.length();i++) {
			dp[i][0] =i; 
		}
		//fill first column		
		for(int i=0; i<=s2.length();i++) {
			dp[0][i] =i; 
		}
		for(int i=1; i<=s1.length();i++) {
			for(int j=1; j<=s2.length();j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
				}
			}
		}
		return dp[s1.length()][s2.length()];
	}
	
	
	/*private static int editDistanceRec(String s1, String s2 , int m , int n) {
		
		System.out.println("here");
		
		if(m== s1.length()) {
			return s1.length()- n+1;
		}
		else if( n==s2.length()) {
			return s2.length() -m+1;
		}
		
		if(s1.charAt(m)==s2.charAt(n)) {
			return editDistanceRec(s1, s2, m+1, n+1);
		}
		else {
			System.out.println("Inside   m = "+m +" n = "+n);
			int res = Math.min(Math.min(editDistanceRec(s1, s2, m+1, n), editDistanceRec(s1,s2, m, n+1)   ),editDistanceRec(s1,s2,m+1,n+1) ) +1;
			System.out.println("res = "+res);
			return res;
		}
		
		
		
		
	}*/
	
	private static int editDistanceRec2(String s1, String s2, int m, int n) {
	
		if (m == 0) {
			return n;
		}
		if (n == 0) {
			return m;
		}
		if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
			return editDistanceRec2(s1, s2, m - 1, n - 1);
		}
		return Math.min(Math.min(editDistanceRec2(s1, s2, m - 1, n), editDistanceRec2(s1, s2, m, n - 1)),
				editDistanceRec2(s1, s2, m - 1, n - 1)) + 1;
	}
	
	/*
	 Sample test case
	 1
	12 70
	hrrdsycqhkle ewhxtembaqwqwpqhsuebnvfgvjwdvjjafqzzxlcxdzncqgjlapopkvxfgvicetcmkbljop 
	
	Ans : 64
	 
	 */
	
}
