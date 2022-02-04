package p0037_Sudoku_Solver;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("["
				+ "[5,3,4,6,7,8,9,1,2],\n"
				+ "[6,7,2,1,9,5,3,4,8],\n"
				+ "[1,9,8,3,4,2,5,6,7],\n"
				+ "[8,5,9,7,6,1,4,2,3],\n"
				+ "[4,2,6,8,5,3,7,9,1],\n"
				+ "[7,1,3,9,2,4,8,5,6],\n"
				+ "[9,6,1,5,3,7,2,8,4],\n"
				+ "[2,8,7,4,1,9,6,3,5],\n"
				+ "[3,4,5,2,8,6,1,7,9]"
				+ "]");
		
		System.out.println();
		
		solveSudoku2(new char[][] {
			 {'5','3','.','.','7','.','.','.','.'},
			 {'6','.','.','1','9','5','.','.','.'},
			 {'.','9','8','.','.','.','.','6','.'},
			 {'8','.','.','.','6','.','.','.','3'},
			 {'4','.','.','8','.','3','.','.','1'},
			 {'7','.','.','.','2','.','.','.','6'},
			 {'.','6','.','.','.','.','2','8','.'},
			 {'.','.','.','4','1','9','.','.','5'},
			 {'.','.','.','.','8','.','.','7','9'}
		});
	}
	
	public static void solveSudoku(char[][] board) {
        helper(board, 0, 0);
        
        printResult(board);
    }
	
	private static boolean helper(char[][] board, int i, int j) {
		if(i == 9) return true;
		
		if(j >= 9) return helper(board, i + 1, 0);
		
		if(board[i][j] != '.') return helper(board, i, j + 1);
		
		for(char c = '1'; c <= '9'; c++) {
			if(!isValid(board, i, j, c)) continue;
			
			board[i][j] = c;
			
			if(helper(board, i, j + 1)) return true;
			
			board[i][j] = '.';
		}
		
		return false;
	}
	
	private static boolean isValid(char[][] board, int i, int j, char val) {
		for(int x = 0; x < 9; x++) {
			if(board[x][j] == val) return false;
		}
		
		for(int y = 0; y < 9; y++) {
			if(board[i][y] == val) return false;
		}
		
		int row = i - i % 3, col = j - j % 3;
		
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 3; y++) {
				if(board[x + row][y + col] == val) return false;
			}
		}
		
		return true;
	}
	
	public static void solveSudoku2(char[][] board) {
		helper2(board);
		
		printResult(board);
	}
	
	private static boolean helper2(char[][] board) {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(board[i][j] != '.') continue;
				
				for(char c = '1'; c <= '9'; c++) {
					if(!isValid2(board, i, j, c)) continue;
					
					board[i][j] = c;
					
					if(helper2(board)) return true;
					
					board[i][j] = '.';
				}
				
				return false;
			}
		}
		
		return true;
	}
	
	private static boolean isValid2(char[][] board, int i, int j, char val) {
		for(int k = 0; k < 9; k++) {
			if(board[k][j] != '.' && board[k][j] == val) return false;
			
			if(board[i][k] != '.' && board[i][k] == val) return false;
			
			int row = i / 3 * 3 + k / 3, col = j / 3 * 3 + k % 3;
			
			if(board[row][col] != '.' && board[row][col] == val) return false;
		}
		
		return true;
	}
	
	private static void printResult(char[][] board) {
		for(char[] item : board) {
        	for(char innerItem : item) {
        		System.out.print(innerItem + " ");
        	}
        	System.out.println();
        }
	}
}
