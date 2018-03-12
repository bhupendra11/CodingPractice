package string;

public class KMPAlgorithm {
	
	public static void main(String args[]) {
		String parent = "abxabcabcaby";
		String pattern = "bcabc";
		System.out.println("=========KMP Search ========");
		System.out.println("Parent string : "+parent+"   Pattern to be searched : "+pattern);
		int res = kmp(parent.toCharArray(), pattern.toCharArray());
		System.out.println("Pattern found at index : "+ res);
	}
	
	
	public static int kmp(char[] S, char[] P) {
		int res=0;
		int n = S.length;
		int m = P.length;
		int[] lps = computeTemporaryArray(P);//makeLps(P, m);
		System.out.print("LPS =  " );
		for(int i=0; i<lps.length;i++) {
			System.out.print(lps[i]+" ");
		}
		
		System.out.println();
		
		int i=0,j=0;
		while(i<n) {
			if(S[i]==P[j]) {
				if(j==m-1) { //matched
					return i-j;   //return starting position in parent string
				}
				else {
					i++;
					j++;
				}
				
			}
			else if(j>0) {
				j = lps[j-1];
			}
			else {
				i++;
			}
			
			
		}
		
		
		return -1;		
	}
	
	
	
	
	public static int[] makeLps(char[] P, int m) {
		int[] lps = new int[m];
		
		int i=1, j=0;
		lps[0] =0;
		while(i<m) {
			if(P[i]==P[j]) {
				lps[i] = j+1;
				i++;
				j++;
			}
			else {
				if(j>0) {
					j = lps[j-1];
				}
				else {
					lps[i]=0;
					i++;
				}
			}
		}
		
		/*System.out.println("LPS =" );
		for(int p :lps) {
			System.out.print(lps[p]+" ");
		}*/
		
		return lps;
	}
	
	
	private static int[] computeTemporaryArray(char pattern[]){
        int [] lps = new int[pattern.length];
        int index =0;
        for(int i=1; i < pattern.length;){
            if(pattern[i] == pattern[index]){
                lps[i] = index + 1;
                index++;
                i++;
            }else{
                if(index != 0){
                    index = lps[index-1];
                }else{
                    lps[i] =0;
                    i++;
                }
            }
        }
        return lps;
    }
	

}