package MakeMyTrip;

import java.util.Scanner;

public class BobAndArrayQueries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String  sarr [] =s.split(" ");
		
		int N = Integer.parseInt(sarr[0]);
		long arr[] = new long[N+1];
		int Q = Integer.parseInt(sarr[1]);
		
		int[] preComputed = preComputed();
		
		for(int t=0; t<Q ;t++) {
			
			s = sc.nextLine();
			sarr= s.split(" ");
			
			
			int num = Integer.parseInt(sarr[0]);
			int X = Integer.parseInt(sarr[1]);
			
			if(sarr.length==3) {
				int Y = Integer.parseInt(sarr[2]);
				
				//query 3 X Y
				//long res = perform3XY(arr, X, Y);
				long res = count(arr, X, Y, preComputed);
				System.out.println(res);
			}
			else {
				if(num ==1) {  //query 1 X
					arr[X] = 2* arr[X]+1;
				}
				else if(num==2) { //query 2 X
					arr[X] =  (long) Math.floor(arr[X]/2);
				}
			}
			
		}
	}

	/*private static long perform3XY(long[] arr, int X, int Y) {
		long sum =0;
		for(int i=X ; i<=Y ;i++) {
			sum += Long.bitCount(arr[i]);
		}
		
		return sum;
	}*/
	
	private static long count(long[] arr, int X, int Y , int preComputed[]) {
		long sum =0;
		long n=0;
		for(int i=X ; i<=Y ;i++) {
			n =arr[i];
			sum += preComputed[(int) (n & 0xff)] + preComputed[(int) ((n>>8) & 0xff)] ;
		}
		return sum;
	}
	
	private static int[] preComputed() {
		int arr[] = new int[256];
		for(int i=0; i<256; i++) {
			arr[i] = Long.bitCount(i);
		}
		return arr;
	}

}
