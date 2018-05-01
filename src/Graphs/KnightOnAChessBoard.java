package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KnightOnAChessBoard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Dimensions of the chessboard
		int N = 8;
		int M = 8;

		int x1 = 1, y1 = 1;
		int x2 = 8, y2 = 8;

		int res = knight(N, M, x1, y1, x2, y2);
		System.out.println(res);

	}

	public static int knight(int N, int M, int x1, int y1, int x2, int y2) {

		int[] dx = { 2, 1, -2, -1, -2, -1, 1, 2 };
		int[] dy = { 1, 2, 1, 2, -1, -2, -2, -1 };

		int[][] dis = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			Arrays.fill(dis[i], Integer.MAX_VALUE);
		}

		// do a Bfs

		Queue<Node> queue = new LinkedList<>();

		Node start = new Node(x1, y1);
		dis[x1][y1] = 0;
		queue.add(start);

		while (!queue.isEmpty()) {

			Node node = queue.poll();

			for (int i = 0; i < 8; i++) {

				int x = node.x + dx[i];
				int y = node.y + dy[i];

				if (isValid(x, y, N, M) && dis[x][y] > dis[node.x][node.y] + 1) {
					dis[x][y] = dis[node.x][node.y] + 1;
					queue.add(new Node(x, y));
				}

			}
		}

		if (dis[x2][y2] == Integer.MAX_VALUE)
			return -1;
		return dis[x2][y2];
	}

	private static boolean isValid(int x, int y, int N, int M) {
		if (x >= 1 && x <= N && y >= 1 && y <= M) {
			return true;
		}
		return false;
	}

	public static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
