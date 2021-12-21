package p0059_Spiral_Matrix_II;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("[[1,2,3],[8,9,4],[7,6,5]] --> ");
		printResult(generateMatrix(3));
		
		System.out.println("[[1]] --> ");
		printResult(generateMatrix(1));
		
		System.out.println("[[1,2,3,4],[12,13,14,5],[11,16,15,6],[10,9,8,7]] --> ");
		printResult(generateMatrix(4));
	}
	
	public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
		int left = 0, top = 0, right = n - 1, bottom = n - 1;
		int value = 1;
		
		while(true) {
			for(int i = left; i <= right; i++) {
				result[top][i] = value++;
			}
			if(++top > bottom) break;
			
			for(int j = top; j <= bottom; j++) {
				result[j][right] = value++;
			}
			if(left > --right) break;
			
			for(int p = right; p >= left; p--) {
				result[bottom][p] = value++;
			}
			if(top > --bottom) break;
			
			for(int q = bottom; q >= top; q--) {
				result[q][left] = value++;
			}
			if(++left > right) break;
		}
        
        return result;
    }
	
	private static void printResult(int[][] result) {
		for(int[] list : result) {
			for(int item : list) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
		
		System.out.println();
	}

	
}
