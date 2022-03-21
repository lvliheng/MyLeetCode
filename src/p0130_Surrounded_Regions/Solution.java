package p0130_Surrounded_Regions;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("["
				+ "[\"X\",\"X\",\"X\",\"X\"],"
				+ "[\"X\",\"X\",\"X\",\"X\"],"
				+ "[\"X\",\"X\",\"X\",\"X\"],"
				+ "[\"X\",\"O\",\"X\",\"X\"]"
				+ "] --> ");
		
		solve2(new char[][] {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}});
	}
	
	public static void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        
        int m = board.length, n = board[0].length;
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(i == 0 || i == m - 1 || j == 0 || j == n - 1) {
        			if(board[i][j] == 'O') {
        				helper(board, i, j);
        			}
        		}
        	}
        }
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(board[i][j] == 'O') board[i][j] = 'X';
        		if(board[i][j] == '$') board[i][j] = 'O';
        	}
        }
        
        for(char[] list : board) {
        	for(char item : list) {
        		System.out.print(item + " ");
        	}
        	
        	System.out.println();
        }
    }
	
	private static void helper(char[][] board, int x, int y) {
		int m = board.length, n = board[0].length;
		
		int[][] dp = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
		board[x][y] = '$';
		
		for(int i = 0; i < dp.length; i++) {
			int dx = x + dp[i][0], dy = y + dp[i][1];
			
			if(dx >= 0 && dx < m && dy >= 0 && dy < n && board[dx][dy] == 'O') {
				helper(board, dx, dy);
			}
		}
	}
	
	public static void solve2(char[][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1){
					if(board[i][j] == 'O') {
						helper2(board, i, j);
					}
				}
			}
		}
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == 'O') board[i][j] = 'X';
				if(board[i][j] == '$') board[i][j] = 'O';
			}
		}
		
		for(char[] list : board) {
        	for(char item : list) {
        		System.out.print(item + " ");
        	}
        	
        	System.out.println();
        }
	}
	
	private static void helper2(char[][] board, int x, int y) {
		if(board[x][y] == 'O') {
			board[x][y] = '$';
			
			if(x > 0 && board[x - 1][y] == 'O') {
				helper2(board, x - 1, y);
			}
			if(x < board.length - 1 && board[x + 1][y] == 'O') {
				helper2(board, x + 1, y);
			}
			if(y > 0 && board[x][y - 1] == 'O') {
				helper2(board, x, y - 1);
			}
			if(y < board[x].length - 1 && board[x][y + 1] == 'O') {
				helper2(board, x, y + 1);
			}
		}
	}

}
