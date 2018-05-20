package Thoughtworks;

import java.util.Scanner;

public class CompareStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Q = sc.nextInt(); sc.nextLine();
		String a = sc.nextLine();
		String b = sc.nextLine();
		for(int t=0; t<Q ;t++) {
			int index = sc.nextInt();
			//System.out.println(index);
			char tempArray[] = b.toCharArray();
			tempArray[N-index]='1';
			b = new String(tempArray);
			System.out.println( b);
			if(compare(a, b)) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			
		}
		
	}
	
	private static boolean compare(String a , String b) {
		
		for(int i=0; i<a.length() ;i++) {
			if(a.charAt(i) < b.charAt(i)) {
				return true;
			}
			else if(a.charAt(i) > b.charAt(i)) {
				return false;
			}
		}
		return true;
	}

}
