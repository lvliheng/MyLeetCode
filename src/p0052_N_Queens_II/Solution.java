package p0052_N_Queens_II;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("2 --> " + totalNQueens(4));
	}
	
	public static int totalNQueens(int n) {
		return helper(new int[n], 0, 0);
    }
	
	private static int helper(int[] pos, int row, int result) {
		if(row == pos.length) {
			return ++result;
		}
		
		for(int col = 0; col < pos.length; col++) {
			if(isValid(pos, row, col)) {
				pos[row] = col;
				result = helper(pos, row + 1, result);
				pos[row] = -1;
			}
		}
		
		return result;
	}
	
	private static boolean isValid(int[] pos, int row, int col) {
		for(int i = 0; i < row; i++) {
			if(col == pos[i] || Math.abs(col - pos[i]) == Math.abs(row - i)){
				return false;
			}
		}
		
		return true;
	}

}
