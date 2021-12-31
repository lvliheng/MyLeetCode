package p0073_Set_Matrix_Zeroes;

public class Solution {

	public static void main(String[] args) {
		
		System.out.print("[[1,0,1],[0,0,0],[1,0,1]] --> ");
		setZeroes(new int[][] {{1,1,1},{1,0,1},{1,1,1}});
		
		System.out.print("[[0,0,0,0],[0,4,5,0],[0,3,1,0]] --> ");
		setZeroes(new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}});
		System.out.print("[[0],[0] --> ");
		setZeroes(new int[][] {{0},{1}});
	}
	
	public static void setZeroes(int[][] matrix) {
		boolean hasZeroInRow = false;
		boolean hasZeroInCol = false;
		
		for(int i = 0; i < matrix[0].length; i++) {
        	if(matrix[0][i] == 0) hasZeroInRow = true;
		}
		for(int j = 0; j < matrix.length; j++) {
			if(matrix[j][0] == 0) hasZeroInCol = true;
    	}
		
		for(int i = 1; i < matrix.length; i++) {
        	for(int j = 1; j < matrix[0].length; j++) {
        		if(matrix[i][j] == 0) {
        			matrix[0][j] = 0;
        			matrix[i][0] = 0;
        		}
        	}
		}
		
		for(int i = 1; i < matrix.length; i++) {
        	for(int j = 1; j < matrix[0].length; j++) {
        		if(matrix[0][j] == 0 || matrix[i][0] == 0) {
        			matrix[i][j] = 0;
        		}
        	}
		}
		
		if(hasZeroInRow) {
			for(int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		}
		if(hasZeroInCol) {
			for(int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
		
        
        for(int i = 0; i < matrix.length; i++) {
        	for(int j = 0; j < matrix[0].length; j++) {
        		System.out.print(matrix[i][j]);
        	}
        	System.out.print(" ");
        }
        System.out.println();	
    }

}
