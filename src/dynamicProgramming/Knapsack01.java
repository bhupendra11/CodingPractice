package dynamicProgramming;

/**
 * 
 * @author Bhupendra Shekhawat
 *
 */

public class Knapsack01 {

	public static void main(String args[]) {
		Knapsack01 k = new Knapsack01();
		int val[] = { 22, 20, 15, 30, 24, 54, 21, 32, 18, 25 };
		int wt[] = { 4, 2, 3, 5, 5, 6, 9, 7, 8, 10 };
		int bu = k.knapsackBU(wt, val, 30);
		int td = k.knapsackTopDown(wt,val, 30);
		System.out.println(bu);
		System.out.println(td);
	}
	
	public  int knapsackTopDown(int[] weight,int value[],int maxWeight){

	      int n = weight.length;
	      int m = maxWeight;
	      int arr[][] = new int[n+1][m+1];
	      
	      for(int i=0; i<=n ;i++){
	        for(int j=0; j<=m ;j++){
	          arr[i][j] = -1;
	        }        
	      }      
	     return knapsackTopDown(weight,value,0, maxWeight, arr);
		}
		

	private  int knapsackTopDown(int[] weight, int value[], int start, int maxWeight, int[][] arr) {

		if (start == weight.length)
			return 0;
		if (maxWeight == 0)
			return 0;

		// check if already present
		if (arr[start][maxWeight] != -1) {
			return arr[start][maxWeight];
		}

		// take weight[start]
		int option1 = 0, option2 = 0;

		if (weight[start] <= maxWeight) {
			option1 = value[start] + knapsackTopDown(weight, value, start + 1, maxWeight - weight[start], arr);
		}
		// do not take weight[start]
		option2 = knapsackTopDown(weight, value, start + 1, maxWeight, arr);

		// System.out.println("("+option1+" , "+option2+")");
		arr[start][maxWeight] = Math.max(option1, option2);

		return arr[start][maxWeight];
	}
	
	public  int knapsackBU(int[] weight, int value[] ,int maxWeight){
	      int n = weight.length;
	      int m = maxWeight;
	      int arr[][] = new int[n+1][m+1];
	    	
	      for(int i=0; i<=n ;i++){
	        for(int w=0; w<=m ;w++){
	          	if(i==0 || w==0){
	              arr[i][w] =0;
	            }
	          	//else if(weight[i-1] <= maxWeight){
	           else if(w - weight[i-1] >= 0){
	            	arr[i][w] = Math.max(value[i-1]+ arr[i-1][w-weight[i-1]],
	                                       arr[i-1][w]);
	          	}
	          	else{
	            	arr[i][w] = arr[i-1][w];
	          	}
	          
	        }
	      }
	    
	      return arr[n][m];
	    }  
}
