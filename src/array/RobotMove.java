package array;

import java.util.ArrayList;

public class RobotMove {

	public static void main(String args[]) {
		String inst ="UDDLLRUUUDUURUDDUULLDRRRR";
		ArrayList<Integer> coord= moves(inst);
		System.out.println(coord.get(0)+"  "+coord.get(1));
	}
	
	
	public static ArrayList<Integer> moves(String instructions ) {
		ArrayList<Integer> coord= new ArrayList<>();
		int x=0, y=0;
		for(char c : instructions.toCharArray()) {
			if(c=='U') {
			    	y--;
			    
			}
			else if(c=='D') {
				y++;
			}
			else if(c=='R') {
				x++;
			}
			else if(c=='L') {
				x--;
			}
		}
		
		coord.add(x);
		coord.add(y);
		return coord;
	}
}
