package Graphs;

import java.util.HashSet;
import java.util.Set;

public class NumberOfIslannds {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { { 1, 1, 0, 1 },
						{ 0, 0, 1, 0}, 
						{ 1, 0, 1, 0}, 
						{ 1, 1, 0, 1}};

		boolean visited[][] = new boolean[4][4];
		int component[][] = new int[4][4];

		numberOfIslands(arr, visited, 0, 0, component);
		Set<Integer> islands = new HashSet<>();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <4; j++) {
				System.out.print(component[i][j]+" ");
				islands.add(component[i][j]);
			}
			System.out.println();

		}
		
		System.out.println(islands.size()-1);
		
		
	}

	private static void numberOfIslands(int[][] arr, boolean visited[][], int x, int y, int component[][]) {

		if (!isValid(x, y, 4,4))
			return;

		int island = 1;
		for (int i = x; i < 4; i++) {
			for (int j = y; j < 4; j++) {

				dfs(arr, visited, i, j, island, component);
				island++;

			}
			

		}

	}

	private static void dfs(int[][] arr, boolean[][] visited, int i, int j, int island, int[][] component) {

		if (!isValid(i, j, 4, 4))
			return;

		if (!visited[i][j]) {

			if (arr[i][j] == 0) {
				visited[i][j] = true;
				return;
			} else {
				component[i][j] = island;
				visited[i][j] = true;
				
				if(isValid(i+1, j, 4, 4) && arr[i+1][j]==1)
					dfs(arr, visited, i + 1, j, island, component);
				if(isValid(i, j+1, 4, 4) &&  arr[i][j+1]==1)
					dfs(arr, visited, i, j + 1, island, component);
				if(isValid(i-1, j, 4, 4) &&  arr[i-1][j]==1)
					dfs(arr, visited, i - 1, j, island, component);
				if(isValid(i, j-1, 4, 4) &&  arr[i][j-1]==1)
					dfs(arr, visited, i, j - 1, island, component);
			}
		}

		return;
	}

	private static boolean isValid(int i, int j, int x, int y) {

		return i >= 0 && i < x && j >= 0 && j < y;
	}

}
