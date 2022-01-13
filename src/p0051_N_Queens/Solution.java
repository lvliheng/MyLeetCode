package p0051_N_Queens;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {

		System.out.println("[[.Q..,...Q,Q...,..Q.],[..Q.,Q...,...Q,.Q..]] --> " + solveNQueens(4));
	}

	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();

		helper(n, 0, new int[n], result);

		return result;
	}

	private static void helper(int n, int current, int[] row, List<List<String>> result) {
		if (current == n) {
			List<String> temp = new ArrayList<>();
			for (int i = 0; i < row.length; i++) {
				StringBuilder s = new StringBuilder();
				for (int j = 0; j < row.length; j++) {
					if (row[i] == j) {
						s.append("Q");
					} else {
						s.append(".");
					}
				}
				temp.add(s.toString());
			}
			result.add(temp);
			return;
		}

		for (int i = 0; i < n; i++) {
			row[current] = i;
			if (isValid(current, row)) {
				helper(n, current + 1, row, result);
			}
		}
	}

	private static boolean isValid(int current, int[] row) {
		for (int i = 0; i < current; i++) {
			if (row[current] == row[i] || Math.abs(row[current] - row[i]) == current - i) {
				return false;
			}
		}

		return true;
	}

}
