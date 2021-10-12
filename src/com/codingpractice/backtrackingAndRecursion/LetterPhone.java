package com.codingpractice.backtrackingAndRecursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterPhone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list = letterCombinations("234");
		System.out.println(list);
		
	}

	
	 public static List<String> letterCombinations(String digits) {
	        
	        List<String> input = new ArrayList<>();
	        HashMap<Integer, String> map = getMap();
	        
	        for(char c : digits.toCharArray()){
	            int n = Character.getNumericValue(c);
	            input.add(map.get(n));
	        }
	        
	        
	        return getLetterCombinations(input);
	        
	        
	    }
	    
	    
	    private static List<String> getLetterCombinations( List<String> input ){
	        
	        List<String> result = new ArrayList<>();
	       if(input.size()==0){
	           return result;
	       }
	        if(input.size()==1) {
	        	String s = input.get(0);
	        	for(int i=0; i<s.length();i++) {
	        		result.add(String.valueOf(s.charAt(i)));
	        	}
	        }
	        
	        if(input.size()==2){
	            String a = input.get(0);
	            String b = input.get(1);
	            
	            for(int i=0; i<a.length() ;i++){
	                for(int j=0; j<b.length();j++){
	                	String toAdd = String.valueOf(a.charAt(i))+String.valueOf(b.charAt(j))+"";
	                    result.add(result.size(),toAdd);
	                }
	            }
	             return result;
	        }
	        
	        List<String>  interimResult = getLetterCombinations(input.subList(1, input.size()));
	        
	        String cur = input.get(0);
	        
	        
	        for(int i=0; i<cur.length();i++) {
	        	for(String s : interimResult) {
	        		result.add(result.size(), cur.charAt(i)+s);
	        	}
	        	
	        }
	        return result;
	       
	        
	    }
	    
	    private static HashMap<Integer, String> getMap(){
	        HashMap<Integer, String> map = new HashMap<>();
	        map.put(2, "abc");
	        map.put(3, "def");
	        map.put(4, "ghi");
	        map.put(5, "jkl");
	        map.put(6, "mno");
	        map.put(7, "pqrs");
	        map.put(8, "tuv");
	        map.put(9, "wxyz");
	        
	        return map;
	    }
}
