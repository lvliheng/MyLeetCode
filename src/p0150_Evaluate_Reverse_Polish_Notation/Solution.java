package p0150_Evaluate_Reverse_Polish_Notation;

import java.util.Stack;

class Solution {
    
	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		
		for(String token : tokens) {
			if(token.equals("+")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b + a);
			} else if(token.equals("-")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b - a);
			} else if(token.equals("*")){
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b * a);
			} else if(token.equals("/")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b / a);
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		
		return stack.pop();
    }
}