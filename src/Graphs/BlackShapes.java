package Graphs;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;


/*
 input
 
 8 XOOOOOXXOX OOXXXXOOXX XXOXXOOXXO OXOXXXXXXO XOXXOXOXXX OOOOOOOXOO XOXXXOOXOX XXXOXOXXXO
 */
public class BlackShapes {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String arr[] = new String[n];
		for(int i=0; i<n ;i++) {
			arr[i] = sc.next();
		}
		sc.close();
		/*for(String s: arr) {
			System.out.println(s);
		}*/
		int res =black(arr);
		
		
		System.out.println(res);
		
	}
	
    public static int black(String[] A) {
        
        int n = (A.length > A[0].length()) ? A.length : A[0].length();
        
      //  Graph g = new Graph(n);
       
        
        int N = A.length;
        int M = A[0].length();
        
        Graph g = new Graph(N*M);
        
        int[][] mat = new int[N][M];
        int[][] id = new int[N][M];
        
        int count =0;
        int zeroCount =0;
        for(int i=0 ;i < A.length;i++){
            String str = A[i];
            for(int j=0; j<str.length();j++){
                if(str.charAt(j)=='X'){
                    mat[i][j] =1;
                }
                id[i][j] = count;
                count++;
                
                if(str.charAt(j)=='O') {
                	zeroCount++;
                }
            }
           
        }
        
        
        
        
        //make grapg edges 
        for(int i=0 ;i < mat.length;i++) {
        	for(int j=0; j < mat[0].length;j++) {
        		
        		if(mat[i][j]==1) {
        			
        		
	        		if(isValid(N, M, i-1, j) && mat[i-1][j]==1) {
	        			g.addEdge(id[i][j], id[i-1][j] );
	        		}
	        		if(isValid(N, M, i, j-1) && mat[i][j-1]==1) {
	        			g.addEdge(id[i][j], id[i][j-1] );
	        		}
	        		if(isValid(N, M, i+1, j) && mat[i+1][j]==1) {
	        			g.addEdge(id[i][j], id[i+1][j] );
	        		}
	        		if(isValid(N, M, i, j+1) && mat[i][j+1]==1) {
	        			g.addEdge(id[i][j], id[i][j+1] );
	        		}
        		}
        		
        	}
        	//System.out.println();
        }
        
       /* for(int i=0; i<N*M ;i++) {
        	System.out.println(g.adj[i]);
        }*/
        
        /*for(int i=0 ;i < mat.length;i++) {
        	for(int j=0; j < mat[0].length;j++) {
        		System.out.print(id[i][j]);
        	}
        	System.out.println();
        }*/
        
        
        CC cc = new CC(g, mat);
        return cc.getCcCount()-zeroCount;
    }
    
    public static boolean isValid(int N , int M, int x, int y) {
    	if(x >=0 && x<N && y>=0 && y<M) {
    		return true;
    	}
    	return false;
    }
    
    public static class CC{
        private  int count;
        private  boolean visited[];
        private  int id[];
        
        public CC(Graph g, int[][] mat){
            count=0;
            visited = new boolean[g.V];
            id= new int[g.V];
            
            for(int v=0; v<g.V;v++){
                if(!visited[v] ){
                    dfs(g,v);
                    count++;
                }
                
            }
        }
        
        private  boolean connected(int u, int v){
            return id[u]==id[v];
        }
        
        public  void dfs(Graph g , int v){
            visited[v] =true;
            id[v] =count;
            for(int w : g.adj[v]){
                if(!visited[w]){
                    dfs(g,w);
                }
            }
        }
        public  int getCcCount(){
            return count;
        }
        
        
    }
    
    public  static class Graph {

    	public final int V;
    	public TreeSet<Integer>[] adj;
    	
    	
    	public Graph(int v) {
    		this.V = v;
    		adj = new TreeSet[v];
    		for(int i=0; i<v ;i++) {
    			adj[i] = new TreeSet<>();
    		}
    	}
    	
    	public void addEdge(int u, int v) {
    		adj[u].add(v);
    		adj[v].add(u);
        }
    }

}
