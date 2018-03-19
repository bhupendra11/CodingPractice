package backtrackingAndRecursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllUniquePermutations {
	
	public static void main(String args[]) {
		AllUniquePermutations perms = new AllUniquePermutations();
		int arr[] = {1,2,3};
		int result[][] = permute(arr);
		
		for(int i=0; i<result.length;i++) {
			for(int j=0; j<result[i].length;j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static int[][] permute(int[] A) {
        ArrayList<Integer> soFar = new ArrayList<>();
        ArrayList<Integer> rest = new ArrayList<>();
        
        for(int i : A){
            rest.add(i);
        }
        
        
        
        int n = A.length;
         Set<ArrayList<Integer>> set = new HashSet<>();
         
         permute(soFar, rest, n, set);
       //  System.out.println("Set size "+set.size() );
         int[][] result = new int[set.size()][n];
         
         int i=0;
         for(ArrayList<Integer> curList : set){
             result[i] = convertIntegers(curList);
             System.out.println("CurList "+ curList);
             i++;
         }
         
        /* for(int i=0; i<set.size() ;i++){
             result[i] = set.get(i).toArray();
         }*/
        
        return result;
        
    }
    
    public static void permute(ArrayList<Integer> soFar, ArrayList<Integer> rest, int n,
                Set<ArrayList<Integer>> list)
    {
        if(rest.size()==0){
            System.out.println("rest =0  =--- sofar  = "+soFar);
            list.add(new ArrayList<Integer>(soFar));
            //soFar=new ArrayList<Integer>();
            return;
        }
        else{
            for(int i=0; i<rest.size() ;i++){
                int cur = rest.get(i);
                ArrayList<Integer> remaining = new ArrayList<>();
              //  remaining.addAll(rest.subList(0,i));
               // remaining.addAll(rest.subList(i+1,rest.size()));
                remaining.addAll(rest);
                remaining.remove(i);
                System.out.println("After remove remaining ="+remaining);
               
                soFar.add(cur);
                 System.out.println("After add soFar ="+soFar);
                //ArrayList<Integer> soFarNow = new ArrayList<>(soFar);
                permute(soFar, remaining, n, list);
                soFar.remove(soFar.size()-1);
            }
        }
        
        
    }
    
    public static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }
}
