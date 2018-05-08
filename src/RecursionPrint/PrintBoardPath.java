package RecursionPrint;

public class PrintBoardPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         
		System.out.println("Count board path = "+countBoardpath(0, 10));
		printBoardPath(0, 10, "");
	}
	
	public static void printBoardPath(int curr, int end, String soFar) {
		 
		if(curr > end) {
			return;
		}
		if( curr==end) {
			System.out.println(soFar);
			return;
		}
		
		for(int dice=1; dice<=6; dice++) {
			printBoardPath(curr+dice, end, soFar+dice);
		}
	}
	
	public static int countBoardpath(int curr, int end) {
		if(curr==end) {
			return 1;
		}
		if(curr > end) {
			return 0;
		}
		
		
		int count =0;
		for(int dice=1; dice<=6 ;dice++) {
			count += countBoardpath(curr+dice, end);
		}
		
		return count;
	}

}

























































































































































































