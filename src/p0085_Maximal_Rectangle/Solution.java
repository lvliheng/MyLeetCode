package p0085_Maximal_Rectangle;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("6 --> " + maximalRectangle(new char[][] {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
	}
	
	public static int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int result = 0, m = matrix.length, n = matrix[0].length;
        int[] height = new int[n + 1];
        
        for(int i = 0; i < m; i ++) {
        	Stack<Integer> stack = new Stack<>();
        	
        	for(int j = 0; j < n + 1; j++) {
        		if(j < n) {
        			height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0;
        		}
        		
        		while(!stack.isEmpty() && height[stack.peek()] >= height[j]) {
        			int curr = stack.pop();
        			result = Math.max(result, height[curr] * (stack.isEmpty() ? j : (j - stack.peek() - 1)));
        		}
        		
        		stack.push(j);
        	}
        }
		
		return result;
    }

}
