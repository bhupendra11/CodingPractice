package com.codingpractice.codingBlocks.RecursionGet;
import java.util.ArrayList;

public class GetBoardPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> paths = getBoardPaths(0, 10);
		System.out.println("Total paths = " + paths.size());
		System.out.println(paths);

	}

	private static ArrayList<String> getBoardPaths(int curr, int end) {
		if (curr > end) {
			ArrayList<String> base = new ArrayList<>();
			return base;
		}

		if (curr == end) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;
		}
		ArrayList<String> mr = new ArrayList<>();
		for (int dice = 1; dice <= 6; dice++) {

			ArrayList<String> rr = getBoardPaths(curr + dice, end);
			for (String rrs : rr) {
				mr.add(dice + rrs);
			}

		}
		return mr;

	}

}
