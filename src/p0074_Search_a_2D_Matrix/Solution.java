package p0074_Search_a_2D_Matrix;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("true --> " + searchMatrix2(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
		System.out.println("false --> " + searchMatrix2(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13));
		System.out.println("false --> " + searchMatrix2(new int[][] {{1}}, 2));
	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n;
        
        while(left < right) {
        	int mid = left + (right - left) / 2;
        	
        	if(matrix[mid / n][mid % n] < target) {
        		left = mid + 1;
        	} else {
        		right = mid;
        	}
        }
		
		if(right / n >= m || right % n >= n) return false;
		
		return matrix[right / n][right % n] == target;
    }
	
	public static boolean searchMatrix2(int[][] matrix, int target) {
		if(matrix.length == 0 || matrix[0].length == 0) return false;
		
		int i = 0, j = matrix[0].length - 1;
        
        while(i < matrix.length && j >= 0) {
        	if(matrix[i][j] == target) {
        		return true;
        	} else if(matrix[i][j] < target) {
        		i++;
        	} else { 
        		j--;
        	}
        }
		
		return false;
    }

}
