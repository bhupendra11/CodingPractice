package com.codingpractice.array;
import java.util.ArrayList;

public class Solution {
	
	public static void main(String args[]) {
		int arr[] = {76, 22, 81, 77, 95, 23, 27,35, 24, 38, 15, 90, 19, 46, 53, 6, 77, 96, 100, 85, 43, 16, 73, 18, 7, 66};
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i :arr) {
			list.add(i);
		}
		
		System.out.println(numRange(list, 98, 290));
	}
	
	
    public static int numRange(ArrayList<Integer> A, int B, int C) {
        
        ArrayList<ArrayList<Integer>> subLists = getList(A);
        
        int count =0;
        
        for(ArrayList<Integer> list : subLists){
            System.out.println(list);
            int sumList = getSumList(list);
            
            if(sumList >= B && sumList <= C ){
                count++;
            }
        }
        
        return count;
        
        
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
    
    private static int getSumList(ArrayList<Integer> list){
        int sum =0;
        for(int i : list){
            sum+=i;
        }
        
        return sum;
    }
}
