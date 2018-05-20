package codingBlocks.RecursionPrint;

import java.util.Arrays;

public class NQueensCount {
	
	private static int n;

	public static void main(String args[]) {
		n =4; 
		
		boolean board[][] = new boolean[n][n];
		for(boolean[] arr : board) {
			Arrays.fill(arr, false);
		}
		
		System.out.println(nQueensCount(board, 0));
		printNQueens(board, 0, "");
	}
	
	public static int nQueensCount(boolean[][] board, int row) {
		
		if(row==board.length)return 1;
		
		int count =0;
		for(int col =0; col<board.length;col++) {
			if(isSafe(board, row, col)) {
				board[row][col] =true;
				count  =count +nQueensCount(board, row+1);
				board[row][col]=false;
			}
		}
		return count;
		
	}
	
	public static void printNQueens(boolean[][] board , int row, String result) {
		
		if(row==board.length) {
			System.out.println(result);
			return;
		}
		
		for(int col=0; col<board.length;col++) {
			if(isSafe(board, row, col)) {
				board[row][col]=true;
			//	result += "("+row+","+col+"), ";
				printNQueens(board, row+1, result+ "("+row+","+col+"), ");
				board[row][col]=false;
			}
		}
		return;
		
		
	}
	
	private static boolean isSafe(boolean[][] board, int row, int col) {
		
		//check vertical
		for(int i=0; i<row;i++) {
			if(board[i][col])return false;
		}
		//check left diag
		int i=row-1, j=col-1;
		while(i >=0 && j>=0) {
			if(board[i][j])return false;
			i--;
			j--;
		}
		
		//check right diag
		i=row-1; j=col+1;
		while(i >=0 && j<board.length) {
			if(board[i][j])return false;
			i--;
			j++;
		}
		return true;
	}
	
	/*private static void placeQueen(int x, int y , int board[][]) {
		board[x][y] =1;
	}
	
	private static void removeQueen(int x, int y , int board[][]) {
		board[x][y] =0;
	}*/
}
