package p0062_Unique_Paths;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("28 --> " + uniquePaths(3, 7));
		System.out.println("3 --> " + uniquePaths(3, 2));
	}
	
	public static int uniquePaths(int m, int n) {
        int[][] result = new int[m][n];
        
        for(int i = 0; i < m; i++) {
        	result[i][0] = 1;
        }
        
        for(int j = 0; j < n; j++) {
        	result[0][j] = 1;
        }
        
        for(int i = 1; i < m; i++) {
        	for(int j = 1; j < n; j++) {
        		result[i][j] = result[i - 1][j] + result[i][j - 1];
        	}
        }
		
		return result[m - 1][n - 1];
    }

}
