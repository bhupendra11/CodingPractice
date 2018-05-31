package HKETests.SamsungRnD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BobAndArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<Integer> input = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			input.add(sc.nextInt());
		}

		Collections.sort(input);
		
		ArrayList<ArrayList<Integer>> list = getSubLists(input);

		/*for (ArrayList<Integer> item : list) {
			System.out.println(item);
		}*/
		
		int out = bitwiseOrSum(list);
		System.out.println(out);

	}
	
	
	private static int bitwiseOrSum(ArrayList<ArrayList<Integer>> list) {
		int sum =0;
		int min =0, max=0;
		int C=1000000007 ;
		for(ArrayList<Integer> item : list) {
			min = item.get(0);
			max = item.get(item.size()-1);
			
			int bitOr = min|max;
			
			sum =    (sum % C + bitOr%C)%C;
		}
		
		
		return sum;
	}
	
	private static ArrayList<ArrayList<Integer>> getSubLists(ArrayList<Integer> list){
		
		int n = list.size();
		ArrayList<ArrayList<Integer>> results = new ArrayList<>();
		ArrayList<Integer> elem;
		 
		
        // Run a loop for printing all 2^n
        // subsets one by obe
        for (int i = 0; i < (1<<n); i++)
        {
            elem = new ArrayList<>();
 
            // Print current subset
            for (int j = 0; j < n; j++)
 
                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0)
                    elem.add(list.get(j));
            
            if(elem.size()>=2)
            	results.add(elem);
        }
		return results;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	private static ArrayList<ArrayList<Integer>> getList(ArrayList<Integer> list) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = i; j < list.size(); j++) {
				ArrayList<Integer> curr = new ArrayList<Integer>(list.subList(i, j + 1));

				if (curr.size() >= 2)
					result.add(curr);
			}
		}
		return result;
	}

	private static ArrayList<ArrayList<Integer>> allPermutations(ArrayList<Integer> list) {

		if (list.size() == 0) {
			ArrayList<ArrayList<Integer>> base = new ArrayList<>();
			base.add(new ArrayList<>());
			return base;
		}

		int first  = list.get(0);
		List<Integer> ros = list.subList(1, list.size());
		ArrayList<ArrayList<Integer>> mr = new ArrayList<>();
		ArrayList<ArrayList<Integer>> recResult = allPermutations(new ArrayList<>(ros));

		for (ArrayList<Integer> rrs : recResult) {

			for (int i = 0; i <= rrs.size(); i++) {
				ArrayList<Integer> prev = new ArrayList<>( rrs.subList(0, i));
				ArrayList<Integer> rest = new ArrayList<>(rrs.subList(i, rrs.size()));
				ArrayList<Integer> made = new ArrayList<>();
				made.addAll(prev);
				made.add(first);
				made.addAll(rest);
				
				//String made = prev + curChar + rest;
				mr.add(made);
			}

		}
		return mr;
	}

}
