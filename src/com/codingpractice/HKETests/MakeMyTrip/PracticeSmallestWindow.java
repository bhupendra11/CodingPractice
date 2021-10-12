package com.codingpractice.HKETests.MakeMyTrip;

import java.util.*;
import java.lang.*;
import java.io.*;

public class PracticeSmallestWindow {
	public static void main(String[] args) {
		// code
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int t = 0; t < T; t++) {
			String str = sc.nextLine();
			String win = sc.nextLine();

			String res = findWin(str, win);
			System.out.println(res);
		}
	}

	private static String findWin(String str, String win) {

		HashMap<Character, Integer> map = new HashMap<>();
		int mapMin = Integer.MAX_VALUE;
		int mapMax = Integer.MIN_VALUE;

		boolean isFilled = false;

		for (char c : win.toCharArray()) {
			map.put(c, -1);
		}

		// traverse the string
		String min = str;
		Size size=null;

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if (map.containsKey(ch)) { // do something

				map.put(ch, i);
				if (i < mapMin)
					mapMin = i;
				if (i > mapMax)
					mapMax = i;
				if ((size =isFiiledOnce(map)) != null) {
					isFilled=true;
					mapMin =size.min;
					mapMax= size.max;

					if (min.length() > str.substring(mapMin, mapMax + 1).length()) {
						min = str.substring(mapMin, mapMax + 1);
					}
				}

			}

		}

		if(isFilled)
		return min;
		
		return "-1";

	}
	
	
	static class Size{
		int min;
		int max;
	}

	private static Size isFiiledOnce(HashMap<Character, Integer> map) {

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int count = 0;

		for (char c : map.keySet()) {
			int val = map.get(c);
			if (val > -1) {
				count++;
				
				if(val <min)min =val;
				if(val> max)max =val;
				
			}
		}

		if (count == map.keySet().size()) {
			Size size = new Size();
			size.min= min;
			size.max=max;
			return size;
		}
			
		return null;

	}
}