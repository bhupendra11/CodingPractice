package com.codingpractice.array;

public class StringToNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "12389654";
		
		int num = stringToNum(s);
		
		System.out.println(num);
	}

	private static int stringToNum(String s) {
		
		int mult =1;
		int num=0;
		
		for(int i=s.length()-1 ; i>=0;i--) {
			char cur = s.charAt(i);
			if(cur >='0' && cur <='9') {
				int n = cur -'0';
				num += n*mult;
				mult*=10;
			}
			else throw new NumberFormatException();
		}
		
		
		return num;
		
	}

}
