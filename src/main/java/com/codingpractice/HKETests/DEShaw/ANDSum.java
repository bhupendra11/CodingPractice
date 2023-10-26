package com.codingpractice.HKETests.DEShaw;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ANDSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * String str = "123"; ArrayList<String> list = getSubsequences(str); for(int
		 * i=1 ; i< list.size();i++) { System.out.println(list.get(i)); }
		 */

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {

			/*
			 * ArrayList<Integer> input = new ArrayList<>(); input.add(1); input.add(2);
			 * input.add(3);
			 */
			int n = sc.nextInt();
			ArrayList<Integer> input = new ArrayList<>();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				int cur =sc.nextInt();
				input.add(cur);
				arr[i] = cur;
			}

			//ArrayList<ArrayList<Integer>> result = getSubsequences(input, 0);
			ArrayList<ArrayList<Integer>> result = allSubsequences(n, arr);

			int output = 0;
			for (int i = 1; i < result.size(); i++) {
				 System.out.println(result.get(i));
				int bitSum = sumBitWise(result.get(i));
				// System.out.println(bitSum);
				output += bitSum;
			}

			// (A+B)%C = (A%C + B%C)%C

			int toPrint = (int) (output % (Math.pow(10, 9) + 7));
			System.out.println(toPrint);

		}
		sc.close();
	}

	private static int sumBitWise(ArrayList<Integer> list) {
		if (list.size() == 0)
			return 0;

		int sum = list.get(0);

		for (int i = 1; i < list.size(); i++) {
			sum = sum & list.get(i);
		}

		return (int) (sum % (Math.pow(10, 9) + 7));
	}

	private static ArrayList<String> getSubsequences(String s) {

		if (s.length() == 0) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		ArrayList<String> list = new ArrayList<>();
		// getSubs(s, "", new String(s), list);
		char curChar = s.charAt(0);
		String remaining = s.substring(1);
		ArrayList<String> recResult = getSubsequences(remaining);

		for (int i = 0; i < recResult.size(); i++) {
			list.add(recResult.get(i));
			list.add(curChar + recResult.get(i));
		}

		return list;
	}

	private static ArrayList<ArrayList<Integer>> getSubsequences(ArrayList<Integer> s, int start) {

		if (s.size() == start) {
			ArrayList<ArrayList<Integer>> base = new ArrayList<>();
			// ArrayList<String> base = new ArrayList<>();
			base.add(new ArrayList<>());
			// base.add("");
			return base;
		}

		// ArrayList<String> list = new ArrayList<>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		// char curChar = s.charAt(0);
		int curNum = s.get(start);
		// String remaining = s.substring(1);

		// ArrayList<String> recResult = getSubsequences(remaining);
		ArrayList<ArrayList<Integer>> recResult = getSubsequences(s, start + 1);

		for (int i = 0; i < recResult.size(); i++) {
			list.add(new ArrayList<>(recResult.get(i)));
			ArrayList<Integer> addedCurList = new ArrayList<>(recResult.get(i));
			addedCurList.add(curNum);
			list.add(addedCurList);
			// list.add(curChar + recResult.get(i));
		}

		return list;
	}
	
	 private static ArrayList<ArrayList<Integer>> getSubsequences(ArrayList<Integer> s, int start, ArrayList<ArrayList<Integer>> result){
	        
	        if(s.size()==start){
	            ArrayList<ArrayList<Integer>>  base = new ArrayList<>();
	            base.add(new ArrayList<>());
	            return base;
	        }
	        
	       ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	       int curNum = s.get(start);
	       
	       ArrayList<ArrayList<Integer>> recResult = getSubsequences(s, start+1, result);
	       
	       for(int i=0; i<recResult.size(); i++){
	           list.add(new ArrayList<>(recResult.get(i)));
	           
	           ArrayList<Integer> addCurList = new ArrayList<>(recResult.get(i));
	           addCurList.add(curNum);
	           list.add(addCurList);
	       }
	       
	       return list;
	    }
	 
	 public static ArrayList<ArrayList<Integer>> combinations(int[] arr) {
		    ArrayList<ArrayList<Integer>> c = new ArrayList<>();
		    List<Integer> l;
		    for (int i = 0; i < arr.length; i++) {
		      int k = c.size();
		      for (int j = 0; j < k; j++) {
		        l = new ArrayList<Integer>(c.get(j));
		        l.add(new Integer(arr[i]));
		        c.add((ArrayList<Integer>) l);
		      }
		      l = new ArrayList<Integer>();
		      l.add(new Integer(arr[i]));
		      c.add((ArrayList<Integer>) l);
		    }
		    return c;
		}
	 
	 
   static ArrayList<ArrayList<Integer>> allSubsequences(int n, int arr[])
	    {
	   		ArrayList<ArrayList<Integer>>  allSubs = new ArrayList<>();
	        /* Number of subsequences is (2**n -1)*/
	        int opsize = (int)Math.pow(2, n);
	      
	        /* Run from counter 000..1 to 111..1*/
	        for (int counter = 0; counter < opsize; counter++)
	        {	
	        	ArrayList<Integer> list = new ArrayList<>();
	            for (int j = 0; j < n; j++)
	            {
	                /* Check if jth bit in the counter is set
	                    If set then print jth element from arr[] */
	       
	                if (BigInteger.valueOf(counter).testBit(j)) {
	                    //System.out.print(arr[j]+" ");
	                	list.add(arr[j]);
	                }
	            }
	            //System.out.println();
	            allSubs.add(list);
	        }
	        
	        return allSubs;
	    }
}
