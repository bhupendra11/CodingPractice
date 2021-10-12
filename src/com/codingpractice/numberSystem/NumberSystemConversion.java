package com.codingpractice.numberSystem;

import java.util.Scanner;

public class NumberSystemConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int baseFrom = sc.nextInt();
		int baseTo = sc.nextInt();
		int num = sc.nextInt();
		int res = convert(baseFrom, baseTo, num);
		System.out.println(res);
	}
	
	private static int convert(int baseFrom, int baseTo, int num) {
		int res=0, i=0, rem=0;
        
        //convert from baseFrom to decimal
        int decimal =0;
        if(baseFrom != 10){
            while(num!= 0){
                rem = num%10;
                res += rem * Math.pow(baseFrom, i);
                i++;
                num = num/10;
            }
            decimal = res;
        }
        else{
            decimal = num;
        }
        //convert from decimal to baseTo
        res=0; i=0; rem=0;
        
        while(decimal !=0){
            rem = decimal%baseTo;
            res += rem * Math.pow(10, i);
            i++;
            decimal = decimal/baseTo;
        }
        
        
        return res;

	}

}
