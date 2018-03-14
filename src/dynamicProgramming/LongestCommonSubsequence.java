package dynamicProgramming;

public class LongestCommonSubsequence {
	
	public static void main(String args[]){
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String str1 = "ABCDGHLQR";
        String str2 = "AEDPHR";
        
        int result = lcs.lcsBottomUp(str1, str2);
        System.out.print(result);
    }

	 public static int lcsRecursive(String s1, String s2){
		    
		    if(s1.length()==0 || s2.length()==0)return 0;
		      
		      if(s1.charAt(0) == s2.charAt(0)){
		        return 1+ lcsRecursive(s1.substring(1) , s2.substring(1));
		      }
		      else{
		        int op1 = lcsRecursive(s1.substring(1), s2);
		        int op2 = lcsRecursive(s1, s2.substring(1));
		        return Math.max(op1, op2);
		      }
		  }
	
	public static int lcsBottomUp(String s1, String s2){
	     int n = s1.length();
	     int m = s2.length();
	     int arr[][] = new int[n+1][m+1];
	     int max =0;
	     for(int i=1; i<=n ;i++){
	       for(int j=1; j<=m ;j++){
	         
	         if(s1.charAt(i-1)==s2.charAt(j-1)){
	           arr[i][j] = arr[i-1][j-1]+1;
	         }
	         else{
	           arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
	         }
	         
	         if(arr[i][j] > max){
	                    max = arr[i][j];
	          }
	         
	       }
	     }
	     
	     return max;
	     
	   }
	
	
	
		//NOT WORKING
		 /*public static int lcsTopDown(String s1, String s2, int i, int j , int arr[][]){
	      if(s1.length()==0 || s2.length()==0
	        || i >= s1.length() || j >=s2.length()
	        )return 0;
	      
	      if(arr[s1.length()][s2.length()] != -1){
	        return arr[s1.length()][s2.length()];
	      }
	     
	      if(s1.charAt(0) == s2.charAt(0)){
	        arr[s1.length()][s2.length()] = 1+ lcsTopDown(s1.substring(1) , s2.substring(1),
	                                 i+1, j+1, arr);
	      }
	      else{
	        int op1 = lcsTopDown(s1.substring(1), s2, i+1, j, arr);
	        int op2 = lcsTopDown(s1, s2.substring(1),i, j+1, arr );
	        arr[s1.length()][s2.length()] = Math.max(op1, op2);
	      }
	     
	      return arr[s1.length()][s2.length()];
	   }*/

}
