package RecursionPrint;

public class PrintPermutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printPermutations("abc", "");
	}
	
	private static void printPermutations(String rest, String soFar) {
		if(rest.length()==0) {
			System.out.println(soFar);
			return;
		}
		
		for(int i=0; i<rest.length();i++) {
			char curChar = rest.charAt(i);
			String remaining = rest.substring(0, i)+rest.substring(i+1);
			printPermutations(remaining, soFar+curChar);
		}
	}

}
