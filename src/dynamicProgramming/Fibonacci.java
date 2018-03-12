package dynamicProgramming;

public class Fibonacci {

	public static void main(String args[]) {
		int n =45;
		
		int dp[] = new int[n+1];
		for(int i=0; i<=n ;i++) {
			dp[i] =-1;
		}
		int bottomUp = fibBottomUp(n);
		int topDown = fibTopDown(n, dp);
		int rec = recFib(n);
		
		System.out.println("Res recursive "+ rec);
		System.out.println("Res BottomUp = "+ bottomUp);
		System.out.println("Res TopDown = "+ topDown);
		System.out.println("Res fibOptimized = "+ fibOptimized(n));
		
	}
	
	
	public static int recFib(int n) {
		
		if(n==0 || n==1)return n;
		else return recFib(n-1)+recFib(n-2);
		
		
	}
	
	//toDown Fibonacci	
	public static int fibTopDown(int n , int dp[]) {
		
		if(n==0 || n==1) {
			dp[n] = n;
			return n;
		}
		
		//already computed
		if(dp[n] != -1) {
			return dp[n];
		}
		else {
			dp[n] = fibTopDown(n-1, dp)+ fibTopDown(n-2, dp);
		}
		return dp[n];
	}
	
	//bottomUp 
	public static int fibBottomUp(int n ) {
		int dp[] = new int[n+1];
		dp[0]=0;
		dp[1] = 1;
		
		for(int i=2; i<=n ;i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
	
	
	//fibonacci DP optimized
	public static int fibOptimized(int n ) {
		int a =0;
		int b =1;
		int c=0;
		
		if(n==0 || n==1)return n;
		
		for(int i=2;i<=n ;i++) {
			c= a+b;
			a=b;
			b=c;
		}
		
		return c;
	
	}
}
