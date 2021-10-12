package com.codingpractice.dynamicProgramming;

/**
 * 
 * @author Bhupendra Shekhawat
 *
 */
//Problem statement : https://www.interviewbit.com/problems/ways-to-decode/
public class WaysToDecode {

	
	public static void main(String args[]) {
		
		String s ="123";
		//int res=  ways(s, s.length());
		//System.out.println(res);
		
		//System.out.println(code("1")+" "+code("26"));
	}
	
	/*private static int ways(String s, int n) {
		
	  if(n==0 || n==1)return 1;
	  
	  int count =0;
	  
	  if(s.charAt(n-1)>'0') {
		  count = ways(s, n-1);
	  }
	  
	  if(s.charAt(n-2) =='1' || s.charAt(n-2)=='2'  && s.charAt(n-1)
			  ) {
		  count+= ways(s,n-2);
	  }
	  return count;	
	}*/
	
	private static boolean  codePossible(String s) {
		if(s.length()>3)return false;
		
		int n =Integer.parseInt(s);
		
		if(n > 26)return false;
		
		return  true;
	}
	
}
