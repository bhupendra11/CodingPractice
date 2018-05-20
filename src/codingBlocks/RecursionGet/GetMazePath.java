package codingBlocks.RecursionGet;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GetMazePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Maze Path without diagonal move ---");
		System.out.println(getMazePath(0, 0, 2, 2));
		
		System.out.println("\n Maze path with diagonal move");
		System.out.println(getMazePathDiagonal(0, 0, 2, 2));

	}
	
	private static ArrayList<String> getMazePath(int cr, int cc, int er, int ec){
		
		if(cr ==er && cc==ec) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		if(cr > er || cc > ec) {
			ArrayList<String> base = new ArrayList<>();
			return base;
		}
		
		ArrayList<String> mr = new ArrayList<>();
		//horizontal move
		ArrayList<String> rrh = getMazePath(cr, cc+1, er, ec);		
		for(String rrhs : rrh) {
			mr.add("H"+rrhs);
		}
		
		ArrayList<String> rrv = getMazePath(cr+1, cc, er, ec);
		for(String rrvs: rrv) {
			mr.add("V"+rrvs);
		}
		
		return mr;
 	}
	
	
	private static ArrayList<String> getMazePathDiagonal(int cr, int cc, int er, int ec){
		if(cr==er && cc==ec) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		
		if(cr >er || cc>ec) {
			ArrayList<String> base = new ArrayList<>();
			return base;
		}
				
		ArrayList<String> mr = new ArrayList<>();
		
		//move horizontal
		ArrayList<String> rrh = getMazePathDiagonal(cr, cc+1, er, ec);
		for(String rrhs : rrh) {
			mr.add("H"+rrhs);
		}
		
		//move veritical
		ArrayList<String> rrv = getMazePathDiagonal(cr+1, cc, er, ec);
		for(String rrvs : rrv) {
			mr.add("V"+rrvs);
		}
		
		//move diagonal
		ArrayList<String> rrd = getMazePathDiagonal(cr+1, cc+1, er, ec);
		for(String rrds: rrd) {
			mr.add("D"+rrds);
		}
		
		return mr;
	}
}
