package WhatFix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class KthFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); sc.nextLine();
		for(int t=0; t<T ;t++) {
			String s = sc.nextLine();
			int k = sc.nextInt();sc.nextLine();
			char arr[] = s.toCharArray();
			Arrays.sort(arr);
			String sortedString = new String(arr);
			char res = kth(sortedString,k);
			System.out.println(res);
		}
	}
	
	
	private static char kth(String s, int k) {
		char c;
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0; i<s.length();i++) {
			  c = s.charAt(i);
			  if(map.containsKey(c)) {
				  map.put(c, map.get(c)+1);
			  }
			  else {
				  map.put(c, 1);
			  }
		}
		
		Map<Character, Integer> sortedMap = sortByValues(map);
		char prevKey='1';
		int prevValue =-1;
		
		for(Entry<Character, Integer> entry : sortedMap.entrySet()) {
			//System.out.println(entry.getKey()+" "+entry.getValue());
			
			if(k==0) {
				return prevKey;
			}
			if(prevValue!= entry.getValue()) {
				k--;
			}
			if(k==0) {
				return entry.getKey();
			}
			
			prevKey = entry.getKey();
			prevValue = entry.getValue();
			
			
			
			
			
		}
		
		if(k==0)
			return prevKey;
		else return '1';
	}
	
	
	private static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
	    Comparator<K> valueComparator =  new Comparator<K>() {
	        public int compare(K k1, K k2) {
	            int compare = map.get(k2).compareTo(map.get(k1));
	            if (compare == 0) return 1;
	            else return compare;
	        }
	    };
	    Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
	    sortedByValues.putAll(map);
	    return sortedByValues;
	}

	
	
	/*
2
aabcd
3
aabcd
2	
	
	*/
}
