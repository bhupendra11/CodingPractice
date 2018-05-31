package HKETests.DEShaw;

import java.util.ArrayList;

public class TravellingAnt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*for(int i=1 ; i<=5;i++) {
			System.out.println(neighbors(i));
		}*/
		
		System.out.println(ways(0,1));
		System.out.println(ways(3,1));
		System.out.println(ways(4,1));
		//long ip = 106594051736531905;
		
		
		/*long ip = 106594051736531905L;
		long dp[][] = new long[ip][ip];
		
		System.out.println(ways(ip, 1));*/
		
		
		for(int i=0 ;i<20;i++) {
			System.out.println(ways(i,1));
		}
	}
   
	
	private static long ways(long trips , int start) {
		if(trips ==0 && start==1)return 1;
		
		if(trips==0 && start!=1)return 0;
		
		ArrayList<Integer> nbrs = neighbors(start);
		return (long) (ways(trips-1, nbrs.get(0))%(Math.pow(10, 9)+7)  + ways(trips-1, nbrs.get(1)));
		
	}
	
	
	
	private static boolean isPair(int a, int b) {
		ArrayList<Pair> allPaths = getAllPaths();
		
		Pair cur = new Pair(a, b);
		
		return allPaths.contains(cur);
	}
	
	private static class Pair{
		int a;
		int b;
		
		public Pair(int a, int b) {
			this.a =a;
			this.b =b;
		}
	}
	
	private static ArrayList<Pair> getAllPaths(){
		ArrayList<Pair> list = new ArrayList<>();
		list.add(new Pair(1, 2));
		list.add(new Pair(2, 1));
		list.add(new Pair(2, 3));
		list.add(new Pair(3, 2));
		list.add(new Pair(3, 4));
		list.add(new Pair(4, 3));
		list.add(new Pair(4, 5));
		list.add(new Pair(5, 4));
		list.add(new Pair(5, 1));
		list.add(new Pair(1, 5));
		return list;
	}
	
	
	private static ArrayList<Integer> neighbors(int n){
		ArrayList<Integer> res = new ArrayList<>();
		
		//left
		if(n==1) {
			res.add(5);
		}
		else res.add(n-1);
		
		//right
		if(n==5) {
			res.add(1);
		}
		else res.add(n+1);
		return res;
	}
}
