package com.codingpractice.HKETests.Soroco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class Deduplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ip1 = "aaaaaaaaaabbbbbbbbbbaaaaaaaaaabbbbbbbbbbaaaaaaaaaabbbbbbbbbbaaaaaaaaaabbbbbbbbbbaaaaaaaaaabbbbbbbbbbaaaaaaaaaabbbbbbbbbbcccccccccc";
		int chunkSize1 = 10;
		String ip2 = "uqulkfffhxenqcjjncbnuqulkfffhxenqcjjncbnuqulkfffhxenqcjjncbnuqulkfffhxenqcjjncbnuqulkfffhxenqcjjncbn";
		int chunkSize2 = 10;
		
		String intm1 = dedup(ip1,chunkSize1);
		String intm2 = dedup(ip2, chunkSize2);
		
		System.out.println("Intm 1 : "+intm1);
		System.out.println("Intm 2 : "+intm2);
		
		String res1 = redup(intm1, chunkSize1);
		String res2 = redup(intm2, chunkSize2);

		System.out.println("res1 : "+res1.equals(ip1));
		System.out.println("res2 : "+res2);
	}

	static String dedup(String inputStr, int chunkSize) {
		StringBuffer res = new StringBuffer();
		Map<String, ArrayList<Integer>> map = new HashMap<>();
		
		
		int i=0, index =0;
		String cur ="";
		int n = inputStr.length()/chunkSize;
		String arr[] = new String[n];
		while(i != inputStr.length()) {
			arr[index] = inputStr.substring(i, i+chunkSize);
			
			
			cur = arr[index];
			//manipulations
			if(!map.containsKey(cur)) {
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(i);
				map.put(arr[index], temp);
			}
			else {
				ArrayList<Integer> curList = map.get(cur);
				curList.add(i);
			}
			
			i+=chunkSize;
			index++;
			
		}
		
		
		for(String key: map.keySet()) {
			System.out.print(key+" : ");
			
			res.append(key+":");
			
			for(int j : map.get(key)) {
				System.out.print(j+" ");
				res.append(j+",");
			}
			res.deleteCharAt(res.length()-1);
			System.out.println("");
			res.append("-");
		}
		return res.toString().substring(0, res.length()-1);
	}

	static String redup(String deduplicatedStr, int chunkSize) {
		// Write your code here.
		StringBuffer res = new StringBuffer();
		
		
		String entryArr[] = deduplicatedStr.split("-");
		SortedMap<Integer, String> map = new TreeMap<>();
		int lengthOfString =0;
		for(String s : entryArr) {
			String sarr[] = s.split(":");
			String key = sarr[0];
			String val = sarr[1];
			
			String sNums[] = val.split(",");
			int[] nums = new int[sNums.length];
			for(int i=0; i<sNums.length;i++) {
				nums[i] = Integer.parseInt(sNums[i]);
				map.put(nums[i], key);
				
				lengthOfString+= chunkSize;
			}
		}
		
		for(Integer key: map.keySet()) {
			res.append(map.get(key));
		}
		
		return res.toString();
	}
}
