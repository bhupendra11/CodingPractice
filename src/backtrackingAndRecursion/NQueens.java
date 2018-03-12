package backtrackingAndRecursion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @author : Bhupendra Shekhawat
 */
public class NQueens {

	public static void main(String args[]) {

		String[] boardArr = { "........", "........","........","........","........","........","........","........"  };

		List<String> board = Arrays.asList(boardArr);
		List<List<String>> result = new ArrayList<>();
		Solve(board, 0, result);

		for (List<String> list : result) {
			for (String s : list) {
				System.out.println(s);
			}
			System.out.println();
		}

	}

	public static boolean Solve(List<String> board, int col, List<List<String>> result) {

		if (col == board.size()) { // base case
			// board filled
			result.add(new ArrayList<String>(board));
			return true;
		}

		for (int rowToTry = 0; rowToTry < board.size(); rowToTry++) {

			if (isSafe(board, rowToTry, col)) {
				placeQueen(board, rowToTry, col);
				
				Solve(board, col + 1, result);
				/*if (Solve(board, col + 1, result))
					return true;*/
				removeQueen(board, rowToTry, col);
			}

		}

		return false;

	}

	private static void removeQueen(List<String> board, int row, int col) {
		// TODO Auto-generated method stub
		String cur = board.get(row);
		char temp[] = cur.toCharArray();
		temp[col] = '.';
		board.set(row, new String(temp));

	}

	private static void placeQueen(List<String> board, int row, int col) {

		String cur = board.get(row);
		char temp[] = cur.toCharArray();
		temp[col] = 'Q';
		board.set(row, new String(temp));

	}
	
	/*
	 * A utiliy function to check if it is safe to place queen at (row, col)
	 * Note: Since already col queens are placed in rows 0 to col-1
	 * we onlyu need to check the left side for attacking queens
	 */

	private static boolean isSafe(List<String> board, int row, int col) {

		// check row  left side
		for (int i = 0; i < col; i++) {
			if (board.get(row).charAt(i) == 'Q')
				return false;
		}

		//upper left diagonal check
		for(int i= row, j=col ; i>=0 && j>=0; i--, j--) {
			if (board.get(i).charAt(j) == 'Q')
				return false;
		}
		
		//for lower left diagonal
		for(int i=row, j=col ; i<board.size() && j>=0 ; i++, j-- ) {
			if (board.get(i).charAt(j) == 'Q')
				return false;
		}

		return true;
	}

}
