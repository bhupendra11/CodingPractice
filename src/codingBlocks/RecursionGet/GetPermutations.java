package codingBlocks.RecursionGet;

import java.util.ArrayList;

public class GetPermutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> allPerms = allPermutations("abc");
		System.out.println(allPerms);
		
	}

	private static ArrayList<String> allPermutations(String str){
		
		if(str.length()==0) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		
		char curChar = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> recSesult = allPermutations(ros);
		
		for(String rrs : recSesult) {
			
			for(int i=0; i<= rrs.length(); i++) {
				String prev = rrs.substring(0, i);
				String rest = rrs.substring(i);
				String made = prev + curChar+rest;
				mr.add(made);
			}
			
		}
		return mr;
	}
}
