package p0048_Rotate_Image;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		
		System.out.print("rotate: [[7,4,1],[8,5,2],[9,6,3]] --> ");
		rotate(new int[][] {{1,2,3},{4,5,6},{7,8,9}});
		System.out.println();
		System.out.print("rotate: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]] --> ");
		rotate(new int[][] {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}});
		System.out.println();
		System.out.print("rotate: [[1]] --> ");
		rotate(new int[][] {{1}});
		System.out.println();
		System.out.print("rotate: [[3,1],[4,2]] --> ");
		rotate(new int[][] {{1,2},{3,4}});
		System.out.println();
	}
	
	public static void rotate(int[][] matrix) {
        
		for(int m = 0; m < matrix.length / 2; m++) {
			int[] temp = matrix[m];
			matrix[m] = matrix[matrix.length - 1 - m];
			matrix[matrix.length - 1 - m] = temp;
		}
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = i + 1; j < matrix.length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		for(int[] item : matrix) {
			System.out.print(Arrays.toString(item));
		}
    }

}
