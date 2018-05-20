package Sorocco;

public class LargestnoSmallerOrEqualToNNonDecreasing {
	
	public static void main(String args[]) {
		
		int n = 1000;
		printNum(n+"");
		
	}
	
	private static void printNum(String s) {
		
		int num[] = new int[s.length()];
		
		for(int i=0; i<s.length();i++) {
			num[i] = s.charAt(i) -'0';
		}
		
		int index = s.length()-1;
		for(int i=s.length()-1 ; i>0;i--) {
			
			if(num[i-1] > num[i]) {
				index =i-1;
				num[i-1]--;
			}
		}
		
		if(num[0]!=0) {
			for(int i=0; i<=index ;i++) {
				System.out.print(num[i]+" ");
			}
			for(int i=index+1; i<num.length;i++) {
				System.out.print('9'+"");
			}
		}
		else {
			for(int i=1; i<=index ;i++) {
				System.out.print(num[i]+" ");
			}
			for(int i=index+1; i<num.length;i++) {
				System.out.print('9'+"");
			}
		}
		
		
	}

}
