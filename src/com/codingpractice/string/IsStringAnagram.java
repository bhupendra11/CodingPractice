package com.codingpractice.string;

public class IsStringAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "aabbsscdg";
		String s2 = "ababscsqd";
		boolean res = isAnagram(s1, s2);
		System.out.println(res);
				
	}

	private static boolean isAnagram(String s1, String s2) {
		
		int arr[] = new int[256];
		int arr2[] = new int[256];
		
		if(s1.length()!=s2.length())return false;
		
		for(int i=0; i<s1.length();i++) {
			arr[s1.charAt(i)] ++;
			arr2[s2.charAt(i)] ++;
		}
		
		for(int i=0; i<256;i++) {
			if(arr[i] != arr2[i])return false;
		}
		
		
		return true;
	}
}
