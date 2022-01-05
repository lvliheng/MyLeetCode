package p0020_Valid_Parentheses;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("isValid: " + isValid("(}{)"));
		System.out.println("isValid: " + isValid("()[]{}"));
		System.out.println("isValid: " + isValid("{[]}"));
		System.out.println("isValid: " + isValid("()[]}{"));
		System.out.println("isValid: " + isValid("(){}}{"));
	}
	
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		
		for(Character item : s.toCharArray()) {
			if(item == '(' || item == '[' ||item == '{') {
				stack.push(item);
			} else {
				if(stack.empty()) {
					return false;
				}
				if(item == ')' && stack.peek() != '(') {
					return false;
				}
				if(item == ']' && stack.peek() != '[') {
					return false;
				}
				if(item == '}' && stack.peek() != '{') {
					return false;
				}
				stack.pop();
			}
		}
		
		return stack.empty();
	}

}
