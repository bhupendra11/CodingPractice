package com.codingpractice.codingBlocks.RecursionPrint;

public class PrintAndCountMazePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	System.out.println("Maze path count = "+countMazePath(0, 0, 2, 2));	
	//	printMazePath(0, 0, 2, 2, "");
		
		//for diuagonal move also
		System.out.println("Maze path count diagonal = "+countMazePathDiagonal(0, 0, 2, 2));	
		printMazePathDiagonal(0, 0, 2, 2, "");
	}

	private static void printMazePath(int cr, int cc, int er, int ec, String soFar) {
		if(cr==er && cc==ec) {
			System.out.println(soFar);
			return;
		}
		
		if(cr>er || cc>ec) {
			return ;
		}
		
		//horizontal move
		printMazePath(cr, cc+1, er, ec, "H"+soFar);
		
		//vertoical move
		printMazePath(cr+1, cc, er, ec, "V"+soFar);
	}
	
	private static int countMazePath(int cr, int cc, int er, int ec) {
		if(er==cr && cc==ec) {
			return 1;
		}
		
		if(cr>er ||cc>ec) {
			return 0;
		}
		
		int count=0;
	
		count +=countMazePath(cr, cc+1, er, ec); //horizontal
		count += countMazePath(cr+1, cc, er, ec); //vertical
				
		return count;
	}
	
	private static void printMazePathDiagonal(int cr, int cc, int er, int ec, String soFar) {
		if(cr==er && cc==ec) {
			System.out.println(soFar);
			return;
		}
		
		if(cr>er || cc>ec) {
			return ;
		}
		
		//horizontal move
		printMazePathDiagonal(cr, cc+1, er, ec, "H"+soFar);
		
		//vertoical move
		printMazePathDiagonal(cr+1, cc, er, ec, "V"+soFar);
		
		//diagonal move
		printMazePathDiagonal(cr+1, cc+1, er, ec, "D"+soFar);
	}
	
	private static int countMazePathDiagonal(int cr, int cc, int er, int ec) {
		if(er==cr && cc==ec) {
			return 1;
		}
		
		if(cr>er ||cc>ec) {
			return 0;
		}
		
		int count=0;
	
		count +=countMazePathDiagonal(cr, cc+1, er, ec); //horizontal
		count += countMazePathDiagonal(cr+1, cc, er, ec); //vertical
		count +=countMazePathDiagonal(cr+1, cc+1, er, ec); //diagonal
				
		return count;
	}
}

