package p0063_Unique_Paths_II;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("2 --> " + uniquePathsWithObstacles(new int[][] {{0,0,0},{0,1,0},{0,0,0}}));
		System.out.println("1 --> " + uniquePathsWithObstacles(new int[][] {{0,1},{0,0}}));
		System.out.println("0 --> " + uniquePathsWithObstacles(new int[][] {{0,0},{0,1}}));
		System.out.println("1 --> " + uniquePathsWithObstacles(new int[][] {{0}}));
		System.out.println("0 --> " + uniquePathsWithObstacles(new int[][] {{1, 0}}));
	}
	
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] result = new int[m][n];
		
		result[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
		
		for(int i = 1; i < m; i++) {
			if(obstacleGrid[i][0] == 1) {
				result[i][0] = 0;
			} else {
				result[i][0] = result[i - 1][0];
			}
		}
		
		for(int j = 1; j < n; j++) {
			if(obstacleGrid[0][j] == 1) {
				result[0][j] = 0;
			} else {
				result[0][j] = result[0][j - 1];
			}
		}
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				if(obstacleGrid[i][j] == 1) {
					result[i][j] = 0;
				} else {
					result[i][j] = result[i - 1][j] + result[i][j - 1];
				}
			}
		}
		
		return result[m - 1][n - 1];
    }
}
