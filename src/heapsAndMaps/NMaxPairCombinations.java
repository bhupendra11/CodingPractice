package heapsAndMaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NMaxPairCombinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {1,2};
		int B[] = {3,4};
		
		int[] res = solve(A, B);
		
		for(int i : res){
			System.out.print(i+" ");
		}
		
	}

	private static  int[] solve(int[] A, int[] B) {
		
		
		int n = A.length;
		Arrays.sort(A);
		Arrays.sort(B);
		int[] res = new int[n];
		/*PriorityQueue<Integer> pqA = new PriorityQueue<>();
		PriorityQueue<Integer> pqB = new PriorityQueue<>();
		
		for(int i=0; i<n;i++) {
			pqA.add(A[i]);
			pqB.add(B[i]);
		}*/
		
		
		//res[0] = A[n-1]+B[n-1];
		int count=0;
		//for(int i=0; i<n ;i++) {
			/*int topA = pqA.remove();
			int topB = pqB.remove();
			
			int secA = pqA.peek();
			int secB = pqB.peek();*/
			
			
		//}
		
		int L = n-1;
		int R = n-1;
		while(count< n) {
			
			res[count]= A[L]+B[R];
			count++;
			if(count!= n) {
				res[count] = A[L-1] +B[R];
				count++;
			}
			
			if(count!= n) {
				res[count] = A[L]+B[R-1];
				count++;
			}
			
			L--;
			R--;
			
		}
		
		return res;
		
    }
	
	
}
