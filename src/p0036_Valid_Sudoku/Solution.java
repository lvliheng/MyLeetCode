package p0036_Valid_Sudoku;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("isValidSudoku: true --> " + isValidSudoku(
				new char[][] {
					 {'5','3','.','.','7','.','.','.','.'}
					,{'6','.','.','1','9','5','.','.','.'}
					,{'.','9','8','.','.','.','.','6','.'}
					,{'8','.','.','.','6','.','.','.','3'}
					,{'4','.','.','8','.','3','.','.','1'}
					,{'7','.','.','.','2','.','.','.','6'}
					,{'.','6','.','.','.','.','2','8','.'}
					,{'.','.','.','4','1','9','.','.','5'}
					,{'.','.','.','.','8','.','.','7','9'}
				}));
	}
	
	public static boolean isValidSudoku(char[][] board) {
		
		for(char[] row : board) {
			boolean[] items = new boolean[9];
			for(char item : row) {
				if(item == '.') continue;
				if(items[item - '1']) {
					return false;
				}
				items[item - '1'] = true;
			}
		}
		
		for(int i = 0; i < 9; i++) {
			boolean[] items = new boolean[9];
			for(int j = 0; j < 9; j++) {
				char item = board[j][i];
				if(item == '.') continue;
				if(items[item - '1']) {
					return false;
				}
				items[item - '1'] = true;
			}
		}
		
		for(int i = 0; i < 9; i += 3) {
			for(int j = 0; j < 9; j += 3) {
				boolean[] items = new boolean[9];
				for(int m = i; m <= i + 2; m++) {
					for(int n = j; n <= j + 2; n++) {
						char item = board[m][n];
						if(item == '.') continue;
						if(items[item - '1']) {
							return false;
						}
						items[item - '1'] = true;
					}
				}
			}
		}
		
		return true;
	}

}
