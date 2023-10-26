package com.codingpractice.backtrackingAndRecursion;

import java.util.ArrayList;

public class PermuteStar {

	public static void main(String args[]) {
		
		star("1100**1*");
	}
	
	
	
	public static void star(String pattern) {
		int n = pattern.length();
		int pos[] = new int[n];
		
		int countStar =0;
		for(int i=0; i<n ;i++) {
			if(pattern.charAt(i)=='*') {
				pos[i] =1;
				countStar++;
			}
		}
		
		ArrayList<String> allPerms = new ArrayList<>();
		
		
		list(countStar,"", allPerms);
		
		for(String s : allPerms) {
			StringBuilder out = new StringBuilder(pattern);
			
			int numPos =0;
			for(int i=0; i<n;i++) {
				
				if(out.charAt(i)=='*') {
					
					out.setCharAt(i, s.charAt(numPos));
					numPos++;
				}
			}
			
			System.out.println(out);
		}
		
		
		
		
	}
	
	
	public static void list(int n, String soFar , ArrayList<String> list){
		if(n<0)return;
		
		if(n==0) {
			//System.out.println(soFar);
			list.add(soFar);
			return;
		}
		
		list(n-1, soFar+"0", list);
		list(n-1, soFar+"1", list);
		return;
	}
}
