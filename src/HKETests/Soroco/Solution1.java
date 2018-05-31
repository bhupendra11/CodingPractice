package HKETests.Soroco;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Game game;
		System.out.println("Welcome");

		while (true) {
			game = new Game(4, 3);
			game.start();

			// System.out.println();

		}

	}

	public static class Game {

		private char matrix[][];
		int colArr[];
		int rows;
		int cols;
		int filledCols;
		Scanner sc;

		public Game(int row, int col) {
			matrix = new char[row][col];
			colArr = new int[col];
			filledCols = 0;
			this.rows = row;
			this.cols = col;

			sc = new Scanner(System.in);

			for (int i = 0; i < row; i++) {
				Arrays.fill(matrix[i], '-');
			}

			for (int i = 0; i < col; i++) {
				colArr[i] = row - 1;
			}
		}

		private void start() {

			System.out.println("Game started");
			printGame();
			while (filledCols < cols) {

				System.out.println("Enter ball and col");

				String line = sc.nextLine();
				String arr[] = line.split(" ");

				char c = arr[0].charAt(0);
				int col = Integer.parseInt(arr[1]);

				boolean isAdded = this.add(c, col);

				if (!isAdded) {
					System.out.println("Please try another column");
				}

				printGame();

			}

			System.out.println("game finished");
			return;
		}

		private boolean add(char c, int col) {
			if (colArr[col] < 0) {
				return false;
			}
			int row = colArr[col];
			matrix[row][col] = c;
			colArr[col]--;

			if (colArr[col] < 0) {
				filledCols++;
			}

			

			if (clearRow(row)) {

				colArr[col]++;
				
			}
			return true;
		}

		private boolean clearRow(int row) {

			char firstChar = matrix[row][0];

			for (int i = 0; i < cols; i++) {
				if (matrix[row][i] != firstChar) {
					return false;
				}
			}
			// all are same so clear row
			for (int i = 0; i < row; i++) {
				matrix[row][i] = '#';
			}

			// from this row to the top, drop all balls
			int curRow = row;
			for (int i = 0; i < cols; i++) {
				curRow = row;

				while (curRow - 1 >= 0 && matrix[curRow][i] != '-') {
					matrix[curRow][i] = matrix[curRow - 1][i];
					curRow--;

				}
				if (curRow - 1 < 0) {
					matrix[curRow][i] = '-';
				}

			}
			// decrease the top position for every column
			for (int i = 0; i < row; i++) {
				colArr[i]++;
			}

			

			return true;
		}

		private void printGame() {
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					System.out.print(matrix[i][j] + " ");

				}
				System.out.println();
			}
			System.out.println();
		}

		/*
		 * private boolean clearCol(int col) {
		 * 
		 * char firstChar = matrix[rows-1][col];
		 * 
		 * for(int i=0; i<rows ;i++) { if(matrix[i][col] !=firstChar) { return false; }
		 * } //all are same so clear col for(int i=0; i<rows ;i++) { matrix[i][col]='-';
		 * }
		 * 
		 * colArr[col]=rows-1; filledCols--; return true; }
		 */

	}

}
