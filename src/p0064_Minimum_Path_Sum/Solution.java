package p0064_Minimum_Path_Sum;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("7 --> " + minPathSum(new int[][] {{1,3,1},{1,5,1},{4,2,1}}));
		System.out.println("12 --> " + minPathSum(new int[][] {{1,2,3},{4,5,6}}));
	}
	
	public static int minPathSum(int[][] grid) {
		if(grid.length == 0 || grid[0].length == 0) return 0;
		
		int m = grid.length, n = grid[0].length;
		int[][] result = new int[m][n];
		result[0][0] = grid[0][0];
		
        for(int i = 1; i < m; i++) {
        	result[i][0] = grid[i][0] + result[i - 1][0];
        }
        for(int j = 1; j < n; j++) {
        	result[0][j] = grid[0][j] + result[0][j - 1];
        }
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				result[i][j] = grid[i][j] + Math.min(result[i - 1][j], result[i][j - 1]);
			}
		}
        
        return result[m - 1][n - 1];
    }

}
