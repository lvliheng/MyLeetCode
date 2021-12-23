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
        
        for(int p = 1; p < m; p++) {
        	for(int q = 1; q < n; q++) {
        		result[p][q] = result[p - 1][q] + result[p][q - 1];
        	}
        }
		
		return result[m - 1][n - 1];
    }

}
