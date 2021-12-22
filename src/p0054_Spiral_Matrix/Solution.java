package p0054_Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("[1,2,3,6,9,8,7,4,5] --> " + spiralOrder(new int[][] {{1,2,3},{4,5,6},{7,8,9}}));
		System.out.println("[1,2,3,4,8,12,11,10,9,5,6,7] --> " + spiralOrder(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
	}
	
	public static List<Integer> spiralOrder(int[][] matrix) {
		if(matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
		
        List<Integer> result = new ArrayList<>();
		int m = matrix.length - 1, n = matrix[0].length - 1;
		int left = 0, top = 0, right = n, bottom = m;
		
        while(true) {
        	for(int i = left; i <= right; i++) {
    			result.add(matrix[top][i]);
    		}
    		if(++top > bottom) break;
    		
    		for(int j = top; j <= bottom; j++) {
    			result.add(matrix[j][right]);
    		}
    		if(left > --right) break;
    		
    		for(int p = right; p >= left; p--) {
    			result.add(matrix[bottom][p]);
    		}
    		if(top > --bottom) break;
    		
    		for(int q = bottom; q >= top; q--) {
    			result.add(matrix[q][left]);
    		}
    		if(++left > right) break;
        }
		
		return result;
    }

}
