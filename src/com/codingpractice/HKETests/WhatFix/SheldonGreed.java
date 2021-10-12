package com.codingpractice.HKETests.WhatFix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SheldonGreed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); 
		for(int t=0; t<T ;t++) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0; i<n ;i++) {
				arr[i] = sc.nextInt();
			}
			
			//System.out.println(min(arr ));
			ArrayList<ArrayList<Integer>>  subLists = getList(arr);
			
			
			
			int reqOr = getOr(subLists.get(subLists.size()-1));
			int min = n;
			
			for(int i=1; i<subLists.size();i++) {
				List<Integer> curList = subLists.get(i);
				int or = getOr(curList);
				
				if(or==reqOr && curList.size()<min) {
					min = curList.size();
				}
				
			}
			System.out.println(min);
		}
	}

	private static int getOr(List<Integer> list) {
		
		int res= list.get(0);
		for(int i=1 ; i<list.size();i++) {
			res |= list.get(i);
		}
		
		return res;
	}
	
	
	
	
	
	private static ArrayList<ArrayList<Integer>> getList(int[] set)
	{
        int n = set.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // Run a loop for printing all 2^n
        // subsets one by obe
        for (int i = 0; i < (1<<n); i++)
        {
           ArrayList<Integer> list = new ArrayList<>();
 
            // Print current subset
            for (int j = 0; j < n; j++) {
 
                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0) {
                	//System.out.print(set[j] + " ");
                	list.add(set[j]);
                }
            }
 
          result.add(list);
        }
        
        return result;
    }

}
