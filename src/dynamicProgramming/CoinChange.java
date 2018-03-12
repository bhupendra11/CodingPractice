package dynamicProgramming;

public class CoinChange {

	public static void main(String args[]) {

		int a[] = { 1, 7, 10 };
		int sum = 16;
		int count = coinChangeRecursive(sum, a);
		System.out.println("Count = "+count);

	}

	public static int coinChangeRecursive(int sum, int a[]) {

		if (sum == 0)
			return 0;

		int min = Integer.MAX_VALUE;
		int curMin = 0;
		for (int i = 0; i < a.length; i++) {

			if (sum - a[i] >= 0) {
				int smallerAns = coinChangeRecursive(sum - a[i], a);
				if (smallerAns != Integer.MAX_VALUE) {
					min = Math.min(min, smallerAns + 1);
				}
			}
		}

		return min;
	}
	
	
	public static int coinChangeBottomUpDp(int sum, int a[]) {
		
		int dp[] = new int[a.length+1];
		
		
		
		return 0;
	}

}
