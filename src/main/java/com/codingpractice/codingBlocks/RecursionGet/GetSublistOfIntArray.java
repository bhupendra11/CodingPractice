package com.codingpractice.codingBlocks.RecursionGet;

import java.util.ArrayList;

public class GetSublistOfIntArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> input = new ArrayList<>();
		input.add(1);
		input.add(2);
		input.add(3);
		input.add(4);
		input.add(5);
		
		ArrayList<ArrayList<Integer>> list = getList(input);
		
		for(ArrayList item :list) {
			System.out.println(item);
		}
	}

	
	 private static ArrayList<ArrayList<Integer>> getList(ArrayList<Integer> list ){
	        ArrayList<ArrayList<Integer>> result  = new ArrayList<>();
	        for(int i=0; i<list.size() ; i++){
	            for(int j=i; j<list.size() ; j++){
	                ArrayList<Integer> curr = new ArrayList<Integer>(list.subList(i,j+1));
	                result.add(curr);
	            }
	        }
	        return result;
	    }
	    
}
