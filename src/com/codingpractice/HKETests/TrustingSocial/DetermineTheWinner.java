package com.codingpractice.HKETests.TrustingSocial;

import java.util.Scanner;

public class DetermineTheWinner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int s[] = new int[4];
		int d[] = new int[4];
		int f[] = new int[4];
		int c[] = new int[4];
		
		
		for(int t=0; t<T ;t++) {
			
			for(int i=0; i<4;i++) {
				s[i] = sc.nextInt();
			}
			for(int i=0; i<4;i++) {
				d[i] = sc.nextInt();
			}
			for(int i=0; i<4;i++) {
				f[i] = sc.nextInt();
			}
			for(int i=0; i<4;i++) {
				c[i] = sc.nextInt();
			}
			
			int scoreFlash = score(s,d,f);
			int scoreCisco = score(s,d,c);
			
			//System.out.println(scoreCisco+"  "+scoreFlash);
			
			if(scoreFlash!=scoreCisco) {
				String winner  = scoreCisco>scoreFlash?"Cisco":"Flash";
				System.out.println(winner);
			}
			else {
				int timeCisco = time(c);
				int timeFlash = time(f);
				if(timeCisco!=timeFlash) {
					String winner  = timeCisco>timeFlash?"Flash":"Cisco";
					System.out.println(winner);

				}
				else {
					System.out.println("Tie");
				}
			}
			
		}
		
		
	}
	
	private static int score(int[] s, int[] d, int cur[]) {
		int sum =0;
		
		for(int i=0; i<4;i++) {
			sum += Math.max(s[i]-cur[i]*d[i] , s[i]/2);
		}
		return sum;
	}
	
	private static int time(int[] arr) {
		int max = Integer.MIN_VALUE;
		for(int i:arr) {
			if(i>max)max =i;
		}
		return max;
	}
	
	

}
