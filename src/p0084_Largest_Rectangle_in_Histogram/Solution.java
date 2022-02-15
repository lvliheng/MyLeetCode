package p0084_Largest_Rectangle_in_Histogram;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("10 --> " + largestRectangleArea(new int[] {2,1,5,6,2,3}));
	}
	
	public static int largestRectangleArea(int[] heights) {
        int result = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        int i = 0;
        for(i = 0; i < heights.length; i++) {
        	while(!stack.empty() && heights[stack.peek()] >= heights[i]) {
        		int curr = stack.pop();
        		result = Math.max(result, heights[curr] * (stack.empty() ? i : (i - stack.peek() - 1)));
        	}
        	
        	stack.push(i);
        }
        
        while(!stack.empty()) {
        	int curr = stack.pop();
        	result = Math.max(result, heights[curr] * (stack.empty() ? i : (i - stack.peek() - 1)));
        }
		
		return result;
    }

}
