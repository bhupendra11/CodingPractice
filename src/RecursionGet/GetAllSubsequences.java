package RecursionGet;

import java.util.ArrayList;

public class GetAllSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abc";
		ArrayList<String> list = getSubsequences(str);
		for(String s : list) {
			System.out.println(s);
		}
	}

	private static ArrayList<String> getSubsequences(String s){
		
		
		if(s.length()==0) {
			ArrayList<String>base= new ArrayList<>();
			base.add("");
			return base;
		}
		ArrayList<String> list = new ArrayList<>();
		//getSubs(s, "", new String(s), list);
		char curChar = s.charAt(0);
		String remaining = s.substring(1);
		ArrayList<String> recResult = getSubsequences(remaining);
		
		for(int i=0; i<recResult.size();i++) {
			list.add(recResult.get(i));
			list.add(curChar+recResult.get(i));
		}
		
		
		
		return list;
	}
	
}
