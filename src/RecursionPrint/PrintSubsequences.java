package RecursionPrint;

public class PrintSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		printSubsequences("abc", "");
	}
	
	private static void printSubsequences(String rest, String soFar) {
		if(rest.length()==0) {
			System.out.println(soFar);
			return;
		}
		
		/*for(int i=0; i<rest.length(); i++) {
			char cur = rest.charAt(i);
			String remaining = rest.substring(0, i) +rest.substring(i+1);
			//printSubsequences(remaining, soFar);
			printSubsequences(remaining, soFar+cur);
		}*/
		
		char cur = rest.charAt(0);
		String remaining = rest.substring(1);
		printSubsequences(remaining, soFar);
		printSubsequences(remaining, soFar+cur);
		
		
	}

}
