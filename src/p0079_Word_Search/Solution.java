package p0079_Word_Search;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("true --> " + exist(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
		System.out.println("true --> " + exist(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE"));
	}
	
	public static boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[0].length; j++) {
        		if(search(board, word, 0, i, j)) {
        			return true;
        		}
        	}
        }
		
		return false;
    }
	
	private static boolean search(char[][] board, String word, int index, int i, int j) {
		if(index == word.length()) return true;
		
		if(i < 0 || j < 0 || i >= board.length || j >= board[0].length 
				|| board[i][j] != word.charAt(index)) {
			return false;
		}
		
		char temp = board[i][j];
		board[i][j] = '0';
		
		if(search(board, word, index + 1, i + 1, j) 
				|| search(board, word, index + 1, i, j + 1) 
				|| search(board, word, index + 1, i - 1, j) 
				|| search(board, word, index + 1, i, j - 1)) {
			return true;
		}
		
		board[i][j] = temp;
		
		return false;
	}

}
