package HKETests.SamsungRnD;

import java.util.HashMap;import java.util.Map;
import java.util.Scanner;

public class OddSumProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashMap<Integer, Integer>  map = new HashMap<>();
		int arr[] = new int[N];
		for(int i=0; i<N ;i++) {
			arr[i] = sc.nextInt();
			
			/*if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}
			else {
				map.put(arr[i], 1);
			}*/
			
		}
		
		/*for(int i : map.keySet()) {
			System.out.println(i+" "+map.get(i));
		}*/
		
		
		
		
		int Q = sc.nextInt();
		for(int i=0; i<Q ;i++) {
			int L = sc.nextInt();
			int R = sc.nextInt();

			for(int j=L-1;j<=R-1 ;j++) {
				if(map.containsKey(arr[j])) {
					map.put(arr[j], map.get(arr[j])+1);
				}
				else {
					map.put(arr[j], 1);
				}
			}
			
			int res = sum(map, L-1, R-1, arr);
			System.out.println(res);
			map=new HashMap<>();
		}
		
		sc.close();
	}

	private static int sum(HashMap<Integer, Integer> map, int L , int R , int arr[] ) {
		int sum =0;
		
		for(int i=L;i<=R ;i++) {
			if(map.containsKey(arr[i]) && map.get(arr[i])%2 !=0) {
				sum += arr[i] * map.get(arr[i]);
				map.remove(arr[i]);
			}
		}
		
		
		return sum;
	}
}
